package com.compasso.shadowlivelo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.shadowlivelo.domain.dto.ClienteDtoRequest;
import com.compasso.shadowlivelo.domain.dto.ClienteDtoResponse;
import com.compasso.shadowlivelo.domain.dto.ClienteDtoUpdate;
import com.compasso.shadowlivelo.domain.model.Cliente;
import com.compasso.shadowlivelo.exception.ResourceNotFoundException;
import com.compasso.shadowlivelo.repository.ClienteRepository;

@Transactional
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ClienteDtoResponse create(ClienteDtoRequest clienteDtoRequest) {
		Cliente cliente = modelMapper.map(clienteDtoRequest, Cliente.class);
		this.clienteRepository.save(cliente);
		return modelMapper.map(cliente, ClienteDtoResponse.class);
	}

	public List<ClienteDtoResponse> findAll() {
		List<Cliente> cliente = clienteRepository.findAll();
		return cliente.stream().map(r -> modelMapper.map(r, ClienteDtoResponse.class)).collect(Collectors.toList());
	}

	public ClienteDtoResponse findById(Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Room not found::" + id));
		return modelMapper.map(cliente, ClienteDtoResponse.class);
	}

	public List<ClienteDtoResponse> findByNome(String nome) {

		List<ClienteDtoResponse> result = new ArrayList<>();

		List<Cliente> findByNome = clienteRepository.findByNome(nome);

		if (!findByNome.isEmpty()) {
			findByNome.forEach(f -> result.add(modelMapper.map(f, ClienteDtoResponse.class)));
		}

		return result;
	}

	public ClienteDtoResponse update(Long id, ClienteDtoUpdate clienteDtoUpdate) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado:: " + id));
		cliente.setNome(clienteDtoUpdate.getNome());
		cliente.setSobrenome(clienteDtoUpdate.getSobrenome());
		cliente.setDataDeNascimento(clienteDtoUpdate.getDataDeNascimento());
		cliente.setIdade(clienteDtoUpdate.getIdade());
		cliente.setSexo(clienteDtoUpdate.getSexo());
		cliente.setCidade(clienteDtoUpdate.getCidade());
		this.clienteRepository.save(cliente);
		return modelMapper.map(cliente, ClienteDtoResponse.class);

	}

	public Map<String, Boolean> delete(Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado:: " + id));
		this.clienteRepository.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado", Boolean.TRUE);
		return response;
	}

}
