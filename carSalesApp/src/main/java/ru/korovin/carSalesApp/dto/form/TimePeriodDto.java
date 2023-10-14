package ru.korovin.carSalesApp.dto.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDate;

@Data
public class TimePeriodDto {
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate beginningDate;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate endDate;
}
