package ru.korovin.carSalesApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.korovin.carSalesApp.model.Order;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByOrderDateBetween(LocalDate beginningDate, LocalDate endDate);
}
