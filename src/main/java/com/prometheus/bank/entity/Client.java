package com.prometheus.bank.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userAccount;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private ClientDetails clientDetails;

    @JsonBackReference
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Account> accounts;

    @JsonBackReference
    @OneToMany(mappedBy = "holder", cascade = CascadeType.ALL)
    private List<Card> bankCards;

    @OneToMany(mappedBy = "client", cascade = CascadeType.MERGE)
    private List<Loan> loans;

    @OneToMany(mappedBy = "client", cascade = CascadeType.MERGE)
    private List<Document> documents;

    public Client() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(User userAccount) {
        this.userAccount = userAccount;
    }

    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Card> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<Card> bankCards) {
        this.bankCards = bankCards;
    }

}
