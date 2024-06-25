package app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.KorisnikHasPravo;

@Repository
public interface KorisnikHasPravoRepository extends CrudRepository<KorisnikHasPravo, Long>{

}
