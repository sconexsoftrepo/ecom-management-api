package com.sconexsoft.ecom.entity;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "product_outstock")
public class ProductOutStockTran {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tranId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false)
    private Dealer dealer;

    private Integer outstock;

    public ProductOutStockTran() {
    }
    
	public ProductOutStockTran(Long tranId, Product product, Dealer dealer, Integer outstock) {
		super();
		this.tranId = tranId;
		this.product = product;
		this.dealer = dealer;
		this.outstock = outstock;
	}
	
	// Getters and Setters
	public Long getTranId() {
		return tranId;
	}

	public void setTranId(Long tranId) {
		this.tranId = tranId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Integer getOutstock() {
		return outstock;
	}

	public void setOutstock(Integer outstock) {
		this.outstock = outstock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dealer, outstock, product, tranId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductOutStockTran other = (ProductOutStockTran) obj;
		return Objects.equals(dealer, other.dealer) && Objects.equals(outstock, other.outstock)
				&& Objects.equals(product, other.product) && Objects.equals(tranId, other.tranId);
	}

	@Override
	public String toString() {
		return "ProductOutStockTran [tranId=" + tranId + ", product=" + product + ", dealer=" + dealer
				+ ", outstock=" + outstock + "]";
	}
}
