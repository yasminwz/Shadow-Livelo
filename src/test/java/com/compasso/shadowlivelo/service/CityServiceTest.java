package com.compasso.shadowlivelo.service;

import com.compasso.shadowlivelo.repository.CityRepository;
import com.compasso.shadowlivelo.util.UtilTestCity;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @MockBean
    private CityRepository cityRepository;

    @Test
    void shouldCreateCity(){
        var city = UtilTestCity.newCity();
        var cityDtoRequest = UtilTestCity.newCityDtoRequest();
        var cityDtoResponse = UtilTestCity.newCityDtoResponse();

        when(cityRepository.save(city)).thenReturn(city);

        var saveCityRequest = cityService.create(cityDtoRequest);

        assertNotNull(saveCityRequest);

        verify(cityRepository, times(1)).save(Mockito.any());


    }

    @Test
    void shouldFindCityByName() {
        var city = UtilTestCity.newCity();
        var findByName = UtilTestCity.findByName();

        when(cityRepository.findByName("Curitiba")).thenReturn(findByName);
        var findByNameCityRequest = cityService.findByName("Curitiba");

        verify(cityRepository, times(1)).findByName("Curitiba");


    }

    @Test
    void shouldFindCityByState(){
        var city = UtilTestCity.newCity();
        var findByState = UtilTestCity.findByState();

        when(cityRepository.findByState("PR")).thenReturn(findByState);
        var findByStateCityRequest = cityService.findByState("PR");

        verify(cityRepository, times(1)).findByState("PR");



    }



}
