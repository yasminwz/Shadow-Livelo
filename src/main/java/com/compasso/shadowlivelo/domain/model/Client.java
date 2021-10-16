package com.compasso.shadowlivelo.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_client")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_client")
    private String name;
    @Column(name = "lastName_client")
    private String lastName;
    @Column(name = "sex_client")
    private char sex;
    @Column(name = "birthDate_client")
    private LocalDate birthDate;
    @Column(name = "age_client")
    private int age;

    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST})
    @JoinColumn(name = "city_id")
    private City city;

}
