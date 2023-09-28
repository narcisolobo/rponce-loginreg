package com.nlobo.logreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.nlobo.logreg.models.LoginUser;
import com.nlobo.logreg.models.User;
import com.nlobo.logreg.repositories.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	// register method
	public User register(User user, BindingResult result) {
		
		Optional<User> potentialUser = userRepository.findByEmail(user.getEmail());
		
		// Does email exist?
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "emailExists", "Email exists. Please log in.");
		}
		
		// Do the passwords match?
		if (!user.getConfirm().equals(user.getPassword())) {
			result.rejectValue("confirm", "noMatch", "Passwords do not match.");
		}
		
		if (result.hasErrors()) return null;
		
		// hash the password and save the user
		
		else {
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashed);
			return userRepository.save(user);
		}
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isEmpty()) {
			return null;
		} else {
			return optionalUser.get();
		}
	}

	public User login(@Valid LoginUser loginUser, BindingResult result) {
		// Does user exist?
		Optional<User> potentialUser = userRepository.findByEmail(loginUser.getEmail());
		
		if (potentialUser.isEmpty()) {
			result.rejectValue("email", "noEmail", "User not found. Please register.");
			return null;
		}
		
		User user = potentialUser.get();
		
		// Is password correct?
		if (!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "noMatch", "Incorrect password.");
		}
		
		if (result.hasErrors()) return null;
		else return user;
	}
}
