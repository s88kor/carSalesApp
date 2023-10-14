package ru.korovin.carSalesApp.utils;

import ru.korovin.carSalesApp.dto.model.OrderDto;
import ru.korovin.carSalesApp.model.Order;

public class OrderUtil {
    public static OrderDto convertToOrderDto (Order order) {
        if (order != null) {
            return new OrderDto()
                    .setFirstName(order.getCustomer().getFirstName())
                    .setLastName(order.getCustomer().getLastName())
                    .setPhoneNumber(order.getCustomer().getPhoneNumber())
                    .setTotalPrice(order.getTotalPrice())
                    .setOrderDate(order.getOrderDate())
                    .setCarModel(order.getCar().getCarModel())
                    .setCarQuantity(order.getCarQuantity());
        } else {
            return null;
        }
    }
}
