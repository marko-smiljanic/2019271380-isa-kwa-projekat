package app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.Recenzija;

@Repository
public interface RecenzijaRepository extends CrudRepository<Recenzija, Long>{

}
