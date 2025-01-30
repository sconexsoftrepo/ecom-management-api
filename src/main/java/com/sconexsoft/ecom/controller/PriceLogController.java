package com.sconexsoft.ecom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sconexsoft.ecom.entity.PriceLog;
import com.sconexsoft.ecom.service.PriceLogService;

@RestController
@RequestMapping("/pricelogs")
public class PriceLogController {

    @Autowired
    private PriceLogService priceLogService;

    // Create a new price log
    @PostMapping
    public ResponseEntity<PriceLog> createPriceLog(@RequestBody PriceLog priceLog) {
        PriceLog createdLog = priceLogService.addPriceLog(priceLog);
        return ResponseEntity.ok(createdLog);
    }

    // Get price log by ID
    @GetMapping("/{logId}")
    public ResponseEntity<PriceLog> getPriceLogById(@PathVariable Long logId) {
        Optional<PriceLog> priceLog = priceLogService.getPriceLogById(logId);
        return priceLog.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all price logs for a specific product by productId
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<PriceLog>> getPriceLogsByProductId(@PathVariable Long productId) {
        // Method getPriceLogsByProductId should exist in the service layer if needed.
        // Uncomment the below line if implemented.
        // List<PriceLog> priceLogs = priceLogService.getPriceLogsByProductId(productId);
        // return ResponseEntity.ok(priceLogs);
        return ResponseEntity.badRequest().body(null); // Placeholder, remove this line when implemented
    }

    // Get all price logs
    @GetMapping
    public ResponseEntity<List<PriceLog>> getAllPriceLogs() {
        List<PriceLog> priceLogs = priceLogService.getAllPriceLogs();
        return ResponseEntity.ok(priceLogs);
    }
    
    // Update a price log
    @PutMapping("/{logId}")
    public ResponseEntity<PriceLog> updatePriceLog(@PathVariable Long logId, @RequestBody PriceLog priceLog) {
        if (!logId.equals(priceLog.getLogId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try {
            PriceLog updatedLog = priceLogService.updatePriceLog(priceLog);
            return ResponseEntity.ok(updatedLog);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a price log by ID
    @DeleteMapping("/{logId}")
    public ResponseEntity<String> deletePriceLog(@PathVariable Long logId) {
        if (priceLogService.deletePriceLog(logId)) {
            return ResponseEntity.ok("Price log deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}