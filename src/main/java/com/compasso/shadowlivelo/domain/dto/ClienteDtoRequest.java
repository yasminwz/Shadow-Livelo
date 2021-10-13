package com.compasso.shadowlivelo.domain.dto;

import com.compasso.shadowlivelo.domain.model.Cidade;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteDtoRequest {

    private String nome;
    private String sobrenome;
    private LocalDate dataDeNascimento;
    private int idade;
    private  char sexo;

    private Cidade cidade;

}
