package com.compasso.shadowlivelo.service;

import com.compasso.shadowlivelo.advice.exception.ResourceNotFoundException;
import com.compasso.shadowlivelo.domain.dto.ClientDtoRequest;
import com.compasso.shadowlivelo.domain.dto.ClientDtoResponse;
import com.compasso.shadowlivelo.domain.dto.ClientDtoUpdate;
import com.compasso.shadowlivelo.domain.model.Client;
import com.compasso.shadowlivelo.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ModelMapper modelMapper;


	public ClientDtoResponse create(ClientDtoRequest clientDtoRequest) {
		Client client = modelMapper.map(clientDtoRequest, Client.class);
		this.clientRepository.save(client);
		return modelMapper.map(client, ClientDtoResponse.class);
	}

	public List<ClientDtoResponse> findAll() {
		List<Client> client = clientRepository.findAll();
		return client.stream().map(c -> modelMapper.map(c, ClientDtoResponse.class)).collect(Collectors.toList());
	}

	public ClientDtoResponse findById(Long id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found::" + id));
		return modelMapper.map(client, ClientDtoResponse.class);
	}

	public List<ClientDtoResponse> findByName(String name) {

		List<ClientDtoResponse> result = new ArrayList<>();

		List<Client> findByName = clientRepository.findByName(name);

		if (!findByName.isEmpty()) {
			findByName.forEach(f -> result.add(modelMapper.map(f, ClientDtoResponse.class)));
		}

		return result;
	}

	public ClientDtoResponse update(Long id, ClientDtoUpdate clientDtoUpdate) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found:: " + id));
		client.setName(clientDtoUpdate.getName());
		client.setLastName(clientDtoUpdate.getLastName());
		client.setBirthDate(clientDtoUpdate.getBirthDate());
		client.setGender(clientDtoUpdate.getGender());
		client.setCity(clientDtoUpdate.getCity());
		this.clientRepository.save(client);
		return modelMapper.map(client, ClientDtoResponse.class);

	}

	public Map<String, Boolean> delete(Long id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found:: " + id));
		this.clientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}

}
