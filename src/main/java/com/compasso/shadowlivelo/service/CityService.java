package com.compasso.shadowlivelo.service;

import com.compasso.shadowlivelo.domain.dto.CityDtoRequest;
import com.compasso.shadowlivelo.domain.dto.CityDtoResponse;
import com.compasso.shadowlivelo.domain.model.City;
import com.compasso.shadowlivelo.repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

	public List<CityDtoResponse> findByName(String name) {

		List<CityDtoResponse> result = new ArrayList<>();

		List<City> findByName = cityRepository.findByName(name);

		if(!findByName.isEmpty()){
			findByName.forEach(r -> result.add(modelMapper.map(r,CityDtoResponse.class)));
		}

		return result;

	}

	public List<CityDtoResponse> findByState(String state) {

		List<CityDtoResponse> result = new ArrayList<>();

		List<City> findByState = cityRepository.findByState(state);

		if(!findByState.isEmpty()){
			findByState.forEach(r -> result.add(modelMapper.map(r, CityDtoResponse.class)));
		}

		return result;

	}

}