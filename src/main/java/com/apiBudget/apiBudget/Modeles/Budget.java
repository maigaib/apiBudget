package com.apiBudget.apiBudget.Modeles;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private double montantMax;

    @Column(nullable = false)
    private double montantAlert;

    @Column(nullable = false)
    private Date date;

    public Budget(long id, double montantMax, double montantAlert, Date date) {
        this.id = id;
        this.montantMax = montantMax;
        this.montantAlert = montantAlert;
        this.date = date;
    }

    public Budget() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMontantMax() {
        return montantMax;
    }

    public void setMontantMax(double montantMax) {
        this.montantMax = montantMax;
    }

    public double getMontantAlert() {
        return montantAlert;
    }

    public void setMontantAlert(double montantAlert) {
        this.montantAlert = montantAlert;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
