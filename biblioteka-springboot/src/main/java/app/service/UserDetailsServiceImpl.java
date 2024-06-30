package app.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.model.Korisnik;
import app.model.KorisnikHasPravo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	KorisnikService servis;
	
	
	//ovo je za logovanje korisnika za serversku stranu. Vracanje ugradjenog User objekta i postavljanje prava pristupa kroz jpa
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Korisnik> k = this.servis.findByKorisnickoIme(username);  									
		if(k.isPresent()) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();	                                 
			//grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));  									

			for(KorisnikHasPravo khp : k.get().getKorisnikHasPravo()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(khp.getPravoPistupa().getNaziv()));
			  	//System.out.println(khp.getPravoPistupa().getNaziv());
			}
			return new User(k.get().getKorisnickoIme(), k.get().getLozinka(), grantedAuthorities);
		}
		else {
			throw new UsernameNotFoundException("Korisnik sa korisnickim imenom: " + username + " nije pronadjen.");
	    }
	}
	
}
