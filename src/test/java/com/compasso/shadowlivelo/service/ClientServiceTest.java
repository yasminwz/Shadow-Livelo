package com.compasso.shadowlivelo.service;


import com.compasso.shadowlivelo.domain.dto.ClientDtoResponse;
import com.compasso.shadowlivelo.domain.model.Client;
import com.compasso.shadowlivelo.modelmapper.ModelMapperConfig;
import com.compasso.shadowlivelo.repository.ClientRepository;
import com.compasso.shadowlivelo.service.validation.AgeValidator;
import com.compasso.shadowlivelo.util.UtilTestClient;
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
@ContextConfiguration(classes = {ClientService.class, ModelMapper.class, ModelMapperConfig.class, AgeValidator.class})
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private AgeValidator ageValidator;


    @Test
    void shouldCreateClient() {
        var client = UtilTestClient.newClient();
        var clientDtoRequest = UtilTestClient.newClientDtoRequest();
        var clientDtoResponse = UtilTestClient.newClientDtoResponse();

        when(modelMapper.map(clientDtoRequest, Client.class)).thenReturn(client);
        when(clientRepository.save(client)).thenReturn(client);
        when(modelMapper.map(client, ClientDtoResponse.class)).thenReturn(clientDtoResponse);

        var saveClientRequest = clientService.create(clientDtoRequest);

        assertNotNull(saveClientRequest);

        verify(clientRepository, times(1)).save(client);
        verify(modelMapper, times(1)).map(client, ClientDtoResponse.class);

    }

    @Test
    void shouldFindAllClient() {
        var client = UtilTestClient.newClientList();


        when(clientRepository.findAll()).thenReturn(client);
        var clientDtoResponses = clientService.findAll();

        assertNotNull(clientDtoResponses);

        verify(clientRepository, times(1)).findAll();

    }

    @Test
    void shouldFindClientById() {
        var client = UtilTestClient.newClient();
        var findById = UtilTestClient.findById();
        var clientDtoResponse = UtilTestClient.newClientDtoResponse();


        when(clientRepository.findById(1L)).thenReturn(findById);
        when(modelMapper.map(client, ClientDtoResponse.class)).thenReturn(clientDtoResponse);
        var findByIdClientRequest = clientService.findById(1L);

        verify(clientRepository, times(1)).findById(1L);
        verify(modelMapper, times(1)).map(client, ClientDtoResponse.class);

    }

    @Test
    void shouldFindClientByName() {
        var client = UtilTestClient.newClient();
        var findByName = UtilTestClient.findByName();


        when(clientRepository.findByName("Yasmin")).thenReturn(findByName);
        var findByNameClientRequest = clientService.findByName("Yasmin");

        verify(clientRepository, times(1)).findByName("Yasmin");

    }

    @Test
    void shouldUpdateClient() {
        var client = UtilTestClient.newClient();
        var clientUpdate = UtilTestClient.newClientDtoUpdate();
        var clientResponse = UtilTestClient.newClientDtoResponse();
        var clientOptional = UtilTestClient.newOptionalClient();

        when(clientRepository.findById(1L)).thenReturn(clientOptional);
        doNothing().when(modelMapper).map(clientUpdate, client);
        when(clientRepository.save(client)).thenReturn(client);
        when(modelMapper.map(client, ClientDtoResponse.class)).thenReturn(clientResponse);

        clientService.update(1L, clientUpdate);

        verify(clientRepository, times(1)).save(client);
        verify(modelMapper, times(1)).map(clientUpdate, client);
        verify(modelMapper, times(1)).map(client, ClientDtoResponse.class);

    }

    @Test
    void shouldDeleteClient() {
        var client = UtilTestClient.newClient();
        var clientOptional = UtilTestClient.newOptionalClient();

        when(clientRepository.findById(1L)).thenReturn(clientOptional);

        clientService.delete(1L);

        verify(clientRepository, times(1)).delete(client);

    }

}
