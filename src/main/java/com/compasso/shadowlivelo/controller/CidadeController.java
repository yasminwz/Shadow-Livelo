package com.compasso.shadowlivelo.controller;

import com.compasso.shadowlivelo.domain.dto.CidadeDtoRequest;
import com.compasso.shadowlivelo.domain.dto.ClienteDtoResponse;
import com.compasso.shadowlivelo.domain.dto.CidadeDtoResponse;
import com.compasso.shadowlivelo.domain.model.Cliente;
import com.compasso.shadowlivelo.exception.ResourceNotFoundException;
import com.compasso.shadowlivelo.service.CidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Api(tags = {"Cidade"}, value = "Cidade controller")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cidade")
@RestController
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    @ApiOperation(value = "Realiza o cadastro de cidades")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Requisição bem sucedida"),
            @ApiResponse(code = 400, message = "Requisição não atendida dados incorretos ou falta informações"),
            @ApiResponse(code = 500, message = "Sistema indisponivel")})
    public ResponseEntity<CidadeDtoResponse> create(@Valid @RequestBody CidadeDtoRequest cidadeDtoRequest) {
        CidadeDtoResponse cidadeDtoResponse = cidadeService.create(cidadeDtoRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(cidadeDtoResponse.getId())
                .toUri();
        return ResponseEntity.created(uri).body(cidadeDtoResponse);
    }

    @GetMapping("/nome/{nome}")
    @ApiOperation(value = "Exibe cidade através de um nome")
    @ApiResponses(value= {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 400, message = "Requisição não atendida, dados incorretos ou falta informações"),
            @ApiResponse(code = 404, message = "Resultado de pesquisa não encontrado")})
    public ResponseEntity<CidadeDtoResponse> findByNome(@Valid @PathVariable String nome){
        CidadeDtoResponse cidadeDtoResponse = cidadeService.findByNome(nome);
        return ResponseEntity.ok(cidadeDtoResponse);
    }

    @GetMapping("/estado/{estado}")
    @ApiOperation(value = "Exibe cidade através de estado")
    @ApiResponses(value= {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 400, message = "Requisição não atendida, dados incorretos ou falta informações"),
            @ApiResponse(code = 404, message = "Resultado de pesquisa não encontrado")})
    public ResponseEntity<CidadeDtoResponse> findByEstado(@Valid @PathVariable String estado){
        CidadeDtoResponse cidadeDtoResponse = cidadeService.findByEstado(estado);
        return ResponseEntity.ok(cidadeDtoResponse);
    }


}
