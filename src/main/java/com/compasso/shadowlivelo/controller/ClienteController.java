package com.compasso.shadowlivelo.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compasso.shadowlivelo.domain.dto.ClienteDtoRequest;
import com.compasso.shadowlivelo.domain.dto.ClienteDtoResponse;
import com.compasso.shadowlivelo.domain.dto.ClienteDtoUpdate;
import com.compasso.shadowlivelo.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "Cliente" }, value = "Cliente controller")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/clientes")
@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	@ApiOperation(value = "Realiza o cadastro de clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Requisição bem sucedida"),
			@ApiResponse(code = 400, message = "Requisição não atendida dados incorretos ou falta informações"),
			@ApiResponse(code = 500, message = "Sistema indisponivel") })
	public ResponseEntity<ClienteDtoResponse> createRoom(@Valid @RequestBody ClienteDtoRequest clienteDtoRequest) {
		ClienteDtoResponse clienteDtoResponse = clienteService.create(clienteDtoRequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(clienteDtoResponse.getId()).toUri();
		return ResponseEntity.created(uri).body(clienteDtoResponse);
	}

	@GetMapping
	@ApiOperation(value = "Realiza exibição de todos os clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requisição bem sucedida"),
			@ApiResponse(code = 500, message = "Sistema indisponivel") })
	public ResponseEntity<List<ClienteDtoResponse>> findAll() {
		List<ClienteDtoResponse> clienteDtoResponse = clienteService.findAll();
		return ResponseEntity.ok(clienteDtoResponse);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Exibe cliente através de um Id válido informado na URL")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requisição bem sucedida"),
			@ApiResponse(code = 400, message = "Requisição não atendida, dados incorretos ou falta informações"),
			@ApiResponse(code = 404, message = "Resultado de pesquisa não encontrado") })
	public ResponseEntity<ClienteDtoResponse> findById(@Valid @PathVariable Long id) {
		ClienteDtoResponse clienteDtoResponse = clienteService.findById(id);
		return ResponseEntity.ok(clienteDtoResponse);
	}

	@GetMapping("/nome/{nome}")
	@ApiOperation(value = "Exibe cliente através de um nome válido informado na URL")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requisição bem sucedida"),
			@ApiResponse(code = 400, message = "Requisição não atendida, dados incorretos ou falta informações"),
			@ApiResponse(code = 404, message = "Resultado de pesquisa não encontrado") })
	public ResponseEntity<List<ClienteDtoResponse>> findByNome(@Valid @PathVariable String nome) {
		return ResponseEntity.ok(clienteService.findByNome(nome));
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar dados de um cliente por id válido")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requisição bem sucedida"),
			@ApiResponse(code = 400, message = "Requisição não atendida, dados incorretos ou falta informações"),
			@ApiResponse(code = 404, message = "Resultado de pesquisa não encontrado"),
			@ApiResponse(code = 500, message = "Sistema indisponivel") })
	public ResponseEntity<ClienteDtoResponse> update(@Valid @PathVariable Long id,
			@Valid @RequestBody ClienteDtoUpdate clienteDtoUpdate) {
		ClienteDtoResponse clienteDtoResponse = clienteService.update(id, clienteDtoUpdate);
		return ResponseEntity.ok(clienteDtoResponse);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui uma cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requisição bem sucedida"),
			@ApiResponse(code = 404, message = "Resultado de pesquisa não encontrado"),
			@ApiResponse(code = 500, message = "Sistema indisponivel") })
	public Map<?, ?> delete(@Valid @PathVariable Long id) {
		return this.clienteService.delete(id);

	}

}
