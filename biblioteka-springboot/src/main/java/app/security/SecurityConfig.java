package app.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {
	@Autowired
	UserDetailsService uds;
	
	@Bean
	public AuthenticationManager authManagerBean(AuthenticationConfiguration conf) throws Exception {
		return conf.getAuthenticationManager();
	}
	
	@Bean 
	public PasswordEncoder getPasswordEncoder() { 
		//return new BCryptPasswordEncoder();                                                            //ovo radi samo za bcrypt encoder	
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("bcrypt", new BCryptPasswordEncoder());
		DelegatingPasswordEncoder pwEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);         //ako ne znamo koji ce se enkoder koristiti, znaci objekat koji sadrzi sve poodrzane enkodere
		pwEncoder.setDefaultPasswordEncoderForMatches(encoders.get("bcrypt"));                           //kada zapisujemo podatke lozinki u bazu, bice odabran enkoder i on ce enkodovati lozinku, zapisace kljuc koji je nacin enkodovane lozinke, ovako hocemo da zapisemo i bazu koji enkoder koristimo
		return pwEncoder;
	}
	
	@Bean
	public AuthTokenFilter authTokenFilterBean(AuthenticationConfiguration conf) throws Exception {
		AuthTokenFilter authTokenFilter = new AuthTokenFilter();
		authTokenFilter.setAuthenticationManager(conf.getAuthenticationManager());
		return authTokenFilter;
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http, AuthenticationConfiguration conf) throws Exception {    //csrf da onemogucimo da neko sa forme na drugom sajtu posalje zahtev za nas sajt, ovdse je iskljucujemo jer ce neko slati zahteve ko zna odakle jer je ovo rest api
		return http.csrf()
				.disable()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(authTokenFilterBean(conf), UsernamePasswordAuthenticationFilter.class)
				.build();  
	}
	
	
	
	
	
	
}
