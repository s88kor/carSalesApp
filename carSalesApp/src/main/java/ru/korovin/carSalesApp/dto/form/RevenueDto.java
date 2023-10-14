package ru.korovin.carSalesApp.dto.form;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)

public class RevenueDto {
    private int revenue;
}
