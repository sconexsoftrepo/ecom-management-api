package com.sconexsoft.ecom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("DEALER") // Distinguishes records in the single-table hierarchy
public class Dealer extends EcomUser {

    @Column(name = "title", nullable = false, length = 100)
    private String title; // Dealer-specific title

    @Column(name = "priority", nullable = false)
    private int priority; // Dealer priority

    @OneToMany(mappedBy = "dealer")
    private List<DealerPriorityLog> priorityLogs; // Bidirectional relationship to DealerPriorityLog

    // Default Constructor
    public Dealer() {
    }

    // Parameterized Constructor
    public Dealer(int userId, String firstName, String lastName, String mobile, String mailId, String password, Role role, String title, int priority) {
        super(userId, firstName, lastName, mobile, mailId, password, role); // Calls the parent constructor
        this.title = title;
        this.priority = priority;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<DealerPriorityLog> getPriorityLogs() {
        return priorityLogs;
    }

    public void setPriorityLogs(List<DealerPriorityLog> priorityLogs) {
        this.priorityLogs = priorityLogs;
    }

    @Override
    public String toString() {
        return "Dealer [title=" + title + ", priority=" + priority + "] " + super.toString();
    }
}
