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
import app.dto.PravoPristupaDTO;
import app.model.PravoPristupa;
import app.service.PravoPristupaService;

@Controller
@RequestMapping(path = "api/pravaPristupa")
public class PravoPristupaController {
	
	@Autowired
	PravoPristupaService servis;
	
	
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PravoPristupaDTO>> dobaviSve(){	
		ArrayList<PravoPristupaDTO> listadto = new ArrayList<PravoPristupaDTO>();		
		
		for(PravoPristupa n : this.servis.findAll()) {
			PravoPristupaDTO ndto = null;
			ndto = Konverzija.konvertujUDTO(n, PravoPristupaDTO.class);
			
			listadto.add(ndto);
		}			
		return new ResponseEntity<Iterable<PravoPristupaDTO>>(listadto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)									
	public ResponseEntity<PravoPristupaDTO> dobaviJednu(@PathVariable("id") Long id){
		PravoPristupa n = this.servis.findById(id).orElse(null);	
		if(n == null) {
			return new ResponseEntity<PravoPristupaDTO>(HttpStatus.NOT_FOUND);
		}	
		
		//vracanje dto rezultata
		PravoPristupaDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, PravoPristupaDTO.class);

		return new ResponseEntity<PravoPristupaDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<PravoPristupaDTO> dodaj(@RequestBody PravoPristupaDTO nnn){   
		if(nnn == null) {
			return new ResponseEntity<PravoPristupaDTO>(HttpStatus.NOT_FOUND);
		} 								
		
		PravoPristupa n = this.servis.create(Konverzija.konvertujUEntitet(nnn, PravoPristupa.class));     
		
		PravoPristupaDTO ndto = Konverzija.konvertujUDTO(n, PravoPristupaDTO.class);
		return new ResponseEntity<PravoPristupaDTO>(ndto, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PravoPristupaDTO> izmeni(@PathVariable("id") Long id, @RequestBody Object nnn){
		PravoPristupa n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<PravoPristupaDTO>(HttpStatus.NOT_FOUND);
		}			
		PravoPristupa n2 = null;
		n2 = Konverzija.konvertujUEntitet(nnn, PravoPristupa.class);
		n2.setId(n.getId()); 
		n2 = this.servis.update(n2);
		
		//vracanje dto rezultata
		PravoPristupaDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, PravoPristupaDTO.class);
		return new ResponseEntity<PravoPristupaDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PravoPristupaDTO> obrisi(@PathVariable("id") Long id){
		PravoPristupa n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<PravoPristupaDTO>(HttpStatus.NOT_FOUND);
		}	
		
		this.servis.delete(id);
		return new ResponseEntity<PravoPristupaDTO>(HttpStatus.OK);
	}
	
	
	

}
