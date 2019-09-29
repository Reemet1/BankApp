package com.prometheus.bank.service;

import com.prometheus.bank.dao.ClientDAO;
import com.prometheus.bank.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl extends AbstractService<Client> implements ClientService {


    @Autowired
    private ClientDAO clientDAO;

    @Override
    public Client getClient(long id) {
        return get(id);
    }

    @Override
    public Client getClientByName(String name) {
        return clientDAO.getClientByName(name);
    }

    @Override
    public List<Client> getAllClients() {
        return getAll();
    }

    @Override
    public void saveClient(Client client) {
        save(client);
    }

    @Override
    public void updateClient(Client client) {
        update(client);
    }

    @Override
    public void deleteClient(long id) {
        delete(id);
    }


}
