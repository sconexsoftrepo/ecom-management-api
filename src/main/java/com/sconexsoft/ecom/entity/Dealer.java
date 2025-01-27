package com.sconexsoft.ecom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DEALER")
public class Dealer extends EcomUser {

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "priority", nullable = false)
    private int priority;

    // Default Constructor
    public Dealer() {
    }

    // Parameterized Constructor
    public Dealer(String title, int priority) {
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

    @Override
    public String toString() {
        return "Dealer [title=" + title + ", priority=" + priority + "] " + super.toString();
    }
}
