package com.compasso.shadowlivelo.controller;

import com.compasso.shadowlivelo.domain.dto.ClientDtoRequest;
import com.compasso.shadowlivelo.domain.dto.ClientDtoResponse;
import com.compasso.shadowlivelo.domain.dto.ClientDtoUpdate;
import com.compasso.shadowlivelo.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Map;

@Api(tags = {"Client"}, value = "Client controller")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/client")
@RestController
public class ClientController {


	@Autowired
	private ClientService clientService;

	@PostMapping
	@ApiOperation(value = "Perform Customer Registration")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful request"),
			@ApiResponse(code = 400, message = "Missed Request: Incorrect data or missing information"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<ClientDtoResponse> create(@Valid @RequestBody ClientDtoRequest clientDtoRequest, BindingResult bindingResult) {
		ClientDtoResponse clientDtoResponse = clientService.create(clientDtoRequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(clientDtoResponse.getId()).toUri();
			return ResponseEntity.created(uri).body(clientDtoResponse);
}

	@GetMapping
	@ApiOperation(value = "Display all customers")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful request"),
			@ApiResponse(code = 400, message = "Missed Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<List<ClientDtoResponse>> findAll() {
		List<ClientDtoResponse> clientDtoResponse = clientService.findAll();
		return ResponseEntity.ok(clientDtoResponse);
	}

	@GetMapping("/id/{id}")
	@ApiOperation(value = "Displays client that has a valid Id entered in the URL")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful request"),
			@ApiResponse(code = 400, message = "Missed Request"),
			@ApiResponse(code = 404, message = "Search result not found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
			})
	public ResponseEntity<ClientDtoResponse> findById(@PathVariable Long id) {
		ClientDtoResponse clientDtoResponse = clientService.findById(id);
		return ResponseEntity.ok(clientDtoResponse);
	}

	@GetMapping("/name/{name}")
	@ApiOperation(value = "Displays client that has a valid name entered in the URL")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful request"),
			@ApiResponse(code = 400, message = "Missed Request"),
			@ApiResponse(code = 404, message = "Search result not found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public ResponseEntity<List<ClientDtoResponse>> findByName(@PathVariable String name) {
		return ResponseEntity.ok(clientService.findByName(name));
	}

	@PutMapping("/put/{id}")
	@ApiOperation(value = "Update a customer's data by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful request"),
			@ApiResponse(code = 400, message = "Missed Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<ClientDtoResponse> update(@PathVariable Long id,
													@RequestBody ClientDtoUpdate clientDtoUpdate) {
		ClientDtoResponse clientDtoResponse = clientService.update(id, clientDtoUpdate);
		return ResponseEntity.ok(clientDtoResponse);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Delete client")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful request"),
			@ApiResponse(code = 404, message = "Search result not found"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public Map<?, ?> delete(@PathVariable Long id) {
		return this.clientService.delete(id);

	}

}
