package com.sconexsoft.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sconexsoft.ecom.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{
}
