package com.prometheus.bank.form;

import com.prometheus.bank.form.validator.constraint.InvoiceConstraint;
import com.prometheus.bank.form.validator.constraint.NameConstraint;
import com.prometheus.bank.form.validator.constraint.TransactionAmountConstraint;

public class TransactionForm {

    @NameConstraint
    private String receiverName;

    @NameConstraint
    private String receiverAccount;

    @InvoiceConstraint
    private long invoice;

    @TransactionAmountConstraint
    private double amount;

    private String comment;

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public long getInvoice() {
        return invoice;
    }

    public void setInvoice(long invoice) {
        this.invoice = invoice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
