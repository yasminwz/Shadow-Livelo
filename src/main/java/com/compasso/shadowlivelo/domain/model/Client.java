package com.compasso.shadowlivelo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
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
    @NotBlank(message = "You cannot enter an empty or null name")
    private String name;

    @Column(name = "lastName_client")
    @NotBlank(message = "You cannot enter an empty or null last Name")
    private String lastName;

    @Column(name = "gender_client")
    @NotBlank(message = "You cannot enter an empty or null gender")
    @Size(min = 1, max = 1, message = "Size cannot be larger or smaller than 1")
    private String gender;

    @Column(name = "birthDate_client")
    @Past(message = "You cannot be born one day ahead of the current day")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate birthDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

}
