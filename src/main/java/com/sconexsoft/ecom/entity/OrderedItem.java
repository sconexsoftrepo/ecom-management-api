package com.sconexsoft.ecom.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordered_item")
public class OrderedItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ordered_ItemId;
	
	@ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
	private Product product_Id;
	
	private int quantity;
	
	private double price;
	
	private double cost;
	
	// default constructor
	public OrderedItem() {
		super();
	}
	
	// parameterized constructor
	public OrderedItem(int ordered_ItemId, Product product_Id, int quantity, double price, double cost) {
		super();
		this.ordered_ItemId = ordered_ItemId;
		this.product_Id = product_Id;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
	}



	// getters and getters
	public int getOrdered_ItemId() {
		return ordered_ItemId;
	}

	public void setOrdered_ItemId(int ordered_ItemId) {
		this.ordered_ItemId = ordered_ItemId;
	}


	public Product getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(Product product_Id) {
		this.product_Id = product_Id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(cost, ordered_ItemId, price, product_Id, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderedItem other = (OrderedItem) obj;
		return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
				&& ordered_ItemId == other.ordered_ItemId
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(product_Id, other.product_Id) && quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "OrderedItem [ordered_ItemId=" + ordered_ItemId + ", product_Id=" + product_Id + ", quantity=" + quantity
				+ ", price=" + price + ", cost=" + cost + "]";
	}
}
