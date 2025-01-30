package com.sconexsoft.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sconexsoft.ecom.entity.OrderedItem;

public interface OrderedItemRepository extends JpaRepository<OrderedItem,Integer>{
}
