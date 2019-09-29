package com.prometheus.bank.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id")
    private Client owner;

    @Column(name = "account_number")
    private String accountNumber;

    @OneToMany(mappedBy = "senderAccount", cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Transaction> transactionsOut;

    @OneToMany(mappedBy = "receiverAccount", cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Transaction> transactionsIn;

    @OneToMany(mappedBy = "account", cascade = CascadeType.MERGE)
    private List<Card> card;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "limit_id")
    //@LazyCollection(LazyCollectionOption.FALSE)
    private Limit accountLimits;

    @Column(name = "balance")
    private double balance;

    public Account() {

    }

    @Override
    public String toString() {
        return accountNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Transaction> getTransactionsOut() {
        return transactionsOut;
    }

    public void setTransactionsOut(List<Transaction> transactionsOut) {
        this.transactionsOut = transactionsOut;
    }

    public List<Transaction> getTransactionsIn() {
        return transactionsIn;
    }

    public void setTransactionsIn(List<Transaction> transactionsIn) {
        this.transactionsIn = transactionsIn;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Limit getAccountLimits() {
        return accountLimits;
    }

    public void setAccountLimits(Limit accountLimits) {
        this.accountLimits = accountLimits;
    }
}
