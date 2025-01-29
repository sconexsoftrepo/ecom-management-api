package com.sconexsoft.ecom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sconexsoft.ecom.entity.OrderedItem;
import com.sconexsoft.ecom.service.OrderedItemService;

@RestController
@RequestMapping("/ordereditem")
public class OrderedItemController {

    @Autowired
    private OrderedItemService orderedItemService;

    // Get all OrderedItems
    @GetMapping
    public ResponseEntity<List<OrderedItem>> getAllOrderedItems() {
        List<OrderedItem> orderedItems = orderedItemService.getAllOrderedItems();
        if (orderedItems.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(orderedItems);
    }

    @GetMapping("/{id}")
	public ResponseEntity<OrderedItem> getOrderedItemById(@PathVariable("id") int orderedItemId)
	{
		Optional<OrderedItem> orderedItemById = orderedItemService.getOrderedItemById(orderedItemId);
		if(orderedItemById.isEmpty())
		{
			return ResponseEntity.ok(orderedItemById.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

    // Create a new OrderedItem
    @PostMapping
    public ResponseEntity<OrderedItem> createOrderedItem(@RequestBody OrderedItem orderedItem) {
        OrderedItem addedOrderedItem = orderedItemService.addOrderedItem(orderedItem);
        return new ResponseEntity<>(addedOrderedItem, HttpStatus.CREATED);
    }

    // Update an existing OrderedItem
    @PutMapping("/{id}")
    public ResponseEntity<OrderedItem> updateOrderedItem(
            @PathVariable("id") int orderedItemId,
            @RequestBody OrderedItem updatedOrderedItem) {

        Optional<OrderedItem> existingOrderedItem = orderedItemService.getOrderedItemById(orderedItemId);

        if (existingOrderedItem.isPresent()) {
            updatedOrderedItem.setOrdered_ItemId(orderedItemId);
            OrderedItem updated = orderedItemService.updateOrderedItem(updatedOrderedItem);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete an OrderedItem by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderedItem(@PathVariable("id") int orderedItemId) {
        Optional<OrderedItem> existingOrderedItem = orderedItemService.getOrderedItemById(orderedItemId);

        if (existingOrderedItem.isPresent()) {
            orderedItemService.deleteOrderedItem(orderedItemId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
