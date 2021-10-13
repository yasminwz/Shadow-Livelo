package com.compasso.shadowLivelo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tb_cidade")
public class Cidade {
//Comentando a cidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_Cidade")
    private String nome;
    @Column(name = "estado_Cidade")
    private String estado;

}
