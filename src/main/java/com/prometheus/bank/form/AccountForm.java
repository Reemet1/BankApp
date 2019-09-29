package com.prometheus.bank.form;

import com.prometheus.bank.form.validator.constraint.AccountNumberConstraint;
import com.prometheus.bank.form.validator.constraint.StartingBalanceConstraint;

public class AccountForm {

    @AccountNumberConstraint
    private String accountNumber;

    @StartingBalanceConstraint
    private double startingBalance;

    public AccountForm() {

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(double startingBalance) {
        this.startingBalance = startingBalance;
    }
}
