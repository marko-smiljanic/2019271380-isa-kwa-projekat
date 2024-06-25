package app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.PravoPristupa;

@Repository
public interface PravoPristupaRepository extends CrudRepository<PravoPristupa, Long> {

}
