package ru.korovin.carSalesApp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter

@Entity
@Table
public class Car {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Car model may not be null")
    private String carModel;

//    @OneToMany(mappedBy = "car")
//    private List<Order> orders;


}
