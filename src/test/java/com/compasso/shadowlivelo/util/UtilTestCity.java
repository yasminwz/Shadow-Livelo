package com.compasso.shadowlivelo.util;

import com.compasso.shadowlivelo.domain.dto.CityDtoRequest;
import com.compasso.shadowlivelo.domain.dto.CityDtoResponse;
import com.compasso.shadowlivelo.domain.model.City;
import lombok.var;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UtilTestCity {

    public static List<City> findByName() {
        return newCityList();
    }

    public static List<City> findByState() {
        return newCityList();
    }


    public static CityDtoResponse newCityDtoResponse() {
        var cityDtoResponse = new CityDtoResponse();
        cityDtoResponse.setId(newCity().getId());
        cityDtoResponse.setName(newCityDtoRequest().getName());
        cityDtoResponse.setState(newCityDtoRequest().getState());
        return cityDtoResponse;
    }

    public static List<City> newCityList() {
        List<City> cityList = new ArrayList<>();
        cityList.add(newCity());
        return cityList;
    }

    public static City newCity() {
        var city = new City();
        city.setId(1L);
        city.setName(newCityDtoRequest().getName());
        city.setState(newCityDtoRequest().getState());
        return city;
    }

    public static CityDtoRequest newCityDtoRequest() {
        var cityDtoRequest = new CityDtoRequest();
        cityDtoRequest.setName("Curitiba");
        cityDtoRequest.setState("PR");
        return cityDtoRequest;
    }

    public static Optional<City> newOptionalCity() {
        return Optional.of(newCity());
    }

}
