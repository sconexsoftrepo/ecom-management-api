package com.sconexsoft.ecom.entity;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "product_instock")
public class ProductInStockTran {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tranId;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false) // Maps to the column "product_id" in the database
	private Product productId;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealerId;

    private Integer instock;
    
    
    // default constructor
    public ProductInStockTran() {
	}

	//parameterized Constructor
    public ProductInStockTran(Long tranId, Product productId, Dealer dealerId, Integer instock) {
		super();
		this.tranId = tranId;
		this.productId = productId;
		this.dealerId = dealerId;
		this.instock = instock;
	}

	// Getters and Setters
    public Long getTranId() {
		return tranId;
	}

	public void setTranId(Long tranId) {
		this.tranId = tranId;
	}

	public Product getProduct() {
		return productId;
	}

	public void setProduct(Product product) {
		this.productId = product;
	}

	public Dealer getDealer() {
		return dealerId;
	}

	public void setDealer(Dealer dealer) {
		this.dealerId = dealer;
	}

	public Integer getInstock() {
		return instock;
	}

	public void setInstock(Integer instock) {
		this.instock = instock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dealerId, instock, productId, tranId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInStockTran other = (ProductInStockTran) obj;
		return Objects.equals(dealerId, other.dealerId) && Objects.equals(instock, other.instock)
				&& Objects.equals(productId, other.productId) && Objects.equals(tranId, other.tranId);
	}

	@Override
	public String toString() {
		return "ProductInStockTran [tranId=" + tranId + ", product=" + productId + ", dealer=" + dealerId
				+ ", instock=" + instock + "]";
	}
    
}

