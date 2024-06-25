package app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.Iznajmljivanje;

@Repository
public interface IznajmljivanjeRepository extends CrudRepository<Iznajmljivanje, Long>{

}
