package com.sconexsoft.ecom.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "dealer_priority_log")
public class DealerPriorityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false) // Ensure the column name matches the database schema
    private Dealer dealer;

    private Integer priority;
    private LocalDateTime updateDateTime;

    // Default Constructor
    public DealerPriorityLog() {}

    // Constructor
    public DealerPriorityLog(Long logId, Dealer dealer, Integer priority, LocalDateTime updateDateTime) {
        this.logId = logId;
        this.dealer = dealer;
        this.priority = priority;
        this.updateDateTime = updateDateTime;
    }

    // Getters and Setters
    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DealerPriorityLog that = (DealerPriorityLog) o;
        return Objects.equals(logId, that.logId) &&
               Objects.equals(dealer, that.dealer) &&
               Objects.equals(priority, that.priority) &&
               Objects.equals(updateDateTime, that.updateDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, dealer, priority, updateDateTime);
    }
}
