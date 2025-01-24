package com.sconexsoft.ecom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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