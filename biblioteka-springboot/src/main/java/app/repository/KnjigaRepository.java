package app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.Knjiga;

@Repository
public interface KnjigaRepository extends CrudRepository<Knjiga, Long>{

}
