package com.sconexsoft.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sconexsoft.ecom.entity.Offer;
import com.sconexsoft.ecom.service.OfferService;

@RestController
@RequestMapping("/offers")
public class OffersController {

    @Autowired
    private OfferService offerService;

    // Get all offers
    @GetMapping
    public ResponseEntity<List<Offer>> getAllOffers() {
        List<Offer> offers = offerService.getAllOffers();
        if (offers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(offers);
    }

    // Get offer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") Long id) {
        Offer offer = offerService.getOfferById(id).orElse(null);
        return offer != null ? ResponseEntity.ok(offer) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Create a new offer
    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        Offer createdOffer = offerService.addOffer(offer);
        return new ResponseEntity<>(createdOffer, HttpStatus.CREATED);
    }

    // Update an existing offer
    @PutMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable("id") Long id, @RequestBody Offer updatedOffer) {
        Offer existingOffer = offerService.getOfferById(id).orElse(null);
        if (existingOffer != null) {
            updatedOffer.setId(id); // Ensure the ID remains unchanged
            Offer savedOffer = offerService.updateOffer(updatedOffer);
            return ResponseEntity.ok(savedOffer);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete an offer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable("id") Long id) {
        boolean isDeleted = offerService.deleteOffer(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}