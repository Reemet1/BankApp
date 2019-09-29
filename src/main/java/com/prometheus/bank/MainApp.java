package com.prometheus.bank;

import com.prometheus.bank.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    static SessionFactory factory;

    public static void main(String[] args) {

        MainApp mainApp = new MainApp();

        try {

            factory = new Configuration()
                    .configure("hibernate.cfg.xml") //.configure() - Default is hibernate.cfg.xml
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(ClientDetails.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(EmployeeDetails.class)
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Card.class)
                    .addAnnotatedClass(Transaction.class)
                    .buildSessionFactory();

            Client client = new Client();
            client.setFirstName("Reemet");
            client.setLastName("Ammer");
            Account account = new Account();
            Card card = new Card();
            card.setAccount(account);
            card.setHolder(client);
            List<Card> cards = new ArrayList<>();
            cards.add(card);
            Transaction transaction = new Transaction();
            transaction.setReceiver(client);
            transaction.setSender(client);
            transaction.setReceiverAccount(account);
            transaction.setSenderAccount(account);
            List<Transaction> transactions = new ArrayList<>();
            transactions.add(transaction);
            account.setTransactionsIn(transactions);
            account.setTransactionsOut(transactions);
            client.setBankCards(cards);
            account.setCard(cards);
            ClientDetails clientDetails = new ClientDetails();
            clientDetails.setClient(client);
            List<Account> accounts = new ArrayList<>();
            accounts.add(account);
            account.setOwner(client);
            client.setAccounts(accounts);
            client.setClientDetails(clientDetails);


            Session session = null;

            try {
                session = factory.getCurrentSession();
                session.beginTransaction();
                session.save(client);
                session.getTransaction().commit();
            } finally {
                if(session != null) {
                    session.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSessionFactory();
        }


    }

    private static void openSessionFactory() {

        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

    }

    private static void closeSessionFactory() {
        if(factory != null) {
            factory.close();
        }
    }

}
