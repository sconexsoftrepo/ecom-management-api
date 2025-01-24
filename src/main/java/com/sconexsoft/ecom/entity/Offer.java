package com.sconexsoft.ecom.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "offers_table")
public class Offer {

    @Id
    @GeneratedValue
    private Long offerId;
    private String code;
    private String description;
    private double discountPercentage;
    
    
    // default constructor
    public Offer() {
	}
    
    // parameterized constructor
	public Offer(Long offerId, String code, String description, double discountPercentage) {
		super();
		this.offerId = offerId;
		this.code = code;
		this.description = description;
		this.discountPercentage = discountPercentage;
	}

	// Getters and Setters
    public Long getId() {
        return offerId;
    }

    public void setId(Long offerId) {
        this.offerId = offerId;
    }

    public String getName() {
        return code;
    }

    public void setName(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

	@Override
	public int hashCode() {
		return Objects.hash(description, discountPercentage, offerId, code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		return Objects.equals(description, other.description)
				&& Double.doubleToLongBits(discountPercentage) == Double.doubleToLongBits(other.discountPercentage)
				&& Objects.equals(offerId, other.offerId) && Objects.equals(code, other.code);
	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", code=" + code + ", description=" + description
				+ ", discountPercentage=" + discountPercentage + "]";
	}
}
