package com.compasso.shadowlivelo.service;

import com.compasso.shadowlivelo.domain.dto.CityDtoResponse;
import com.compasso.shadowlivelo.domain.model.City;
import com.compasso.shadowlivelo.modelmapper.ModelMapperConfig;
import com.compasso.shadowlivelo.repository.CityRepository;
import com.compasso.shadowlivelo.util.UtilTestCity;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {CityService.class, ModelMapper.class, ModelMapperConfig.class})
public class CityServiceTest {

    @InjectMocks
    private CityService cityService;

    @Mock
    private CityRepository cityRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void shouldCreateCity(){
        var city = UtilTestCity.newCity();
        var cityDtoRequest = UtilTestCity.newCityDtoRequest();
        var cityDtoResponse = UtilTestCity.newCityDtoResponse();

        when(modelMapper.map(cityDtoRequest, City.class)).thenReturn(city);
        when(cityRepository.save(city)).thenReturn(city);
        when(modelMapper.map(city, CityDtoResponse.class)).thenReturn(cityDtoResponse);

        var saveCityRequest = cityService.create(cityDtoRequest);

        assertNotNull(saveCityRequest);

        verify(cityRepository, times(1)).save(city);
        verify(modelMapper, times(1)).map(city, CityDtoResponse.class);


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
