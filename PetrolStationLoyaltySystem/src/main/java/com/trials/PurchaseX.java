/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trials;

import com.agunga.psls.model.Vehicle;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author agunga
 */
@Entity
@Table(name = "purchases")
public class PurchaseX implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Vehicle.class)
    @JoinColumn(name = "vehicleRegNo")

    private double litresPurchased;
    private char typeOfTransaction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLitresPurchased() {
        return litresPurchased;
    }

    public void setLitresPurchased(double litresPurchased) {
        this.litresPurchased = litresPurchased;
    }

    public char getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(char typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

}
