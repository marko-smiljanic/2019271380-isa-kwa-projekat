package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Korisnik;
import app.repository.KorisnikRepository;

@Service
public class KorisnikService {
	@Autowired
	private KorisnikRepository repo;
	
	public KorisnikService() {}
		
	
	
	public Iterable<Korisnik> findAll(){
		return this.repo.findAll();                                                          
	}
	
	public Optional<Korisnik> findById(Long id) {                        							
		return this.repo.findById(id);                             							
	}
	
	public Korisnik create(Korisnik nn) {
		return this.repo.save(nn);                                 							
	}
	
	public Korisnik update(Korisnik nn) {          													
		if(nn != null &&  this.findById(nn.getId()) != null) {                                          
			return this.repo.save(nn); 
		}
		return null;
	}
	
	public void delete(Korisnik nn) {
		this.repo.delete(nn);
	}
	
	public void delete(Long id) {
		this.repo.deleteById(id);
	}

	
	//dodato za security
	public Optional<Korisnik> findByKorisnickoIme(String korisnickoIme){
		return this.repo.findByKorisnickoIme(korisnickoIme);
	}
}
