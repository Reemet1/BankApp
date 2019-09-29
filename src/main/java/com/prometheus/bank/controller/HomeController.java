package com.prometheus.bank.controller;

import com.prometheus.bank.entity.Account;
import com.prometheus.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    private HttpServletRequest context;

    @RequestMapping("/")
    public String printHello(Model model, HttpServletResponse response) {

        model.addAttribute("message", "Study Information System");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user=null;
        if (principal instanceof User) {
            user = ((User)principal);
        }
        model.addAttribute("user",user);
        //response.addCookie(new Cookie("username",user.getUsername()));

        List<Account> accounts = userService.getUser(user.getUsername()).getClient().getAccounts();
        model.addAttribute("accounts", accounts);

        return "user/homepage";
    }

    @RequestMapping("/adminhome")
    public String adminHome() {
        return "admin/admin-homepage";
    }


}
