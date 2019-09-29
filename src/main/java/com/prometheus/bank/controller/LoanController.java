package com.prometheus.bank.controller;


import com.prometheus.bank.entity.Client;
import com.prometheus.bank.entity.Document;
import com.prometheus.bank.entity.Loan;
import com.prometheus.bank.form.RegistrationForm;
import com.prometheus.bank.service.ClientService;
import com.prometheus.bank.service.LoanService;
import com.prometheus.bank.service.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/show")
    public String showLoans(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long clientId = userService.getUser(user.getUsername()).getId();
        Loan loan = new Loan();
        List<Loan> loans = loanService.getLoansForClient(clientId);

        model.addAttribute("loans", loans);
        model.addAttribute("loan", loan);

        return "/user/loans";
    }

    @RequestMapping("/take")
    public String takeLoan(@ModelAttribute("loan") Loan loan) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Client client = userService.getUser(user.getUsername()).getClient();

        Document document = new Document();
        document.setClient(client);

        loan.setContract(document);
        loan.setClient(client);
        double interestRate = 0.04;
        double totalInterest = loan.getTotalPaybackTime()*interestRate;
        double totalPaybackAmount = loan.getLoanAmount()+loan.getLoanAmount()*totalInterest;
        double monthlyPay = totalPaybackAmount/loan.getTotalPaybackTime();

        loan.setInterestRate(interestRate);
        loan.setPaybackAmount(totalPaybackAmount);
        loan.setMonthlyPaymentAmount(monthlyPay);

        loanService.addLoan(loan);

        return "redirect:/loans/show";
    }

}
