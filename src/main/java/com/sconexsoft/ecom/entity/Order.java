package com.sconexsoft.ecom.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders_table")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    
    private int consumerId;
    
    private double order_grossValue;
    
    private int discount;
    
    private double order_netValue;
    
    @ManyToOne
    @JoinColumn(name = "offer_id", referencedColumnName = "offerId") // Fix: Use "offerId" here instead of "id"
    private Offer offerId;
    
    private LocalDateTime order_DateTime;
    
    private String order_Status;
    
    // default constructor
    public Order() {
        super();
    }
    
    // parameterized constructor
    public Order(int orderId, int consumerId, double order_grossValue, int discount, double order_netValue,
            Offer offerId, LocalDateTime order_DateTime, String order_Status) {
        super();
        this.orderId = orderId;
        this.consumerId = consumerId;
        this.order_grossValue = order_grossValue;
        this.discount = discount;
        this.order_netValue = order_netValue;
        this.offerId = offerId;
        this.order_DateTime = order_DateTime;
        this.order_Status = order_Status;
    }

    // getters and setters
    public int getOrderId() {
        return orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public double getOrder_grossValue() {
        return order_grossValue;
    }

    public void setOrder_grossValue(double order_grossValue) {
        this.order_grossValue = order_grossValue;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getOrder_netValue() {
        return order_netValue;
    }

    public void setOrder_netValue(double order_netValue) {
        this.order_netValue = order_netValue;
    }

    public Offer getOfferId() {
        return offerId;
    }

    public void setOfferId(Offer offerId) {
        this.offerId = offerId;
    }

    public LocalDateTime getOrder_DateTime() {
        return order_DateTime;
    }

    public void setOrder_DateTime(LocalDateTime order_DateTime) {
        this.order_DateTime = order_DateTime;
    }

    public String getOrder_Status() {
        return order_Status;
    }

    public void setOrder_Status(String order_Status) {
        this.order_Status = order_Status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumerId, discount, offerId, orderId, order_DateTime, order_Status, order_grossValue,
                order_netValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        return consumerId == other.consumerId && discount == other.discount && Objects.equals(offerId, other.offerId)
                && orderId == other.orderId && Objects.equals(order_DateTime, other.order_DateTime)
                && Objects.equals(order_Status, other.order_Status)
                && Double.doubleToLongBits(order_grossValue) == Double.doubleToLongBits(other.order_grossValue)
                && Double.doubleToLongBits(order_netValue) == Double.doubleToLongBits(other.order_netValue);
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", consumerId=" + consumerId + ", order_grossValue=" + order_grossValue
                + ", discount=" + discount + ", order_netValue=" + order_netValue + ", offerId=" + offerId
                + ", order_DateTime=" + order_DateTime + ", order_Status=" + order_Status + "]";
    }
    
}
