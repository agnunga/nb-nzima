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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author agunga
 */
@NamedQueries({
    @NamedQuery(name = "findByCustomerId", query = "SELECT p FROM Purchase p WHERE p.id = :id")
})
@Entity
@Table(name = "points")
@XmlRootElement
public class Purchase implements Serializable {

    private static final double pointsPerLitre = 10;

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Vehicle.class)
    @JoinColumn(name = "vehicleRegNo")
    private long vehicleRegNo;

    private double litresPurchased;
    private double numberOfPoints;
    private LocalDateTime timeAddedOrRedeemed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(long vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public double getLitresPurchased() {
        return litresPurchased;
    }

    public void setLitresPurchased(double litresPurchased) {
        this.litresPurchased = litresPurchased;
    }

    public double getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(double litresPurchased) {
        this.numberOfPoints = litresPurchased * pointsPerLitre;
    }

    public LocalDateTime getTimeAddedOrRedeemed() {
        return timeAddedOrRedeemed;
    }

    public void setTimeAddedOrRedeemed(LocalDateTime timeAddedOrRedeemed) {
        this.timeAddedOrRedeemed = timeAddedOrRedeemed;
    }

}
