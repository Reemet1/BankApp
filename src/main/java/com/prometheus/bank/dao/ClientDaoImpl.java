package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Client;
import com.prometheus.bank.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<Client> implements ClientDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Client getClient(long id) {
        return get(id);
    }

    @Override
    public Client getClientByName(String name) {
        String[] firstLastName = name.split(" ");
        String firstName = firstLastName[0];
        String lastName = firstLastName[1];

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Client WHERE firstName='"+firstName+"' and lastName='"+lastName+"'", Client.class);
        Client client = (Client) query.getSingleResult();

        return client;
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
