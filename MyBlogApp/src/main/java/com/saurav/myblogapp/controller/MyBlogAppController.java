package com.saurav.myblogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saurav.myblogapp.model.Publication;
import com.saurav.myblogapp.model.User;
import com.saurav.myblogapp.service.PublicationService;
import com.saurav.myblogapp.service.UserService;

@RestController
public class MyBlogAppController {
	
	@Autowired
	private UserService userService;
	@Autowired
	PublicationService publicationService;
	
	@GetMapping("/users/id/{id}")
	public User getUser(@PathVariable Long id) {
		
		return userService.getUserById(id);
	}
	
	@GetMapping("/users/email/{email}")
	public User getUser(@PathVariable String email) {
		
		return userService.getUser(email);
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		
		return userService.getAllUsers();
	}
		
	@PostMapping("/users")
	public void createUser(@RequestBody User newUser) {

		userService.addUser(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), newUser.getPassword(), newUser.getType());
	
	}
	
	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable Long id, @RequestBody User newUser) {

		userService.updateUser(id, newUser);
	
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {

		userService.deleteUser(id);
	
	}
	
	@GetMapping("/publications/{id}")
	public Publication getPublication(@PathVariable Long id) {
		
		return publicationService.getPublicationById(id);
	}
	
	@GetMapping("/publications")
	public List<Publication> getAllPublications() {
		
		return publicationService.getAllPublications();
	}
	
	@PostMapping("/publications/{userId}")
	public void createPublication(@RequestBody Publication publication, @PathVariable Long userId) {
		
		User user= userService.getUserById(userId);
		publication.addAuthor(user);
		user.addPublications(publication);

		publicationService.addPublication(publication);
		//userService.updateUser(userId, user);	
	
	}
	
	@PutMapping("/publications/{id}")
	public void updatePublication(@PathVariable Long id, @RequestBody Publication newPub) {

		publicationService.updatePublication(id, newPub);
	
	}
	
	@DeleteMapping("/publications/{id}")
	public void deletePublication(@PathVariable Long id) {

		publicationService.deletePublication(id);
	
	}
	

}
