package com.prometheus.bank.controller;

import com.prometheus.bank.entity.Role;
import com.prometheus.bank.entity.User;
import com.prometheus.bank.form.LoginForm;
import com.prometheus.bank.logger.Logger;
import com.prometheus.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    private HttpServletRequest context;

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/login")
    public String showLogin(Model model) {

        Logger.logger.info("Opening Login page");

        LoginForm loginForm = new LoginForm();
        model.addAttribute("loginForm",loginForm);

        return "user/login-form";
    }



    @RequestMapping("/authenticate")
    public String authenticate(@ModelAttribute("loginForm") LoginForm loginForm, @ModelAttribute("user") User user1,  Model model, HttpServletResponse response) {

        User user = userService.getUser(loginForm.getUsername());

        model.addAttribute("user",loginForm.getUsername());
        response.addCookie(new Cookie("username",user.getUsername()));


        /*if(loginForm.getPassword().equals(user.getPassword())) {
            System.out.println("Password correct");
            response.addCookie(new Cookie("username",user.getUsername()));
            return "redirect:/";
        } else return "login-form"; */
        if(user.getRoles().contains(new Role("ROLE_ADMIN"))) {
            return "redirect:/adminhome";
        } else return "redirect:/adminhome";
    }


}
