package ru.korovin.carSalesApp.controller.API;

import lombok.AllArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import ru.korovin.carSalesApp.dto.form.RevenueDto;
import ru.korovin.carSalesApp.dto.form.TimePeriodDto;
import ru.korovin.carSalesApp.dto.mapper.OrderConverter;
import ru.korovin.carSalesApp.dto.model.OrderDto;
import ru.korovin.carSalesApp.model.Order;
import ru.korovin.carSalesApp.service.OrderServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor

@RestController
@RequestMapping()
public class orderController {

    private  final OrderServiceImpl orderService;
    private final OrderConverter orderConverter;


    //Расчет выручки с указанием даты начала и окончания выборки
    @PostMapping("/revenue")
    public RevenueDto revenueForPerion (@RequestBody TimePeriodDto timePeriodDto) {
        return new RevenueDto().
                    setRevenue(
                            orderService.revenueForPeriod(timePeriodDto.getBeginningDate(), timePeriodDto.getEndDate())
                    );
    }
    //Массив заказов, упорядоченный по дате заказа, внутри даты по ФИ клиента, внутри клиента по сумме заказа
    @GetMapping("/allOrders")
    public List<OrderDto> showAllOrders () {
    return  orderService.showAllOrders()
            .stream()
            .map(orderConverter::convertToDto)
            .sorted (Comparator
                    .comparing(OrderDto::getOrderDate)
                    .thenComparing(OrderDto::getLastName)
                    .thenComparing(OrderDto::getFirstName)
                    .thenComparing(OrderDto::getTotalPrice))
            .collect(Collectors.toList());

    }


}
