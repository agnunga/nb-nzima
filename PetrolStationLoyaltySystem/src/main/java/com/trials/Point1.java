/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trials;

import com.agunga.psls.model.Customer;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author agunga
 */ 
@Entity
@Table(name = "purchase")
public class Point1 implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JoinColumn(name = "customerId")
    private long customerId;
    private long numberOfPoints;
    private char typeOfTransaction;
    private LocalDateTime timeAddedOrRedeemed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(long numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public LocalDateTime getTimeAddedOrRedeemed() {
        return timeAddedOrRedeemed;
    }

    public void setTimeAddedOrRedeemed(LocalDateTime timeAddedOrRedeemed) {
        this.timeAddedOrRedeemed = timeAddedOrRedeemed;
    }

    public char getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(char typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

}
