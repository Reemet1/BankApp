package com.prometheus.bank.service;

import com.prometheus.bank.entity.Client;

import java.util.List;

public interface ClientService extends IService<Client>{

    Client getClient(long id);

    Client getClientByName(String name);

    List<Client> getAllClients();

    void saveClient(Client client);

    void updateClient(Client client);

    void deleteClient(long id);

}
