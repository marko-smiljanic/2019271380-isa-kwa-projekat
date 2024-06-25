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

import app.dto.Konverzija;
import app.dto.RecenzijaDTO;
import app.model.Recenzija;
import app.service.RecenzijaService;

@Controller
@RequestMapping(path = "api/recenzije")
public class RecenzijaController {
	@Autowired
	RecenzijaService servis;
	
	
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<RecenzijaDTO>> dobaviSve(){	
		ArrayList<RecenzijaDTO> listadto = new ArrayList<RecenzijaDTO>();		
		
		for(Recenzija n : this.servis.findAll()) {
			RecenzijaDTO ndto = null;
			ndto = Konverzija.konvertujUDTO(n, RecenzijaDTO.class);
			
			listadto.add(ndto);
		}			
		
		//vracanje dto rezultata
		return new ResponseEntity<Iterable<RecenzijaDTO>>(listadto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)									
	public ResponseEntity<RecenzijaDTO> dobaviJednu(@PathVariable("id") Long id){
		Recenzija n = this.servis.findById(id).orElse(null);	
		if(n == null) {
			return new ResponseEntity<RecenzijaDTO>(HttpStatus.NOT_FOUND);
		}	
		
		
		//vracanje dto rezultata
		RecenzijaDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, RecenzijaDTO.class);
		return new ResponseEntity<RecenzijaDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<RecenzijaDTO> dodaj(@RequestBody RecenzijaDTO nnn){   
		if(nnn == null) {
			return new ResponseEntity<RecenzijaDTO>(HttpStatus.NOT_FOUND);
		} 								
		
		Recenzija n = this.servis.create(Konverzija.konvertujUEntitet(nnn, Recenzija.class));     
		
		//vracanje dto rezultata
		RecenzijaDTO ndto = Konverzija.konvertujUDTO(n, RecenzijaDTO.class);
		return new ResponseEntity<RecenzijaDTO>(ndto, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RecenzijaDTO> izmeni(@PathVariable("id") Long id, @RequestBody Object nnn){
		Recenzija n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<RecenzijaDTO>(HttpStatus.NOT_FOUND);
		}			
		Recenzija n2 = null;
		n2 = Konverzija.konvertujUEntitet(nnn, Recenzija.class);
		n2.setId(n.getId()); 
		n2 = this.servis.update(n2);
		
		//vracanje dto rezultata
		RecenzijaDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, RecenzijaDTO.class);
		return new ResponseEntity<RecenzijaDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<RecenzijaDTO> obrisi(@PathVariable("id") Long id){
		Recenzija n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<RecenzijaDTO>(HttpStatus.NOT_FOUND);
		}	
		
		this.servis.delete(id);
		return new ResponseEntity<RecenzijaDTO>(HttpStatus.OK);
	}
}
