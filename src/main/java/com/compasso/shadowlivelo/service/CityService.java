package com.compasso.shadowlivelo.service;

import com.compasso.shadowlivelo.domain.dto.CityDtoRequest;
import com.compasso.shadowlivelo.domain.dto.CityDtoResponse;
import com.compasso.shadowlivelo.domain.model.City;
import com.compasso.shadowlivelo.repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CityDtoResponse create(CityDtoRequest cityDtoRequest) {
		City city = modelMapper.map(cityDtoRequest, City.class);
		this.cityRepository.save(city);
		return modelMapper.map(city, CityDtoResponse.class);

	}

	public CityDtoResponse findByName(String name) {
		City city = cityRepository.findByName(name);
		return modelMapper.map(city, CityDtoResponse.class);

	}

	public CityDtoResponse findByState(String state) {
		City city = cityRepository.findByState(state);
		return modelMapper.map(city, CityDtoResponse.class);

	}

}