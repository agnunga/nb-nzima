/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author agunga
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "customers")
public class Customer extends Person {

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//    Customer customer;
    private long customerId;
    private double litresPurchased;
    private LocalDateTime transactionTime;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getLitresPurchased() {
        return litresPurchased;
    }

    public void setLitresPurchased(double litresPurchased) {
        this.litresPurchased = litresPurchased;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

}
