package ru.korovin.carSalesApp.service;

import ru.korovin.carSalesApp.model.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

     int revenueForPeriod(LocalDate beginningDate, LocalDate endDate);
     List<Order> showAllOrders ();
}
