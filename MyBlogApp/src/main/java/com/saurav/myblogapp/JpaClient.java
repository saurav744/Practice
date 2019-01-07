package com.saurav.myblogapp;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.data_access.PublicationRepository;
import com.saurav.myblogapp.data_access.UserRepository;


@SpringBootApplication
public class JpaClient implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(JpaClient.class);
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private PublicationRepository publicationRepository;
	
	public static void main(String args[]) {
		SpringApplication.run(JpaClient.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		User user = new User("bunny", "stifler", "bunny@stifler", "bountyhunter");
		userRepository.save(user);
				
	}
		

}
