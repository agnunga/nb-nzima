/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author agunga
 */
@Entity
@Table(name = "vehicles", uniqueConstraints = @UniqueConstraint(columnNames = "regNo"))
public class Vehicle implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JoinColumn(name = "customerId")
    private int customerId;

    @Id
    private String regNo;

    public String getRegNo() {
        return regNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

}
