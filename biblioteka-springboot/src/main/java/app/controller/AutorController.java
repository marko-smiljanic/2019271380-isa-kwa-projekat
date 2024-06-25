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

import app.dto.AutorDTO;
import app.dto.Konverzija;
import app.model.Autor;
import app.service.AutorService;

@Controller
@RequestMapping(path = "api/autori")
public class AutorController {
	
	@Autowired
	AutorService servis;
	
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<AutorDTO>> dobaviSve(){	
		ArrayList<AutorDTO> listadto = new ArrayList<AutorDTO>();		
		
		for(Autor n : this.servis.findAll()) {
			AutorDTO ndto = null;
			ndto = Konverzija.konvertujUDTO(n, AutorDTO.class);
			
			listadto.add(ndto);
		}			
		return new ResponseEntity<Iterable<AutorDTO>>(listadto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)									
	public ResponseEntity<AutorDTO> dobaviJednu(@PathVariable("id") Long id){
		Autor n = this.servis.findById(id).orElse(null);	
		if(n == null) {
			return new ResponseEntity<AutorDTO>(HttpStatus.NOT_FOUND);
		}	
		
		//vracanje dto rezultata
		AutorDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, AutorDTO.class);

		return new ResponseEntity<AutorDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<AutorDTO> dodaj(@RequestBody AutorDTO nnn){   
		if(nnn == null) {
			return new ResponseEntity<AutorDTO>(HttpStatus.NOT_FOUND);
		} 								
		
		Autor n = this.servis.create(Konverzija.konvertujUEntitet(nnn, Autor.class));     
		
		AutorDTO ndto = Konverzija.konvertujUDTO(n, AutorDTO.class);
		return new ResponseEntity<AutorDTO>(ndto, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<AutorDTO> izmeni(@PathVariable("id") Long id, @RequestBody Object nnn){
		Autor n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<AutorDTO>(HttpStatus.NOT_FOUND);
		}			
		Autor n2 = null;
		n2 = Konverzija.konvertujUEntitet(nnn, Autor.class);
		n2.setId(n.getId()); 
		n2 = this.servis.update(n2);
		
		//vracanje dto rezultata
		AutorDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, AutorDTO.class);
		return new ResponseEntity<AutorDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<AutorDTO> obrisi(@PathVariable("id") Long id){
		Autor n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<AutorDTO>(HttpStatus.NOT_FOUND);
		}	
		
		this.servis.delete(id);
		return new ResponseEntity<AutorDTO>(HttpStatus.OK);
	}

}
