package tn.formation.boot.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.formation.boot.model.entity.User;

@RepositoryRestResource(path = "user")

public interface UserRepository 
	extends JpaRepository<User, Long> {

	// Select * FROM user WHERE lastname = $lastname ORDER BY firstname ASC
	List<User> findByLastnameOrderByFirstnameAsc(String lastname);
	
	// Select * FROM user WHERE emailAddress = $emailAddress
	@Query("select u from User u where u.emailAddress = ?1")
	User findByEmailAddress(String emailAddress);
	
}


