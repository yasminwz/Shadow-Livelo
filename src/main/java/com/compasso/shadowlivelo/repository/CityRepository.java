package com.compasso.shadowlivelo.repository;

import com.compasso.shadowlivelo.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByName(String name);

    List<City> findByState(String state);

}
