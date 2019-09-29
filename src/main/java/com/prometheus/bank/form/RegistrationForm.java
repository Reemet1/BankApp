package com.prometheus.bank.form;

import com.prometheus.bank.form.validator.constraint.EmailConstraint;
import com.prometheus.bank.form.validator.constraint.NameConstraint;
import com.prometheus.bank.form.validator.constraint.PasswordConstraint;
import com.prometheus.bank.form.validator.constraint.UsernameConstraint;

public class RegistrationForm {

    @NameConstraint
    private String firstName;
    @NameConstraint
    private String lastName;
    @EmailConstraint
    private String email;
    @UsernameConstraint
    private String username;
    @PasswordConstraint
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
