package com.prometheus.learning.enterprise.security;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;

public class KeyStoreExample {


    public void keyStore() throws Exception{
        String secretKeyAlias = "secretKeyAlias";
        //storeKey(secretKeyAlias);
        retrieveKey(secretKeyAlias);

    }

    public void storeKey(String secretKeyAlias) throws Exception{
/** Creating the KeyStore object */
        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        //Loading the KeyStore object
        char[] password = "changeit".toCharArray();
        String path = "C:\\Program Files\\Java\\jdk-12\\lib\\security\\cacerts";
        FileInputStream fis = new FileInputStream(path);
        keyStore.load(fis, password);

        /** Creating the KeyStore.ProtectionParameter object */
        KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

        /** Creating SecretKey object */
        SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");

        /** Creating SecretKeyEntry object */
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);

        /** Set the entry to the keystore */
        keyStore.setEntry(secretKeyAlias, secretKeyEntry, protectionParam);

        /** Storing the KeyStore object */
        //FileOutputStream fos = null;
        //fos = new java.io.FileOutputStream("newKeyStoreName");
        //keyStore.store(fos, password);
        //System.out.println("data stored");

        //Creating the KeyStore.SecretKeyEntry object
        KeyStore.SecretKeyEntry secretKeyEnt = (KeyStore.SecretKeyEntry) keyStore.getEntry(secretKeyAlias, protectionParam);

        SecretKey mySecretKey1 = secretKeyEnt.getSecretKey();
        System.out.println("Algorithm used to generate key : "+mySecretKey1.getAlgorithm());
        System.out.println("Format used for the key: "+mySecretKey1.getFormat());

    }

    public void retrieveKey(String secretKeyAlias) throws Exception{
        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        //Loading the KeyStore object
        char[] password = "changeit".toCharArray();
        String path = "C:\\Program Files\\Java\\jdk-12\\lib\\security\\cacerts";
        FileInputStream fis = new FileInputStream(path);
        keyStore.load(fis, password);

        /** Creating the KeyStore.ProtectionParameter object */
        KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

        //Creating the KeyStore.SecretKeyEntry object
        //KeyStore.SecretKeyEntry secretKeyEnt = (KeyStore.SecretKeyEntry) keyStore.getEntry(secretKeyAlias, protectionParam);

        //Retrieve SecretKey object
        //SecretKey mySecretKey = secretKeyEnt.getSecretKey();
        Key key = keyStore.getKey(secretKeyAlias, "myPassword".toCharArray());
        System.out.println("Algorithm used to generate key : "+key.getAlgorithm());
        System.out.println("Format used for the key: "+key.getFormat());


    }



}
