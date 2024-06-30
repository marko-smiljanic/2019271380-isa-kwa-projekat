package app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.dto.Konverzija;
import app.dto.KorisnikDTO;
import app.model.Korisnik;
import app.model.KorisnikHasPravo;
import app.model.PravoPristupa;
import app.service.KorisnikHasPravoService;
import app.service.KorisnikService;
import app.service.PravoPristupaService;

@Controller
@RequestMapping(path = "api/korisnici")
@CrossOrigin(origins = "http://localhost:4200")
public class KorisnikController {
	
	@Autowired
	KorisnikService servis;
	
	@Autowired
	PravoPristupaService pravoPristupaServis;
	
	@Autowired
	KorisnikHasPravoService korisnikHasPravoService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//@Secured("IS_AUTHENTICATED_FULLY") znači da samo potpuno autentifikovani korisnici mogu pristupiti tom resursu, što znači da korisnik mora biti ulogovan.
	//IS_AUTHENTICATED_REMEMBERED označava da korisnik može pristupiti resursu ako je autentifikovan, bilo direktno putem unosa korisničkih podataka ili putem mehanizama zapamćivanja sesije ili "remember me" funkcionalnosti.
	
	
	
	//@Secured({"ROLE_ADMIN", "ROLE_MENADZER"})
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<KorisnikDTO>> dobaviSve(){	
		ArrayList<KorisnikDTO> listadto = new ArrayList<KorisnikDTO>();		
		
		for(Korisnik n : this.servis.findAll()) {
			KorisnikDTO ndto = null;
			ndto = Konverzija.konvertujUDTO(n, KorisnikDTO.class);
			listadto.add(ndto);
		}
		
		return new ResponseEntity<Iterable<KorisnikDTO>>(listadto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)									
	public ResponseEntity<KorisnikDTO> dobaviJednu(@PathVariable("id") Long id){
		Korisnik n = this.servis.findById(id).orElse(null);	
		if(n == null) {
			return new ResponseEntity<KorisnikDTO>(HttpStatus.NOT_FOUND);
		}	
		
		//vracanje dto rezultata
		KorisnikDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, KorisnikDTO.class);

		return new ResponseEntity<KorisnikDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<KorisnikDTO> dodaj(@RequestBody KorisnikDTO nnn){   
		if(nnn == null) {
			return new ResponseEntity<KorisnikDTO>(HttpStatus.NOT_FOUND);
		} 								
		nnn.setLozinka(passwordEncoder.encode(nnn.getLozinka()));   
		Korisnik n = this.servis.create(Konverzija.konvertujUEntitet(nnn, Korisnik.class));     
		
		
		//setujem pravo pristupa po defaultu na ROLE USER. Dohvatasm po nazivu koji je unique, onda kreiram korisnik has pravo
		PravoPristupa pravoAdmin = this.pravoPristupaServis.pronadjiPravoPoNazivu("ROLE_USER").orElse(null);
		KorisnikHasPravo khp = new KorisnikHasPravo(null, n, pravoAdmin);
		khp = this.korisnikHasPravoService.create(khp);
		
		
		//vracanje dto rezultata
		KorisnikDTO ndto = Konverzija.konvertujUDTO(n, KorisnikDTO.class);
		return new ResponseEntity<KorisnikDTO>(ndto, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<KorisnikDTO> izmeni(@PathVariable("id") Long id, @RequestBody Object nnn){
		Korisnik n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<KorisnikDTO>(HttpStatus.NOT_FOUND);
		}			
		Korisnik n2 = null;
		n2 = Konverzija.konvertujUEntitet(nnn, Korisnik.class);
		n2.setId(n.getId()); 
		n2.setLozinka(passwordEncoder.encode(n2.getLozinka())); 
		n2 = this.servis.update(n2);
		
		//vracanje dto rezultata
		KorisnikDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, KorisnikDTO.class);
		return new ResponseEntity<KorisnikDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<KorisnikDTO> obrisi(@PathVariable("id") Long id){
		Korisnik n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<KorisnikDTO>(HttpStatus.NOT_FOUND);
		}	
		
		this.servis.delete(id);
		return new ResponseEntity<KorisnikDTO>(HttpStatus.OK);
	}
	
	
	
	
	

}
