package com.prometheus.bank.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sender_id")
    private Client sender;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "receiver_id")
    private Client receiver;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sender_account_id")
    private Account senderAccount;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "receiver_account_id")
    private Account receiverAccount;

    @Column(name = "invoice")
    private String invoice;

    @Column(name = "comment")
    private String comment;

    @Column(name = "datetime")
    private LocalDateTime sendDateTime;

    @Column(name = "amount")
    private double amount;


    public Transaction() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Client getReceiver() {
        return receiver;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(LocalDateTime sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
