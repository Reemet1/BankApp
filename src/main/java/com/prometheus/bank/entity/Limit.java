package com.prometheus.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "limits")
public class Limit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(mappedBy = "accountLimits", cascade = CascadeType.ALL)
    private Account account;

    @Column(name = "type")
    private String type;

    @Column(name = "transaction_limit")
    private double transactionLimit;

    @Column(name = "daily_limit")
    private double dailyLimit;

    @Column(name = "monthly_limit")
    private double monthlyLimit;

    public Limit() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setTransactionLimit(double transactionLimit) {
        this.transactionLimit = transactionLimit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTransactionLimit() {
        return transactionLimit;
    }

    public void setTrasnactionLimit(double trasnactionLimit) {
        this.transactionLimit = trasnactionLimit;
    }

    public double getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(double dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public double getMonthlyLimit() {
        return monthlyLimit;
    }

    public void setMonthlyLimit(double monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }
}
