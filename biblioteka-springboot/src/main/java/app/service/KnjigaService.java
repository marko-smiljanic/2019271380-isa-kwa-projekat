package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Knjiga;
import app.repository.KnjigaRepository;

@Service
public class KnjigaService {
	@Autowired
	private KnjigaRepository repo;
	
	
	public KnjigaService() {
		// TODO Auto-generated constructor stub
	}
		
	
	public Iterable<Knjiga> findAll(){
		return this.repo.findAll();                                                          
	}
	
	public Optional<Knjiga> findById(Long id) {                        							
		return this.repo.findById(id);                             							
	}
	
	public Knjiga create(Knjiga nn) {
		return this.repo.save(nn);                                 							
	}
	
	public Knjiga update(Knjiga nn) {          													
		if(nn != null &&  this.findById(nn.getId()) != null) {                                          
			return this.repo.save(nn); 
		}
		return null;
	}
	
	public void delete(Knjiga nn) {
		this.repo.delete(nn);
	}
	
	public void delete(Long id) {
		this.repo.deleteById(id);
	}

}
