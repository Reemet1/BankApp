package com.prometheus.bank.dao;

import com.prometheus.bank.entity.ClientDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDetailsDaoImpl extends GenericDaoImpl<ClientDetails> implements ClientDetailsDAO {

    @Override
    public ClientDetails getClientDetails(long id) {
        return get(id);
    }

    @Override
    public List<ClientDetails> getAllClientDetails() {
        return getAll();
    }

    @Override
    public void saveClientDetails(ClientDetails clientDetails) {
        save(clientDetails);
    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) {
        update(clientDetails);
    }

    @Override
    public void deleteClientDetails(long id) {
        delete(id);
    }
}
