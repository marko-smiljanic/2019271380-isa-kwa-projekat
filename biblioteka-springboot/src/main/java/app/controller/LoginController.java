package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.dto.KorisnikDTO;
import app.dto.TokenDTO;
import app.service.UserDetailsServiceImpl;
import app.utils.TokenUtils;


@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private UserDetailsService userDetailsService;

//	@Autowired
//	private KorisnikService korisnikService;
//
//	@Autowired
//	private PermissionService permissionService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	//logovanje za prava pristupa na serverskoj stranu (za koriscenje anotacije secured. Za klijentsku stranu moramo kroz generisani token koji vraca server
	//tokom logovanja, vratiti roles kroz payloads
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<TokenDTO> login(@RequestBody KorisnikDTO korisnik) {
		try {
			// Kreiranje tokena za login, token sadrzi korisnicko ime i lozinku.
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					korisnik.getKorisnickoIme(), korisnik.getLozinka());
			// Autentifikacija korisnika na osnovu korisnickog imena i lozinke.
			Authentication authentication = authenticationManager.authenticate(token);
			// Dodavanje uspesne autentifikacije u security context.
			SecurityContextHolder.getContext().setAuthentication(authentication);

			// Ucitavanje podatka o korisniku i kreiranje jwt-a. Zbog cega ovde ne koristim user details impl?
			UserDetails userDetails = userDetailsService.loadUserByUsername(korisnik.getKorisnickoIme());
			String jwt = tokenUtils.generateToken(userDetails);
			TokenDTO jwtDTO = new TokenDTO(jwt);

			return new ResponseEntity<TokenDTO>(jwtDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<TokenDTO>(HttpStatus.UNAUTHORIZED);
		}
	}

//	@RequestMapping(path = "/register", method = RequestMethod.POST)
//	public ResponseEntity<KorisnikDTO> register(@RequestBody KorisnikDTO korisnik) {
//		// Novi korisnik se registruje kreiranjem instance korisnika
//		// cija je lozinka enkodovana.
//		Korisnik noviKorisnik = new Korisnik(null, korisnik.getKorisnickoIme(),
//				passwordEncoder.encode(korisnik.getLozinka()));
//		noviKorisnik = korisnikService.save(noviKorisnik);
//		// Dodavanje prava pristupa.
//		noviKorisnik.setUserPermissions(new HashSet<UserPermission>());
//		noviKorisnik.getUserPermissions()
//				.add(new UserPermission(null, noviKorisnik, permissionService.findOne(1l).get()));
//		korisnikService.save(noviKorisnik);
//
//		return new ResponseEntity<KorisnikDTO>(
//				new KorisnikDTO(noviKorisnik.getId(), noviKorisnik.getKorisnickoIme(), null), HttpStatus.OK);
//	}
	
}
