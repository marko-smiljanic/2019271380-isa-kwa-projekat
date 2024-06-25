package app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.model.Log;

@Repository
public interface LogRepository extends CrudRepository<Log, Long>{

}
