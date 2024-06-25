package app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import app.utils.TokenUtils;

public class AuthTokenFilter extends UsernamePasswordAuthenticationFilter { 									//presrece zahtev i iz njega vadi zaglavlje i radi proveru sa tokenom
	@Autowired
	TokenUtils tokenUtils;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String token = ((HttpServletRequest) request).getHeader("Authorization");  
		//System.out.println(token);
		String korisnickoIme = tokenUtils.getUsername(token);
		if((korisnickoIme != null) && (SecurityContextHolder.getContext().getAuthentication() == null)) {      	//moramo proveriti da nije vec neko ulogovan
			UserDetails userDetails = userDetailsService.loadUserByUsername(korisnickoIme);
			if(tokenUtils.validateToken(token, userDetails)) {													//ako je token validan, onda ide zapisivanje podataka u security kontekst, da bi smo korisnika ulogovali u spring moramo kreirati token za logovanje, nema veze sa jwt
				UsernamePasswordAuthenticationToken authenticitationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());    //nije isto sto i jwt, ovo je drugi token!!!
				authenticitationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(((HttpServletRequest) request)));
				SecurityContextHolder.getContext().setAuthentication(authenticitationToken);
			}
		}
		super.doFilter(request, response, chain);
	}
}
