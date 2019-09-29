package com.prometheus.bank.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "type")
    private String type;

    @Column(name = "loan_amount")
    private double loanAmount;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "total_payback_time")
    private int totalPaybackTime;

    @Column(name = "payback_amount")
    private double paybackAmount;

    @Column(name = "monthly_payment_amount")
    private double monthlyPaymentAmount;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id")
    private Document contract;

    public Loan() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTotalPaybackTime() {
        return totalPaybackTime;
    }

    public void setTotalPaybackTime(int totalPaybackTime) {
        this.totalPaybackTime = totalPaybackTime;
    }

    public double getPaybackAmount() {
        return paybackAmount;
    }

    public void setPaybackAmount(double paybackAmount) {
        this.paybackAmount = paybackAmount;
    }

    public double getMonthlyPaymentAmount() {
        return monthlyPaymentAmount;
    }

    public void setMonthlyPaymentAmount(double monthlyPaymentAmount) {
        this.monthlyPaymentAmount = monthlyPaymentAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Document getContract() {
        return contract;
    }

    public void setContract(Document contract) {
        this.contract = contract;
    }
}
