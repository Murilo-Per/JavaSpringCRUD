package com.starter.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.starter.api.domain.UserLogin;
import com.starter.api.services.UserService;

@RestController
@RequestMapping(value = "/usuarios")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserLogin> findById(@PathVariable Integer id){
		UserLogin obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
				
	}
	
	@GetMapping
	public ResponseEntity<List<UserLogin>> findAll(){
		List<UserLogin> list = this.service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<UserLogin> create(@RequestBody UserLogin obj){
		UserLogin newObj = this.service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping
	public ResponseEntity<UserLogin> update(@RequestBody UserLogin obj){
		UserLogin newObj = this.service.findById(obj.getId());
		if(newObj != null){
			newObj.setEmail(obj.getEmail());
			newObj.setName(obj.getName());
			newObj.setPassword(obj.getPassword());
			
			this.service.update(newObj);
	    }
		return ResponseEntity.ok(null) ;
	}
}
