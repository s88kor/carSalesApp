package ru.korovin.carSalesApp.controller.API;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.korovin.carSalesApp.dto.form.RevenueDto;
import ru.korovin.carSalesApp.dto.form.TimePeriodDto;
import ru.korovin.carSalesApp.dto.model.OrderDto;
import ru.korovin.carSalesApp.service.OrderServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ru.korovin.carSalesApp.utils.OrderUtil.convertToOrderDto;

@AllArgsConstructor

@RestController
@RequestMapping()
public class orderController {

    private  final OrderServiceImpl orderService;

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
        return orderService.showAllOrders()
                .stream()
                .map(order -> convertToOrderDto(order))
                .sorted (Comparator
                        .comparing(OrderDto::getOrderDate)
                        .thenComparing(OrderDto::getLastName)
                        .thenComparing(OrderDto::getFirstName)
                        .thenComparing(OrderDto::getTotalPrice))
                .collect(Collectors.toList());
    }


}
