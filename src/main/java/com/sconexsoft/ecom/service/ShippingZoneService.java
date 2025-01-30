package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;
import com.sconexsoft.ecom.entity.ShippingZone;

public interface ShippingZoneService {
	
	public List<ShippingZone> getAllZones();
	
	public Optional<ShippingZone> getZoneById(int id);
	
	public ShippingZone addZone(ShippingZone zone);
	
	public void deleteZone(int id);
}
