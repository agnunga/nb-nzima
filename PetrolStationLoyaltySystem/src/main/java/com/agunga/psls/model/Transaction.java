/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agunga.psls.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author agunga
 */
@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "id")
    Customer customer;
    @Id
    private long id;
    private String particulas;
    private double amount;
    @ManyToOne
    private Account debitAccounts;
    @ManyToOne
    private Account creditAccounts;
    private LocalDateTime transactionTime;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getParticulas() {
        return particulas;
    }

    public void setParticulas(String particulas) {
        this.particulas = particulas;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getDebitAccounts() {
        return debitAccounts;
    }

    public void setDebitAccounts(Account debitAccounts) {
        this.debitAccounts = debitAccounts;
    }

    public Account getCreditAccounts() {
        return creditAccounts;
    }

    public void setCreditAccounts(Account creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

}
