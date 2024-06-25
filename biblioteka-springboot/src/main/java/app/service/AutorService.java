package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Autor;
import app.repository.AutorRepository;

@Service
public class AutorService {
	@Autowired
	private AutorRepository repo;
	
	
	public AutorService() {
		// TODO Auto-generated constructor stub
	}
		
	
	public Iterable<Autor> findAll(){
		return this.repo.findAll();                                                          
	}
	
	public Optional<Autor> findById(Long id) {                        							
		return this.repo.findById(id);                             							
	}
	
	public Autor create(Autor nn) {
		return this.repo.save(nn);                                 							
	}
	
	public Autor update(Autor nn) {          													
		if(nn != null &&  this.findById(nn.getId()) != null) {                                          
			return this.repo.save(nn); 
		}
		return null;
	}
	
	public void delete(Autor nn) {
		this.repo.delete(nn);
	}
	
	public void delete(Long id) {
		this.repo.deleteById(id);
	}
	
	
}
