package app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.dto.Konverzija;
import app.dto.KorisnikHasPravoDTO;
import app.model.KorisnikHasPravo;
import app.service.KorisnikHasPravoService;

@Controller
@RequestMapping(path = "api/korisnikHasPravo")
@CrossOrigin(origins = "http://localhost:4200")
public class KorisnikHasPravoController {
	
	@Autowired
	KorisnikHasPravoService servis;
	
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<KorisnikHasPravoDTO>> dobaviSve(){			
		ArrayList<KorisnikHasPravoDTO> listadto = new ArrayList<KorisnikHasPravoDTO>();		
		
		for(KorisnikHasPravo n : this.servis.findAll()) {
			KorisnikHasPravoDTO ndto = null;
			ndto = Konverzija.konvertujUDTO(n, KorisnikHasPravoDTO.class);

			listadto.add(ndto);
		}			
		return new ResponseEntity<Iterable<KorisnikHasPravoDTO>>(listadto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)									
	public ResponseEntity<KorisnikHasPravoDTO> dobaviJednu(@PathVariable("id") Long id){
		KorisnikHasPravo n = this.servis.findById(id).orElse(null);	
		if(n == null) {
			return new ResponseEntity<KorisnikHasPravoDTO>(HttpStatus.NOT_FOUND);
		}	
		
		KorisnikHasPravoDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, KorisnikHasPravoDTO.class);
		
		return new ResponseEntity<KorisnikHasPravoDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<KorisnikHasPravoDTO> dodaj(@RequestBody KorisnikHasPravoDTO nnn){   
		if(nnn == null) {
			return new ResponseEntity<KorisnikHasPravoDTO>(HttpStatus.NOT_FOUND);
		} 								
		
		KorisnikHasPravo n = this.servis.create(Konverzija.konvertujUEntitet(nnn, KorisnikHasPravo.class));     
		
		KorisnikHasPravoDTO ndto = Konverzija.konvertujUDTO(n, KorisnikHasPravoDTO.class);
		return new ResponseEntity<KorisnikHasPravoDTO>(ndto, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<KorisnikHasPravoDTO> izmeni(@PathVariable("id") Long id, @RequestBody Object nnn){
		KorisnikHasPravo n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<KorisnikHasPravoDTO>(HttpStatus.NOT_FOUND);
		}			
		KorisnikHasPravo n2 = null;
		n2 = Konverzija.konvertujUEntitet(nnn, KorisnikHasPravo.class);
		n2.setId(n.getId()); 
		n2 = this.servis.update(n2);
		
		//vracanje dto rezultata
		KorisnikHasPravoDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, KorisnikHasPravoDTO.class);
		return new ResponseEntity<KorisnikHasPravoDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<KorisnikHasPravoDTO> obrisi(@PathVariable("id") Long id){
		KorisnikHasPravo n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<KorisnikHasPravoDTO>(HttpStatus.NOT_FOUND);
		}	
		
		this.servis.delete(id);		
		return new ResponseEntity<KorisnikHasPravoDTO>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	

}
