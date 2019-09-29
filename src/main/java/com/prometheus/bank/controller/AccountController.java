package com.prometheus.bank.controller;

import com.prometheus.bank.entity.Account;
import com.prometheus.bank.entity.Limit;
import com.prometheus.bank.entity.Loan;
import com.prometheus.bank.form.AccountForm;
import com.prometheus.bank.service.AccountService;
import com.prometheus.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;


    @GetMapping("/show")
    public String showAccounts(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user=null;
        if (principal instanceof User) {
            user = ((User)principal);
        }
        model.addAttribute("user",user);
        //response.addCookie(new Cookie("username",user.getUsername()));

        List<Account> accounts = userService.getUser(user.getUsername()).getClient().getAccounts();
        model.addAttribute("accounts", accounts);

        return "user/accounts";
    }

    @GetMapping("/show/{id}")
    public String showAccount(Model model, @PathVariable(name = "id") long accountId) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user=null;
        if (principal instanceof User) {
            user = ((User)principal);
        }

        Account account = accountService.getAccount(accountId);
        model.addAttribute("account", account);

        Collection<GrantedAuthority> roles = user.getAuthorities();
        for(GrantedAuthority role : roles) {
            if(role.getAuthority().equals("ROLE_ADMIN")) {
                return "admin/account-page";
            }
        }
        return "user/account-page";
    }

    @GetMapping("/showAddAccount")
    public String showAddAccount(Model model) {

        AccountForm accountForm = new AccountForm();
        model.addAttribute("accountForm", accountForm);

        return "user/add-account-form";
    }

    @GetMapping("/showLimits/{id}")
    public String showAccountLimits(Model model, @PathVariable(name = "id") long accountId) {

        Limit limits = accountService.getAccount(accountId).getAccountLimits();
        model.addAttribute("limits", limits);

        return "user/account-limits";
    }

    @PostMapping("/updateLimits")
    public String updateAccountLimits(@ModelAttribute("limits") Limit limits) {

        Account account = limits.getAccount();
        account.setAccountLimits(limits);

        accountService.updateAccount(account);

        return "redirect:/accounts/show";
    }

    @PostMapping("/addAccount")
    public String addAccount(/*@Valid */@ModelAttribute("accountForm") AccountForm accountForm, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "user/add-account-form";
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Account account = new Account();
        account.setAccountNumber(accountForm.getAccountNumber());
        account.setBalance(accountForm.getStartingBalance());
        Limit limit = new Limit();
        limit.setType("account_limit");
        limit.setTrasnactionLimit(100);
        limit.setDailyLimit(200);
        limit.setMonthlyLimit(500);
        limit.setAccount(account);

        com.prometheus.bank.entity.User bankUser = userService.getUser(user.getUsername());
        account.setOwner(bankUser.getClient());
        account.setAccountLimits(limit);

        accountService.saveAccount(account);

        return "redirect:/accounts/show";
    }

}
