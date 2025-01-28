package com.sconexsoft.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sconexsoft.ecom.entity.ShippingZone;
import com.sconexsoft.ecom.service.ShippingZoneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shippingZones")
public class ShippingZoneController {

    @Autowired
    private ShippingZoneService service;

    @GetMapping
    public List<ShippingZone> getAllZones() {
        return service.getAllZones();
    }

    @GetMapping("/{id}")
    public Optional<ShippingZone> getZoneById(@PathVariable int id) {
        return service.getZoneById(id);
    }

    @PostMapping
    public ShippingZone createZone(@RequestBody ShippingZone zone) {
        return service.saveZone(zone);
    }

    @DeleteMapping("/{id}")
    public void deleteZone(@PathVariable int id) {
        service.deleteZone(id);
    }
}
