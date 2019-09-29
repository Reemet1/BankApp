package com.prometheus.bank.form;

import com.prometheus.bank.form.validator.constraint.PasswordConstraint;
import com.prometheus.bank.form.validator.constraint.UsernameConstraint;

public class LoginForm {

    @UsernameConstraint
    private String username;

    @PasswordConstraint
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
