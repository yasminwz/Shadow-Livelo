package com.compasso.shadowlivelo.repository;

import java.util.List;

import com.compasso.shadowlivelo.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByName(String name);
}
