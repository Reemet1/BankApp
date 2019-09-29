package com.prometheus.bank.form;

import com.prometheus.bank.form.validator.constraint.CardNumberConstraint;

public class CardForm {

    @CardNumberConstraint
    private String cardNumber;

    private long accountId;

    public CardForm(){

    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
