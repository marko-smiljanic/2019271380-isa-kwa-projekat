package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.KorisnikHasPravo;
import app.repository.KorisnikHasPravoRepository;

@Service
public class KorisnikHasPravoService {
	@Autowired
	private KorisnikHasPravoRepository repo;
	
	public KorisnikHasPravoService() {}
		
	
	
	public Iterable<KorisnikHasPravo> findAll(){
		return this.repo.findAll();                                                          
	}
	
	public Optional<KorisnikHasPravo> findById(Long id) {                        							
		return this.repo.findById(id);                             							
	}
	
	public KorisnikHasPravo create(KorisnikHasPravo nn) {
		return this.repo.save(nn);                                 							
	}
	
	public KorisnikHasPravo update(KorisnikHasPravo nn) {          													
		if(nn != null &&  this.findById(nn.getId()) != null) {                                          
			return this.repo.save(nn); 
		}
		return null;
	}
	
	public void delete(KorisnikHasPravo nn) {
		this.repo.delete(nn);
	}
	
	public void delete(Long id) {
		this.repo.deleteById(id);
	}
}
