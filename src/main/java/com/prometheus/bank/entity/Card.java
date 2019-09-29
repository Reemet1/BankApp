package com.prometheus.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "holder_id")
    private Client holder;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "valid_until")
    private LocalDate validUntil;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "account_id")
    private Account account;


    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Limit> cardLimits; */


    public Card() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getHolder() {
        return holder;
    }

    public void setHolder(Client holder) {
        this.holder = holder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    /*
    public List<Limit> getCardLimits() {
        return cardLimits;
    }

    public void setCardLimits(List<Limit> cardLimits) {
        this.cardLimits = cardLimits;
    } */
}
