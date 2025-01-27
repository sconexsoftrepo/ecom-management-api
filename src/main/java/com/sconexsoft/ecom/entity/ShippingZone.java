package com.sconexsoft.ecom.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shipping_zones")
public class ShippingZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zoneId;
    
    @Column(name = "zone_name", nullable = false)
    private String zoneName;

    private Long lowerBound;
    private Long upperBound;
    private int cost;

    // Getters and Setters
    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Long getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(Long lowerBound) {
        this.lowerBound = lowerBound;
    }

    public Long getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(Long upperBound) {
        this.upperBound = upperBound;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

	@Override
	public int hashCode() {
		return Objects.hash(cost, lowerBound, upperBound, zoneId, zoneName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShippingZone other = (ShippingZone) obj;
		return cost == other.cost && Objects.equals(lowerBound, other.lowerBound)
				&& Objects.equals(upperBound, other.upperBound) && zoneId == other.zoneId
				&& Objects.equals(zoneName, other.zoneName);
	}

	@Override
	public String toString() {
		return "ShippingZone [zoneId=" + zoneId + ", zoneName=" + zoneName + ", lowerBound=" + lowerBound
				+ ", upperBound=" + upperBound + ", cost=" + cost + "]";
	}
  
}
