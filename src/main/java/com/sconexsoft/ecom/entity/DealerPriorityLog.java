package com.sconexsoft.ecom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DealerPriorityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for DealerPriorityLog

    private String logDetail; // Example log detail (customize as needed)

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false) // Foreign key to Dealer
    private Dealer dealer; // Bidirectional relationship to Dealer

    // Default Constructor
    public DealerPriorityLog() {
    }

    // Parameterized Constructor
    public DealerPriorityLog(String logDetail, Dealer dealer) {
        this.logDetail = logDetail;
        this.dealer = dealer;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogDetail() {
        return logDetail;
    }

    public void setLogDetail(String logDetail) {
        this.logDetail = logDetail;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    @Override
    public String toString() {
        return "DealerPriorityLog [id=" + id + ", logDetail=" + logDetail + "]";
    }
}
