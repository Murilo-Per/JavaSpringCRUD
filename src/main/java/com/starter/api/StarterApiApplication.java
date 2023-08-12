package com.starter.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.starter.api.domain.UserLogin;
import com.starter.api.repositories.UserRepository;

@SpringBootApplication
public class StarterApiApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StarterApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		UserLogin u1 = new UserLogin("Murilo Teste", "murilo", "123", null);
		UserLogin u2 = new UserLogin("Murilo Teste2", "murilo2", "321", null);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
