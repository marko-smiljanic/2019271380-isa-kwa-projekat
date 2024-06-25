package app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.Kategorija;

@Repository
public interface KategorijaRepository extends CrudRepository<Kategorija, Long>{

}
