package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Recenzija;
import app.repository.RecenzijaRepository;

@Service
public class RecenzijaService {
	@Autowired
	private RecenzijaRepository repo;
	
	
	public RecenzijaService() {
		// TODO Auto-generated constructor stub
	}
		
	
	public Iterable<Recenzija> findAll(){
		return this.repo.findAll();                                                          
	}
	
	public Optional<Recenzija> findById(Long id) {                        							
		return this.repo.findById(id);                             							
	}
	
	public Recenzija create(Recenzija nn) {
		return this.repo.save(nn);                                 							
	}
	
	public Recenzija update(Recenzija nn) {          													
		if(nn != null &&  this.findById(nn.getId()) != null) {                                          
			return this.repo.save(nn); 
		}
		return null;
	}
	
	public void delete(Recenzija nn) {
		this.repo.delete(nn);
	}
	
	public void delete(Long id) {
		this.repo.deleteById(id);
	}
}
