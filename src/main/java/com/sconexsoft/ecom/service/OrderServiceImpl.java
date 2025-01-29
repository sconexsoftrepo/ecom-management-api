package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.Order;
import com.sconexsoft.ecom.repo.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepo;

	@Override
	@Transactional
	public Order addOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Optional<Order> getOrderById(int orderId) {
		return orderRepo.findById(orderId);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	@Transactional
	public Order updateOrder(Order order) {
		if(orderRepo.existsById(order.getOrderId()))
		{
			return orderRepo.save(order);
		}
		throw new IllegalArgumentException("Order with ID " + order.getOrderId() + " does not exist.");
	}

	@Override
	@Transactional
	public boolean deleteOrder(int orderId) {
		if(orderRepo.existsById(orderId))
		{
			orderRepo.deleteById(orderId);
			return true;
		}
		return false;
	}
	
}
