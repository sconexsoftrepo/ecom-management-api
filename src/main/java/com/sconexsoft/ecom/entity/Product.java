package com.sconexsoft.ecom.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products_table")
public class Product {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "product_id")
	 private Long productId;

    private String name;

    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category; // Many products belong to one category

    // Default constructor
    public Product() {
    }

    // Parameterized constructor
    public Product(Long productId, String name, int price, Category category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price, category);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product other = (Product) obj;
        return Objects.equals(productId, other.productId) &&
               Objects.equals(name, other.name) &&
               price == other.price &&
               Objects.equals(category, other.category);
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", category=" + category + "]";
    }
}
