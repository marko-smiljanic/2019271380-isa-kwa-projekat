package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Iznajmljivanje;
import app.repository.IznajmljivanjeRepository;

@Service
public class IznajmljivanjeService {
	@Autowired
	private IznajmljivanjeRepository repo;
	
	
	public IznajmljivanjeService() {
		// TODO Auto-generated constructor stub
	}
		
	
	public Iterable<Iznajmljivanje> findAll(){
		return this.repo.findAll();                                                          
	}
	
	public Optional<Iznajmljivanje> findById(Long id) {                        							
		return this.repo.findById(id);                             							
	}
	
	public Iznajmljivanje create(Iznajmljivanje nn) {
		return this.repo.save(nn);                                 							
	}
	
	public Iznajmljivanje update(Iznajmljivanje nn) {          													
		if(nn != null &&  this.findById(nn.getId()) != null) {                                          
			return this.repo.save(nn); 
		}
		return null;
	}
	
	public void delete(Iznajmljivanje nn) {
		this.repo.delete(nn);
	}
	
	public void delete(Long id) {
		this.repo.deleteById(id);
	}
	
	
	
	public List<Iznajmljivanje> pronadjiPoKorisniku(Long id) {
		return this.repo.findByKorisnikId(id);
	}
	
	
}
