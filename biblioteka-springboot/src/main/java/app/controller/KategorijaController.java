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

import app.dto.KategorijaDTO;
import app.dto.Konverzija;
import app.model.Kategorija;
import app.service.KategorijaService;

@Controller
@RequestMapping(path = "api/kategorije")
@CrossOrigin(origins = "http://localhost:4200")
public class KategorijaController {
	
	@Autowired
	KategorijaService servis;
	
	
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<KategorijaDTO>> dobaviSve(){	
		ArrayList<KategorijaDTO> listadto = new ArrayList<KategorijaDTO>();		
		
		for(Kategorija n : this.servis.findAll()) {
			KategorijaDTO ndto = null;
			ndto = Konverzija.konvertujUDTO(n, KategorijaDTO.class);
			
			listadto.add(ndto);
		}			
		
		//vracanje dto rezultata
		return new ResponseEntity<Iterable<KategorijaDTO>>(listadto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)									
	public ResponseEntity<KategorijaDTO> dobaviJednu(@PathVariable("id") Long id){
		Kategorija n = this.servis.findById(id).orElse(null);	
		if(n == null) {
			return new ResponseEntity<KategorijaDTO>(HttpStatus.NOT_FOUND);
		}	
		
		
		//vracanje dto rezultata
		KategorijaDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, KategorijaDTO.class);
		return new ResponseEntity<KategorijaDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<KategorijaDTO> dodaj(@RequestBody KategorijaDTO nnn){   
		if(nnn == null) {
			return new ResponseEntity<KategorijaDTO>(HttpStatus.NOT_FOUND);
		} 								
		
		Kategorija n = this.servis.create(Konverzija.konvertujUEntitet(nnn, Kategorija.class));     
		
		//vracanje dto rezultata
		KategorijaDTO ndto = Konverzija.konvertujUDTO(n, KategorijaDTO.class);
		return new ResponseEntity<KategorijaDTO>(ndto, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<KategorijaDTO> izmeni(@PathVariable("id") Long id, @RequestBody Object nnn){
		Kategorija n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<KategorijaDTO>(HttpStatus.NOT_FOUND);
		}			
		Kategorija n2 = null;
		n2 = Konverzija.konvertujUEntitet(nnn, Kategorija.class);
		n2.setId(n.getId()); 
		n2 = this.servis.update(n2);
		
		//vracanje dto rezultata
		KategorijaDTO ndto = null;
		ndto = Konverzija.konvertujUDTO(n, KategorijaDTO.class);
		return new ResponseEntity<KategorijaDTO>(ndto, HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<KategorijaDTO> obrisi(@PathVariable("id") Long id){
		Kategorija n = this.servis.findById(id).orElse(null);
		if(n == null) {
			return new ResponseEntity<KategorijaDTO>(HttpStatus.NOT_FOUND);
		}	
		
		this.servis.delete(id);
		return new ResponseEntity<KategorijaDTO>(HttpStatus.OK);
	}
}
