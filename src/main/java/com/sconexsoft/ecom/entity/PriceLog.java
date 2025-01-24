package com.sconexsoft.ecom.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "price_log_table")
public class PriceLog {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Double price;
    private LocalDateTime updateDateTime;
    
    // default constructor
    public PriceLog() {
	}
    
    // parameterized constructor
	public PriceLog(Long logId, Product product, Double price, LocalDateTime updateDateTime) {
		super();
		this.logId = logId;
		this.product = product;
		this.price = price;
		this.updateDateTime = updateDateTime;
	}

	// Getters and Setters
	public Long getLogId() {
		return logId;
	}
	
	public void setLogId(Long logId) {
		this.logId = logId;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(logId, price, product, updateDateTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceLog other = (PriceLog) obj;
		return Objects.equals(logId, other.logId) && Objects.equals(price, other.price)
				&& Objects.equals(product, other.product) && Objects.equals(updateDateTime, other.updateDateTime);
	}

	@Override
	public String toString() {
		return "PriceLog [logId=" + logId + ", product=" + product + ", price=" + price + ", updateDateTime="
				+ updateDateTime + "]";
	}

}