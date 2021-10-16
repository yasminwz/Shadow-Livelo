package com.compasso.shadowlivelo.repository;

import com.compasso.shadowlivelo.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);

    City findByState(String state);

}
