package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import com.sconexsoft.ecom.entity.Order;

public interface OrderService {

    Order addOrder(Order order);

    Optional<Order> getOrderById(int orderId);

    List<Order> getAllOrders();

    Order updateOrder(Order order);

    boolean deleteOrder(int orderId);

}
