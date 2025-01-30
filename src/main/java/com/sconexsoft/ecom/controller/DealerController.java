package com.sconexsoft.ecom.controller;

import com.sconexsoft.ecom.entity.Dealer;
import com.sconexsoft.ecom.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealers")
public class DealerController {

    @Autowired
    private DealerService dealerService;

    // Create a new dealer
    @PostMapping
    public ResponseEntity<Dealer> createDealer(@RequestBody Dealer dealer) {
        Dealer createdDealer = dealerService.addDealer(dealer);
        return new ResponseEntity<>(createdDealer, HttpStatus.CREATED);
    }

    // Get a dealer by ID
    @GetMapping("/{dealerId}")
    public ResponseEntity<Dealer> getDealerById(@PathVariable int dealerId) {
        Dealer dealer = dealerService.getDealerById(dealerId);
        return new ResponseEntity<>(dealer, HttpStatus.OK);
    }

    // Get all dealers
    @GetMapping
    public ResponseEntity<List<Dealer>> getAllDealers() {
        List<Dealer> dealers = dealerService.getAllDealers();
        return new ResponseEntity<>(dealers, HttpStatus.OK);
    }

    // Update a dealer by ID
    @PutMapping("/{dealerId}")
    public ResponseEntity<Dealer> updateDealer(@PathVariable int dealerId, @RequestBody Dealer dealer) {
        Dealer updatedDealer = dealerService.updateDealer(dealerId, dealer);
        return new ResponseEntity<>(updatedDealer, HttpStatus.OK);
    }

    // Delete a dealer by ID
    @DeleteMapping("/{dealerId}")
    public ResponseEntity<Void> deleteDealer(@PathVariable int dealerId) {
        dealerService.deleteDealer(dealerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}