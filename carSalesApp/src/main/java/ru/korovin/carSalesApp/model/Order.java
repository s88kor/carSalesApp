package ru.korovin.carSalesApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private LocalDate orderDate;
    private int totalPrice;
    private int carQuantity;

    @ManyToOne
    @JoinColumn(name="id_car", referencedColumnName = "id" )
    private Car car;

    @ManyToOne
    @JoinColumn(name="id_customer", referencedColumnName = "id" )
    private Customer customer;


}
