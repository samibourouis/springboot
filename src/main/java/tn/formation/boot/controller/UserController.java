package tn.formation.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.formation.boot.model.dao.UserRepository;
import tn.formation.boot.model.entity.User;

@Controller
@RequestMapping("api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/ajouter")
	public void ajouter(String firstName, String lastName, String login, String password) {

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLogin(login);
		user.setPassword(password);

		userRepository.save(user);
	}
	
	/**
	 * Get list of all users
	 * @return
	 */
	@GetMapping("/user/")
	public ResponseEntity<List<User>> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		
		if (users == null) {
			return new ResponseEntity<>
							(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		if (users.isEmpty()) {
			return new ResponseEntity<>
							(HttpStatus.NOT_FOUND);
		}
				
		return new ResponseEntity<>
						(users, HttpStatus.OK);
	}
	
	/**
	 * Get a use by id
	 * @param id
	 * @return
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable(name="id") Long id) {
	
		User user = userRepository.findOne(id);
		
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PutMapping("/user/")
	public ResponseEntity<Void> editUser(
			@RequestBody User user) {
		
		User userDb = userRepository.findOne(user.getId());
		
		if (userDb == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		userRepository.save(user);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	/**
	 * Delete a user by id
	 * @param id
	 */
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable(name="id") Long id) {
		userRepository.delete(id);
	}

	/**
	 * Delete all users
	 */
	@DeleteMapping("/user/")
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

}
