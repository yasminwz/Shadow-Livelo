package com.compasso.shadowlivelo.repository;

import com.compasso.shadowlivelo.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Cidade findByNome(String nome);

    Cidade findByEstado(String estado);

}
