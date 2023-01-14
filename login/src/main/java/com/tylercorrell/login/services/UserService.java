package com.tylercorrell.login.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.tylercorrell.login.models.LoginUser;
import com.tylercorrell.login.models.User;
import com.tylercorrell.login.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	// TO-DO: Write register and login methods!
	public User create(User u) {
		return userRepo.save(u);
	}
	
	public User getUserById(Long Id) {
		Optional<User> user = userRepo.findById(Id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	
    public User register(User newUser, BindingResult result) {
// TO-DO - Reject values or register if no errors:
    	String emailEntered = newUser.getEmail();
    	String passwordEntered = newUser.getPassword();
    	String confirmEntered = newUser.getConfirm();
    	String hashed = BCrypt.hashpw(passwordEntered, BCrypt.gensalt());
        
//        System.out.println(hashed);
    	// Reject if email is taken (present in database)
    	if (userRepo.findByEmail(emailEntered).isPresent()) {
    		result.rejectValue("email", "taken", "Email has already been used.");
    		return null;
    	}
        // Reject if password doesn't match confirmation
    	if(!passwordEntered.equals(confirmEntered)) {
    		result.rejectValue("confirm", "match", "Passwords must match!");
    		return null;
    	}
    	
    	// Hash and set password, save user to database
    	newUser.setPassword(hashed);
    	return newUser;
    	
    }
    
    public User login(LoginUser newLoginObject, BindingResult result) {
        String passwordEntered = newLoginObject.getPassword();
        String emailEntered = newLoginObject.getEmail();
        // Find user in the DB by email
        Optional<User> potentialUser = userRepo.findByEmail(emailEntered);
        // Reject if NOT present
        if (potentialUser.isEmpty()) {
        	result.rejectValue("email", "Matches", "Invalid Password/Username!");
        	return null;
        } 
        // Reject if BCrypt password match fails
        User user = potentialUser.get();
        
    	if(!BCrypt.checkpw(passwordEntered, user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	    return null;
    	}
        // Otherwise, return the user object
        else {
        	return potentialUser.get();
        }
        
    }
}
