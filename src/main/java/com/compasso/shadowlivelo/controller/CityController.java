package com.compasso.shadowlivelo.controller;

import com.compasso.shadowlivelo.domain.dto.CityDtoRequest;
import com.compasso.shadowlivelo.domain.dto.CityDtoResponse;
import com.compasso.shadowlivelo.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Api(tags = {"City"}, value = "City controller")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/city")
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    @ApiOperation(value = "Carry out the registration of cities")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful request"),
            @ApiResponse(code = 400, message = "Missed Request: Incorrect data or missing information"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<CityDtoResponse> create(@RequestBody CityDtoRequest cityDtoRequest) {
        CityDtoResponse cityDtoResponse = cityService.create(cityDtoRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(cityDtoResponse.getId())
                .toUri();
        return ResponseEntity.created(uri).body(cityDtoResponse);
    }

    @GetMapping("/name/{name}")
    @ApiOperation(value = "Display city by name")
    @ApiResponses(value= {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 400, message = "Missed Request"),
            @ApiResponse(code = 404, message = "Search result not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<CityDtoResponse> findByName(@PathVariable String name){
        CityDtoResponse cityDtoResponse = cityService.findByName(name);
        return ResponseEntity.ok(cityDtoResponse);
    }

    @GetMapping("/state/{state}")
    @ApiOperation(value = "Display city by state")
    @ApiResponses(value= {
            @ApiResponse(code = 200, message = "Successful request"),
            @ApiResponse(code = 400, message = "Missed Request"),
            @ApiResponse(code = 404, message = "Search result not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<CityDtoResponse> findByState(@PathVariable String state){
        CityDtoResponse cityDtoResponse = cityService.findByState(state);
        return ResponseEntity.ok(cityDtoResponse);
    }


}
