package com.starter.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.api.domain.UserLogin;
import com.starter.api.repositories.UserRepository;
import com.starter.api.services.exceptions.ObjectNotFoundException;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public UserLogin findById(Integer id) {
		Optional<UserLogin> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id));
	}

	public List<UserLogin> findAll() {
		return this.repository.findAll();
	}

	public UserLogin create(UserLogin obj) {
		obj.setId(null);
		return this.repository.save(obj);
	}

	public void update(UserLogin newObj) {
		this.repository.save(newObj);
		
	}
	
	
}
