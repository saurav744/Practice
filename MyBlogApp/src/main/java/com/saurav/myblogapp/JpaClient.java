package com.saurav.myblogapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.data_access.UserRepository;


@SpringBootApplication
public class JpaClient {
	
	private static final Logger logger = LoggerFactory.getLogger(JpaClient.class);

	public static void main(String args[]) {
	SpringApplication.run(JpaClient.class);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
	return args -> {
	// save a couple of customers
	repository.save(new User("bunny", "stifler", "bunny@stifler", "bountyhunter"));
	repository.save(new User("saurav", "sharma", "saurav@sharma", "bohu"));


	// fetch all customers
	logger.info("Users found with findAll():");
	logger.info("-------------------------------");
	for (User customer : repository.findAll()) {
	logger.info(customer.toString());
	}
	logger.info("Done");
	};
	}


}
