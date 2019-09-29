package com.prometheus.bank.security.crypto.api;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.util.Arrays;

public class JavaSecurity {

    public void javaSecurity() throws Exception{




        /*
        Key key = generateKey();
        byte[] mac = createMACMessage(message, key);
        boolean validMessage = verifyMessage(message, key, mac);
        System.out.println("Is message valid: " + validMessage); */


    }



    public byte[] createMACMessage(String message, Key key) throws Exception{

        /** Creating a Mac object */
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);

        byte[] bytes = message.getBytes();

        /** Combining message with a generated key and returns the checksum */
        byte[] macResult = mac.doFinal(bytes);

        return macResult;

    }

    public boolean verifyMessage(String message, Key key, byte[] macMessage) throws Exception{

        /** Creating a Mac object */
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);

        byte[] bytes = message.getBytes();
        byte[] macResult = mac.doFinal(bytes);

        return Arrays.equals(macResult, macMessage);
    }


    /**
     * A hash function is a mathematical function that converts a numerical input value into another
     * compressed numerical value. The input to the hash function is of arbitrary length but output is
     * always of fixed length. Values returned by a hash function are called message digest or simply hash values.
     */
    public String digestMessage(String message) throws Exception{

        MessageDigest messageDigest = MessageDigest.getInstance(Algorithms.Hash.SHA256.toString());

        //messageDigest.update(message.getBytes());

        byte[] digest = messageDigest.digest(message.getBytes());

        return this.getHexString(digest);
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

    public String getHexString(byte[] bytes) {
        /** Converting the byte array in to HexString format */
        StringBuffer hexString = new StringBuffer();

        for (int i = 0;i<bytes.length;i++) {
            hexString.append(Integer.toHexString(0xFF & bytes[i]));
        }
        return hexString.toString();
    }


}
