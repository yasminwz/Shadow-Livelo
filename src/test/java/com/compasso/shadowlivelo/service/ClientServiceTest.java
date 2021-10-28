package com.compasso.shadowlivelo.service;


import com.compasso.shadowlivelo.repository.ClientRepository;
import com.compasso.shadowlivelo.util.UtilTestClient;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;

    @Test
    void shouldCreateClient() {
        var client = UtilTestClient.newClient();
        var clientDtoRequest = UtilTestClient.newClientDtoRequest();
        var clientDtoResponse = UtilTestClient.newClientDtoResponse();

        when(clientRepository.save(client)).thenReturn(client);

        var saveClientRequest = clientService.create(clientDtoRequest);

        assertNotNull(saveClientRequest);

        verify(clientRepository, times(1)).save(Mockito.any());
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
        var findByIdClientRequest = clientService.findById(1L);

        verify(clientRepository, times(1)).findById(1L);

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
        when(clientRepository.save(client)).thenReturn(client);

        clientService.update(1L, clientUpdate);

        verify(clientRepository, times(1)).save(client);

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
