package com.compasso.shadowlivelo.domain.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_Cliente")
    private String nome;
    @Column(name = "sobrenome_Cliente")
    private String sobrenome;
    @Column(name = "sexo_Cliente")
    private char sexo;
    @Column(name = "nascimento_Cliente")
    private LocalDate dataDeNascimento;
    @Column(name = "idade_Cliente")
    private int idade;

    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST})
    @JoinColumn(name = "cliente_id")
    private Cidade cidade;

}
