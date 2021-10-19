package com.compasso.shadowlivelo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_city")
    @NotBlank(message = "You cannot enter an empty or null city name")
    private String name;

    @Column(name = "state_city")
    @NotBlank(message = "You cannot enter an empty or null state")
    private String state;


}
