package ru.korovin.carSalesApp.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)

public class OrderDto {

    private String lastName;
    private String firstName;
    private String phoneNumber;
    private int totalPrice;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate orderDate;
    private String carModel;
    private int carQuantity;

}
