package com.prometheus.bank.rest.controller;

import com.prometheus.bank.entity.Account;
import com.prometheus.bank.entity.Transaction;
import com.prometheus.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {

        List<Account> accounts = accountService.getAllAccounts();

        return accounts;
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable(value = "id") long accountId) {

        Account account = accountService.getAccount(accountId);

        return account;
    }

    @PostMapping("/createAccount")
    public String createAccount() {

        return "";
    }

    @PutMapping("/updateAccount")
    public String updateAccount() {
        return "";
    }

    @DeleteMapping
    public String deleteAccount() {
        return "";
    }

    @PostMapping("/makePayment")
    public String makePayment() {
        return "";
    }

    @GetMapping("/transactionsIn/{accountId}")
    public List<Transaction>  getTransactionsIn(@PathVariable(value = "accountId") long accountId) {

        List<Transaction> transactionsIn = accountService.getAccount(accountId).getTransactionsIn();

        return transactionsIn;
    }

    @GetMapping("/transactionsOut/{accountId}")
    public List<Transaction> getTransactionsOut(@PathVariable(value = "accountId") long accountId) {

        List<Transaction> transactionsOut = accountService.getAccount(accountId).getTransactionsOut();

        return transactionsOut;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
