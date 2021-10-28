package com.compasso.shadowlivelo.util;

import com.compasso.shadowlivelo.domain.dto.ClientDtoRequest;
import com.compasso.shadowlivelo.domain.dto.ClientDtoResponse;
import com.compasso.shadowlivelo.domain.dto.ClientDtoUpdate;
import com.compasso.shadowlivelo.domain.model.Client;
import lombok.var;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UtilTestClient {

    public static Optional<Client> findById(){
        return Optional.of(newClient());
    }

    public static List<Client> findByName() {
        return newClientList();
    }


    public static Client newClient() {
        var client = new Client();
        client.setId(1L);
        client.setName(newClientDtoRequest().getName());
        client.setLastName(newClientDtoRequest().getLastName());
        client.setBirthDate(newClientDtoRequest().getBirthDate());
        client.setGender(newClientDtoRequest().getGender());
        client.setCity(UtilTestCity.newCity());
        return client;
    }

    public static ClientDtoRequest newClientDtoRequest() {
        var clientDtoRequest = new ClientDtoRequest();
        clientDtoRequest.setName("Yasmin");
        clientDtoRequest.setLastName("Wichinievski");
        clientDtoRequest.setBirthDate(LocalDate.parse("2003-03-19"));
        clientDtoRequest.setGender("F");
        clientDtoRequest.setCityDtoRequest(UtilTestCity.newCityDtoRequest());
        return clientDtoRequest;
    }


    public static ClientDtoResponse newClientDtoResponse() {
        var clientDtoResponse = new ClientDtoResponse();
        clientDtoResponse.setName(newClientDtoRequest().getName());
        clientDtoResponse.setLastName(newClientDtoRequest().getLastName());
        clientDtoResponse.setBirthDate(newClientDtoRequest().getBirthDate());
        clientDtoResponse.setGender(newClientDtoRequest().getGender());
        clientDtoResponse.setCityDtoResponse(UtilTestCity.newCityDtoResponse());
        clientDtoResponse.setId(newClient().getId());
        return clientDtoResponse;
    }

    public static ClientDtoUpdate newClientDtoUpdate(){
        var clientUpdate = new ClientDtoUpdate();
        var clientDtoRequest = new ClientDtoRequest();
        clientUpdate.setName("Yasmin");
        clientUpdate.setLastName("Wichinievski");
        clientUpdate.setBirthDate(LocalDate.parse("2003-03-19"));
        clientUpdate.setGender("F");
        clientUpdate.setCityDtoRequest(UtilTestCity.newCityDtoRequest());
        return clientUpdate;

    }


    public static List<Client> newClientList(){
        List<Client> clientList = new ArrayList<>();
        clientList.add(newClient());
            return clientList;
        }


    public static Optional<Client> newOptionalClient() {
        return Optional.of(newClient());
    }
}
