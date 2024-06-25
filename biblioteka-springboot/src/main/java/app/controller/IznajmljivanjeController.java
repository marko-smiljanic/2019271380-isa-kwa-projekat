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

import app.dto.IznajmljivanjeDTO;
import app.dto.Konverzija;
import app.model.Iznajmljivanje;
import app.service.IznajmljivanjeService;

@Controller
@RequestMapping(path = "api/iznajmljivanja")
public class IznajmljivanjeController {
	@Autowired
	IznajmljivanjeService servis;
	
	
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<IznajmljivanjeDTO>> dobaviSve(){	
		ArrayList<IznajmljivanjeDTO> listadto = new ArrayList<IznajmljivanjeDTO>();		
		
		for(Iznajmljivanje n : this.servis.findAll()) {
			IznajmljivanjeDTO ndto = null;
			ndto = Konverzija.konvertujUDTO(n, IznajmljivanjeDTO.class);
			
			listadto.add(ndto);
		}			
		
		//vracanje dto rezultata
		return new ResponseEntity<Iterable<IznajmljivanjeDTO>>(listadto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)									
	public ResponseEntity<IznajmljivanjeDTO> dobaviJednu(@PathVariable("id") Long id){
		Iznajmljivanje n = this.servis.findById(id).orElse(null);	
		if(n == null) {
			return new ResponseEntity<IznajmljivanjeDTO>(HttpStatus.NOT_FOUND);
		}	
		
		//vracanje dto rezultata
		IznajmljivanjeDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, IznajmljivanjeDTO.class);

		return new ResponseEntity<IznajmljivanjeDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<IznajmljivanjeDTO> dodaj(@RequestBody IznajmljivanjeDTO nnn){   
		if(nnn == null) {
			return new ResponseEntity<IznajmljivanjeDTO>(HttpStatus.NOT_FOUND);
		} 								
		
		Iznajmljivanje n = this.servis.create(Konverzija.konvertujUEntitet(nnn, Iznajmljivanje.class));     
		
		//vracanje dto rezultata
		IznajmljivanjeDTO ndto = Konverzija.konvertujUDTO(n, IznajmljivanjeDTO.class);
		return new ResponseEntity<IznajmljivanjeDTO>(ndto, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<IznajmljivanjeDTO> izmeni(@PathVariable("id") Long id, @RequestBody Object nnn){
		Iznajmljivanje n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<IznajmljivanjeDTO>(HttpStatus.NOT_FOUND);
		}			
		Iznajmljivanje n2 = null;
		n2 = Konverzija.konvertujUEntitet(nnn, Iznajmljivanje.class);
		n2.setId(n.getId()); 
		n2 = this.servis.update(n2);
		
		//vracanje dto rezultata
		IznajmljivanjeDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, IznajmljivanjeDTO.class);
		return new ResponseEntity<IznajmljivanjeDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<IznajmljivanjeDTO> obrisi(@PathVariable("id") Long id){
		Iznajmljivanje n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<IznajmljivanjeDTO>(HttpStatus.NOT_FOUND);
		}	
		
		this.servis.delete(id);
		return new ResponseEntity<IznajmljivanjeDTO>(HttpStatus.OK);
	}

}
