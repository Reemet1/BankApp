package com.prometheus.bank.rest.controller;

import com.prometheus.bank.entity.Client;
import com.prometheus.bank.entity.ClientDetails;
import com.prometheus.bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientRestController {

    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getClients() {

        List<Client> clients = clientService.getAllClients();

        return clients;
    }

    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable(value = "id") long clientId) {

        Client client = clientService.getClient(clientId);

        return client;
    }

    @GetMapping("/clientDetails/{clientId}")
    public ClientDetails getClientDetails(@PathVariable(value = "clientId") long clientId) {

        ClientDetails clientDetails = clientService.getClient(clientId).getClientDetails();

        return clientDetails;
    }

    @Autowired
    public void setService(ClientService clientService) {
        this.clientService = clientService;
    }
}
