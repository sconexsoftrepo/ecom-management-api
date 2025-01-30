package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import com.sconexsoft.ecom.entity.OrderedItem;

public interface OrderedItemService {
    
    OrderedItem addOrderedItem(OrderedItem orderedItem);

    Optional<OrderedItem> getOrderedItemById(int orderedItemId);

    List<OrderedItem> getAllOrderedItems();

    OrderedItem updateOrderedItem(OrderedItem orderedItem);

    boolean deleteOrderedItem(int orderedItemId);
}
