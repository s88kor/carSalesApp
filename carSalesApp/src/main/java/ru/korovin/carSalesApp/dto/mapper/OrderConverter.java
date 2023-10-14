package ru.korovin.carSalesApp.dto.mapper;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.korovin.carSalesApp.dto.model.OrderDto;
import ru.korovin.carSalesApp.model.Order;

@Data
@Component
public class OrderConverter {

    private final ModelMapper modelMapper;

    public OrderConverter() {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    public OrderDto convertToDto(Order order) {
        return modelMapper.map(order, OrderDto.class);
    }
}
