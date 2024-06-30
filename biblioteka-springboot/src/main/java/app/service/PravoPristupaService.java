package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.PravoPristupa;
import app.repository.PravoPristupaRepository;

@Service
public class PravoPristupaService {
	@Autowired
	private PravoPristupaRepository repo;
	
	public PravoPristupaService() {}
		
	
	
	public Iterable<PravoPristupa> findAll(){
		return this.repo.findAll();                                                          
	}
	
	public Optional<PravoPristupa> findById(Long id) {                        							
		return this.repo.findById(id);                             							
	}
	
	public PravoPristupa create(PravoPristupa nn) {
		return this.repo.save(nn);                                 							
	}
	
	public PravoPristupa update(PravoPristupa nn) {          													
		if(nn != null &&  this.findById(nn.getId()) != null) {                                          
			return this.repo.save(nn); 
		}
		return null;
	}
	
	public void delete(PravoPristupa nn) {
		this.repo.delete(nn);
	}
	
	public void delete(Long id) {
		this.repo.deleteById(id);
	}
	
	public Optional<PravoPristupa> pronadjiPravoPoNazivu(String naziv) {
		return this.repo.findByNaziv(naziv);
	}

}
