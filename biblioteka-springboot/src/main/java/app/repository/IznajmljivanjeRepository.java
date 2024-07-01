package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.Iznajmljivanje;

@Repository
public interface IznajmljivanjeRepository extends CrudRepository<Iznajmljivanje, Long>{
	List<Iznajmljivanje> findByKorisnikId(Long id);
}
