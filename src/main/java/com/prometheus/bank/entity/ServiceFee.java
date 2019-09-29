package com.prometheus.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "fees")
public class ServiceFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private double fee;

    @Column(name = "description")
    private String description;

    public ServiceFee() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
