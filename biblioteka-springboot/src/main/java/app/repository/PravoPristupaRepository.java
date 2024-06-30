package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.PravoPristupa;

@Repository
public interface PravoPristupaRepository extends CrudRepository<PravoPristupa, Long> {
	Optional<PravoPristupa> findByNaziv(String naziv);
}
