package com.compasso.shadowlivelo.converter;

import com.compasso.shadowlivelo.domain.dto.ClientDtoResponse;
import com.compasso.shadowlivelo.domain.model.Client;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.time.LocalDate;
import java.time.Period;

public class ClientToClientDto implements Converter<Client, ClientDtoResponse> {


    @Override
    public ClientDtoResponse convert(MappingContext<Client, ClientDtoResponse> mappingContext) {
        Client source = mappingContext.getSource();
        return ClientDtoResponse.builder()
                .birthDate(source.getBirthDate())
                .age(getAgeForBirthDate(source.getBirthDate()))
                .lastName(source.getLastName())
                .id(source.getId())
                .name(source.getName())
                .gender(source.getGender())
                .city(source.getCity())
                .build();
    }

    private int getAgeForBirthDate(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
