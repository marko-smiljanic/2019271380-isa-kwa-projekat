package app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.dto.KnjigaDTO;
import app.dto.Konverzija;
import app.model.Knjiga;
import app.service.KnjigaService;

@Controller
@RequestMapping(path = "api/knjige")
@CrossOrigin(origins = "http://localhost:4200")
public class KnjigaController {

	@Autowired
	KnjigaService servis;
	
	
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<KnjigaDTO>> dobaviSve(){	
		ArrayList<KnjigaDTO> listadto = new ArrayList<KnjigaDTO>();		
		
		for(Knjiga n : this.servis.findAll()) {
			KnjigaDTO ndto = null;
			ndto = Konverzija.konvertujUDTO(n, KnjigaDTO.class);
			
			listadto.add(ndto);
		}			
		
		//vracanje dto rezultata
		return new ResponseEntity<Iterable<KnjigaDTO>>(listadto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)									
	public ResponseEntity<KnjigaDTO> dobaviJednu(@PathVariable("id") Long id){
		Knjiga n = this.servis.findById(id).orElse(null);	
		if(n == null) {
			return new ResponseEntity<KnjigaDTO>(HttpStatus.NOT_FOUND);
		}	
		
		//vracanje dto rezultata
		KnjigaDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, KnjigaDTO.class);
		return new ResponseEntity<KnjigaDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<KnjigaDTO> dodaj(@RequestBody KnjigaDTO nnn){   
		if(nnn == null) {
			return new ResponseEntity<KnjigaDTO>(HttpStatus.NOT_FOUND);
		} 								
		
		Knjiga n = this.servis.create(Konverzija.konvertujUEntitet(nnn, Knjiga.class));     
		
		//vracanje dto rezultata
		KnjigaDTO ndto = Konverzija.konvertujUDTO(n, KnjigaDTO.class);
		return new ResponseEntity<KnjigaDTO>(ndto, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<KnjigaDTO> izmeni(@PathVariable("id") Long id, @RequestBody Object nnn){
		Knjiga n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<KnjigaDTO>(HttpStatus.NOT_FOUND);
		}			
		Knjiga n2 = null;
		n2 = Konverzija.konvertujUEntitet(nnn, Knjiga.class);
		n2.setId(n.getId()); 
		n2 = this.servis.update(n2);
		
		//vracanje dto rezultata
		KnjigaDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, KnjigaDTO.class);
		return new ResponseEntity<KnjigaDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<KnjigaDTO> obrisi(@PathVariable("id") Long id){
		Knjiga n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<KnjigaDTO>(HttpStatus.NOT_FOUND);
		}	
		
		this.servis.delete(id);
		return new ResponseEntity<KnjigaDTO>(HttpStatus.OK);
	}
}
