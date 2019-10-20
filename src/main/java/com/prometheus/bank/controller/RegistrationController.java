package com.prometheus.bank.controller;

import com.prometheus.bank.entity.Client;
import com.prometheus.bank.entity.ClientDetails;
import com.prometheus.bank.entity.Role;
import com.prometheus.bank.entity.User;
import com.prometheus.bank.form.RegistrationForm;
import com.prometheus.bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    ClientService clientService;

    @RequestMapping("/show")
    public String showRegistrationForm(Model model) {

        RegistrationForm registrationForm = new RegistrationForm();
        model.addAttribute("registrationForm", registrationForm);

        return "user/registration-form";
    }

    @RequestMapping("/confirm")
    public String confirmRegistration(@Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "user/registration-form";
        }

        Client client = new Client();
        client.setFirstName(registrationForm.getFirstName());
        client.setLastName(registrationForm.getLastName());
        ClientDetails clientDetails = new ClientDetails();
        clientDetails.setFirstName(registrationForm.getFirstName());
        clientDetails.setLastName(registrationForm.getLastName());
        clientDetails.setEmail(registrationForm.getEmail());
        client.setClientDetails(clientDetails);
        clientDetails.setClient(client);
        User user = new User();
        user.setClient(client);
        user.setUsername(registrationForm.getUsername());
        user.setPassword(registrationForm.getPassword());
        Set<Role> userRoles = new HashSet<>();
        Role userRole = new Role("ROLE_USER");
        userRoles.add(userRole);
        user.setRoles(userRoles);
        client.setUserAccount(user);

        clientService.saveClient(client);

        return "user/homepage";
    }

}
