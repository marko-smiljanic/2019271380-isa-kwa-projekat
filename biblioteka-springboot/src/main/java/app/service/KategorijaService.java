package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Kategorija;
import app.repository.KategorijaRepository;

@Service
public class KategorijaService {
	@Autowired
	private KategorijaRepository repo;
	
	
	public KategorijaService() {
		// TODO Auto-generated constructor stub
	}
		
	
	public Iterable<Kategorija> findAll(){
		return this.repo.findAll();                                                          
	}
	
	public Optional<Kategorija> findById(Long id) {                        							
		return this.repo.findById(id);                             							
	}
	
	public Kategorija create(Kategorija nn) {
		return this.repo.save(nn);                                 							
	}
	
	public Kategorija update(Kategorija nn) {          													
		if(nn != null &&  this.findById(nn.getId()) != null) {                                          
			return this.repo.save(nn); 
		}
		return null;
	}
	
	public void delete(Kategorija nn) {
		this.repo.delete(nn);
	}
	
	public void delete(Long id) {
		this.repo.deleteById(id);
	}
}
