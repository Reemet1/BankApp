package com.prometheus.bank.rest.controller;

import com.prometheus.bank.form.LoginForm;
import com.prometheus.bank.form.RegistrationForm;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Random;


@RestController
@RequestMapping("/api")
public class AuthRestController {


    @PostMapping("/register")
    public RegistrationForm register(@RequestBody RegistrationForm registrationForm, @RequestHeader Map<String, String> headers) {

        return registrationForm;
    }

    @PostMapping("/login")
    public LoginForm login(@RequestBody LoginForm loginForm, HttpSession httpSession, HttpServletResponse response) {
        response.setHeader("SessionID", httpSession.getId());
        return loginForm;
    }

    @PostMapping("/logout")
    public String logout() {
        return "";
    }

}
