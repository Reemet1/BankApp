package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Client;

import java.util.List;

public interface ClientDAO extends IGenericDAO<Client> {

    Client getClient(long id);

    Client getClientByName(String name);

    List<Client> getAllClients();

    void saveClient(Client client);

    void updateClient(Client client);

    void deleteClient(long id);



}
