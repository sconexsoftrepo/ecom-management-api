package com.sconexsoft.ecom.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_outstock")
public class ProductOutStockTran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tran_id")
    private Long tranId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false)
    private Dealer dealer; // Assuming a Dealer entity exists

    // Default constructor
    public ProductOutStockTran() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tranId, product, quantity, dealer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProductOutStockTran other = (ProductOutStockTran) obj;
        return Objects.equals(tranId, other.tranId) &&
               Objects.equals(product, other.product) &&
               quantity == other.quantity &&
               Objects.equals(dealer, other.dealer);
    }

    @Override
    public String toString() {
        return "ProductOutStockTran [tranId=" + tranId + ", product=" + product + ", quantity=" + quantity + ", dealer=" + dealer + "]";
    }
}
