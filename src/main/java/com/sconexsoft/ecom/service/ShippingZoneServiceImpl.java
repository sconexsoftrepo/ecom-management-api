package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.ShippingZone;
import com.sconexsoft.ecom.repo.ShippingZoneRepository;

@Service
public class ShippingZoneServiceImpl implements ShippingZoneService{

    @Autowired
    private ShippingZoneRepository repository;

    // Retrieve all zones
    public List<ShippingZone> getAllZones() {
        return repository.findAll();
    }

    // Retrieve a zone by ID
    public Optional<ShippingZone> getZoneById(int id) {
        return repository.findById(id);
    }

    // Create or update a zone
    public ShippingZone saveZone(ShippingZone zone) {
        return repository.save(zone);
    }

    // Delete a zone by ID
    public void deleteZone(int id) {
        repository.deleteById(id);
    }
}
