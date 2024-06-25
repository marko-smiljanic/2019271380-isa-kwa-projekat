package app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{

}
