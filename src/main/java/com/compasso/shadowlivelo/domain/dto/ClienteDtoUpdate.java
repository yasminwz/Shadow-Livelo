package com.compasso.shadowlivelo.domain.dto;


import com.compasso.shadowlivelo.domain.model.Cidade;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDtoUpdate {

    private String nome;
    private String sobrenome;
    private char sexo;
    private LocalDate dataDeNascimento;
    private int idade;

    private Cidade cidade;

}
