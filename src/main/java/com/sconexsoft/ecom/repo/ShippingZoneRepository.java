package com.sconexsoft.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sconexsoft.ecom.entity.ShippingZone;

public interface ShippingZoneRepository extends JpaRepository<ShippingZone, Integer> {
}
