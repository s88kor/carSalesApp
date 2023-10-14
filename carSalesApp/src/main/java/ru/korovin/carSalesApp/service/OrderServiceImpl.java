package ru.korovin.carSalesApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.korovin.carSalesApp.model.Order;
import ru.korovin.carSalesApp.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;



    public int revenueForPeriod (LocalDate beginningDate, LocalDate endDate) {
        List<Order> orderList = orderRepository.findByOrderDateBetween(beginningDate, endDate);
        if (orderList != null) {
            return orderList.stream().mapToInt(order -> order.getTotalPrice()).sum();
        } else
            return  0;
    }
    @Override
    public List <Order> showAllOrders () {
        return orderRepository.findAll();
    }
}
