package ru.korovin.carSalesApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String lastName;
    private String firstName;
    private String phoneNumber;

//    @OneToMany(mappedBy = "customer")
//    private List<Order> orders;
}
