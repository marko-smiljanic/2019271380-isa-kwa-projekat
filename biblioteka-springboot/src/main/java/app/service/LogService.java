package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Log;
import app.repository.LogRepository;

@Service
public class LogService {
	@Autowired
	LogRepository repo;
	
	public void save(Log l) {
		repo.save(l);
	}
	
}
