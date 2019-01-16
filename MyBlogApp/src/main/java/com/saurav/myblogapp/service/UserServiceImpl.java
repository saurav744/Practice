package com.saurav.myblogapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurav.myblogapp.exceptions.UserNotFoundException;
import com.saurav.myblogapp.model.User;
import com.saurav.myblogapp.model.UserType;
import com.saurav.myblogapp.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(String firstname, String lastname, String email, String password, UserType type) {

		User user = new User(firstname, lastname, email, password, type);
		userRepository.save(user);

	}

	@Override
	public void addUSer(String firstname, String lastname, String email, String password) {

		addUser(firstname, lastname, email, password, UserType.BLOGGER);

	}

	@Override
	public void deleteUser(long id) throws UserNotFoundException {

		if (!hasUser(id))
			throw new UserNotFoundException();

		userRepository.deleteById(id);

	}

	@Override
	public boolean hasUser(String email) {

		return userRepository.findByEmail(email).isPresent();
	}

	@Override
	public boolean hasUser(long id) {

		return userRepository.findById(id).isPresent();
	}

	@Override
	public void updateUser(long id, User userInput) throws UserNotFoundException {

		if (userRepository.findById(id).isPresent()) {
			User user = userRepository.findById(id).get();

			if (userInput.getFirstName() != null)
				user.setFirstName(userInput.getFirstName());

			if (userInput.getLastName() != null)
				user.setLastName(userInput.getLastName());

			if (userInput.getPassword() != null)
				user.setPassword(userInput.getPassword());

			if (userInput.getType() != null)
				user.setType(userInput.getType());

			if (!userInput.getPublications().isEmpty())
				user.getPublications().addAll(userInput.getPublications());

			userRepository.save(user);
		}

		else
			throw new UserNotFoundException();

	}

	@Override
	public User getUser(String email) throws UserNotFoundException {

		Optional<User> user = userRepository.findByEmail(email);

		if (!user.isPresent())
			throw new UserNotFoundException();

		return user.get();

	}

	@Override
	public User getUserById(long id) throws UserNotFoundException {

		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			throw new UserNotFoundException();

		return user.get();

	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
