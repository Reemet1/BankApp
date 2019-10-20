package com.prometheus.bank.controller;

import com.prometheus.bank.entity.Client;
import com.prometheus.bank.entity.ClientDetails;
import com.prometheus.bank.service.ClientService;
import com.prometheus.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @RequestMapping("/showdetails")
    public String showRegistrationForm(Model model) {

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClientDetails clientDetails = userService.getUser(user.getUsername()).getClient().getClientDetails();

        model.addAttribute("clientDetails", clientDetails);

        return "user/client-details";
    }

    @GetMapping("/showall")
    public String showAllClients(Model model) {

        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);

        return "admin/clients-page";
    }

    @RequestMapping("/update")
    public String updateClientDetails(@Valid @ModelAttribute("clientDetails") ClientDetails clientDetails) {

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Client client = userService.getUser(user.getUsername()).getClient();
        client.setClientDetails(clientDetails);

        clientService.updateClient(client);

        return "redirect:/client/showdetails";
    }

    @RequestMapping("/clientInfo/{id}")
    public String showClientInfo(Model model, @PathVariable(name = "id") long id) {

        Client client = clientService.getClient(id);
        model.addAttribute("client", client);

        return "/admin/client-info";
    }

}
