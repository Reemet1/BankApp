package com.prometheus.bank.controller;

import com.prometheus.bank.entity.Account;
import com.prometheus.bank.entity.Client;
import com.prometheus.bank.entity.Transaction;
import com.prometheus.bank.service.AccountService;
import com.prometheus.bank.service.ClientService;
import com.prometheus.bank.service.UserService;
import com.prometheus.bank.form.TransactionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/payments")
public class TransactionController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest context;

    @RequestMapping("/show")
    public String showTransactions(Model model) {

        TransactionForm transactionForm = new TransactionForm();
        model.addAttribute("transactionForm", transactionForm);

        return "user/payments";
    }

    @RequestMapping("/process")
    public String processTransaction(/*@Valid */@ModelAttribute("transactionForm") TransactionForm transactionForm, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "user/payments";
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Client sender = userService.getUser(user.getUsername()).getClient();
        Client receiver = clientService.getClientByName(transactionForm.getReceiverName());

        Account senderAccount = sender.getAccounts().get(0);
        List<Account> receiverAccounts = receiver.getAccounts();
        Account receiverAccount = null;
        for(Account account : receiverAccounts) {
            if(account.getAccountNumber().equals(transactionForm.getReceiverAccount())) {
                receiverAccount = account;
                break;
            }
        }

        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setSenderAccount(senderAccount);
        transaction.setReceiverAccount(receiverAccount);
        transaction.setAmount(transactionForm.getAmount());
        transaction.setInvoice(transactionForm.getInvoice()+"");
        transaction.setComment(transactionForm.getComment());
        transaction.setSendDateTime(LocalDateTime.now());

        accountService.processTransaction(transaction);

        return "user/payment-processed";
    }

}
