package com.compasso.shadowlivelo.repository;

import com.compasso.shadowlivelo.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByNome(String nome);
}
