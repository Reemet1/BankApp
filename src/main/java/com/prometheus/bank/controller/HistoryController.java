package com.prometheus.bank.controller;

import com.prometheus.bank.entity.Account;
import com.prometheus.bank.entity.Transaction;
import com.prometheus.bank.service.AccountService;
import com.prometheus.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    AccountService accountService;

    @Autowired
    UserService userService;

    @Autowired
    private HttpServletRequest context;

    @RequestMapping("/test")
    public String method() {
        return "user/history";
    }

    @RequestMapping("/show")
    @PreAuthorize("hasPermission(b,3)")
    public String showHistory(Model model) {

        List<Transaction> transactions = new ArrayList<>();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Account> accounts = userService.getUser(user.getUsername()).getClient().getAccounts();

        for(Account account : accounts) {
            transactions.addAll(account.getTransactionsIn());
            transactions.addAll(account.getTransactionsOut());
        }

        model.addAttribute("transactions", transactions);

        return "user/history";
    }

}
