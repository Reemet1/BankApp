package com.prometheus.bank.dao;

import com.prometheus.bank.entity.ClientDetails;

import java.util.List;

public interface ClientDetailsDAO extends IGenericDAO<ClientDetails> {

    ClientDetails getClientDetails(long id);

    List<ClientDetails> getAllClientDetails();

    void saveClientDetails(ClientDetails clientDetails);

    void updateClientDetails(ClientDetails clientDetails);

    void deleteClientDetails(long id);

}
