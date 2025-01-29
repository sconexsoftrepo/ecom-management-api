package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.OrderedItem;
import com.sconexsoft.ecom.repo.OrderedItemRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderedItemServiceImpl implements OrderedItemService {
    
    @Autowired
    private OrderedItemRepository orderedItemRepo; 

    @Override
    @Transactional
    public OrderedItem addOrderedItem(OrderedItem orderedItem) {
        return orderedItemRepo.save(orderedItem);
    }

    @Override
    public Optional<OrderedItem> getOrderedItemById(int orderedItemId) {
        return orderedItemRepo.findById(orderedItemId);
    }

    @Override
    public List<OrderedItem> getAllOrderedItems() {
        return orderedItemRepo.findAll();
    }

    @Override
    @Transactional
    public OrderedItem updateOrderedItem(OrderedItem orderedItem) {
    	if(orderedItemRepo.existsById(orderedItem.getOrdered_ItemId()))
    	{
    		return orderedItemRepo.save(orderedItem);
    	}
    	throw new IllegalArgumentException("OrderedItem with ID :" + orderedItem.getOrdered_ItemId() + ": does not exist.");
    }

    @Override
    @Transactional
    public boolean deleteOrderedItem(int orderedItemId) {
    	if(orderedItemRepo.existsById(orderedItemId))
    	{
    		orderedItemRepo.deleteById(orderedItemId);
    		return true;
    	}
    	return false;   
    }
}
