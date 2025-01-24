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
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    private Integer instock;
    
    
    // default constructor
    public ProductInStockTran() {
	}

	//parameterized Constructor
    public ProductInStockTran(Long tranId, Product product, Dealer dealer, Integer instock) {
		super();
		this.tranId = tranId;
		this.product = product;
		this.dealer = dealer;
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

	public Integer getInstock() {
		return instock;
	}

	public void setInstock(Integer instock) {
		this.instock = instock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dealer, instock, product, tranId);
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
		return Objects.equals(dealer, other.dealer) && Objects.equals(instock, other.instock)
				&& Objects.equals(product, other.product) && Objects.equals(tranId, other.tranId);
	}

	@Override
	public String toString() {
		return "ProductInStockTran [tranId=" + tranId + ", product=" + product + ", dealer=" + dealer
				+ ", instock=" + instock + "]";
	}
    
}

