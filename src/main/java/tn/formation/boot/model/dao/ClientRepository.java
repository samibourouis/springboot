package tn.formation.boot.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import tn.formation.boot.model.entity.Client;

@Repository
@RepositoryRestResource(path = "client")
public interface ClientRepository 
	extends JpaRepository<Client, Long> {

	
	
}
