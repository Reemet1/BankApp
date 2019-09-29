package com.prometheus.bank.security.crypto.api;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Person {

    private String firstName;
    private String lastName;

    private KeyPair keyPair;
    private KeyPair dhKeyPair;

    private PublicKey otherDHPublicKey;

    private SecretKey sharedSecret;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void sendMessage(Person person, String message) {
        person.getMessage(message);
    }

    public String getMessage(String message) {
        return message;
    }

    public void sendDHPublicKey(Person otherPerson) {
        otherPerson.receiveDHPublicKey(dhKeyPair.getPublic());
    }

    public void receiveDHPublicKey(PublicKey otherDHPublicKey) {
        this.otherDHPublicKey = otherDHPublicKey;
    }

    public void generateKeyPair() {
        try {
            KeyGenerator keyGenerator = new KeyGenerator();
            KeyPair keyPair = keyGenerator.generateKeyPair(Algorithms.KeyPairGenerator.RSA);
            this.keyPair = keyPair;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateDHKeyPair() {
        try {
            KeyGenerator keyGenerator = new KeyGenerator();
            KeyPair dhKeyPair = keyGenerator.generateKeyPair(Algorithms.KeyPairGenerator.DiffieHellman);
            this.dhKeyPair = dhKeyPair;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateSharedSecret(PublicKey otherDHPublicKey) {
        SecretKey resizedSharedSecret = null;
        try {

            SecretKey sharedSecret = KeyExchange.generateSharedSecret(otherDHPublicKey, dhKeyPair.getPrivate());
            MessageDigest md = MessageDigest.getInstance(Algorithms.MessageDigest.SHA256.toString());
            byte[] bytes = md.digest(sharedSecret.getEncoded());
            resizedSharedSecret = new SecretKeySpec(bytes, 0, bytes.length, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        this.sharedSecret = resizedSharedSecret;
    }

    public PublicKey getOtherDHPublicKey() {
        return otherDHPublicKey;
    }

    public SecretKey getSharedSecret() {
        return sharedSecret;
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }


    public KeyPair getDhKeyPair() {
        return dhKeyPair;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
