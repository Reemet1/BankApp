package com.prometheus.learning.enterprise.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.*;

public class KeyGeneratorExample {

    /** Generating private keys */
    public void generateKey() throws Exception{

        /** Creating a KeyGenerator object */
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");

        /** Creating a SecureRandom object */
        SecureRandom secRandom = new SecureRandom();

        /** Initializing the KeyGenerator */
        keyGen.init(secRandom);

        //Creating/Generating a key
        Key key = keyGen.generateKey();

        System.out.println(key);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(cipher.ENCRYPT_MODE, key);

        String msg = new String("Hi how are you");
        byte[] bytes = cipher.doFinal(msg.getBytes());
        System.out.println(bytes);

    }

    /** Generate pairs of public and private keys */
    public void keyPairGenerator() throws Exception{

        /** Creating KeyPair generator object */
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");

        /** Initializing the KeyPairGenerator */
        keyPairGen.initialize(2048);

        /** Generate the pair of keys */
        KeyPair pair = keyPairGen.generateKeyPair();

        /** Getting the private key from the key pair */
        PrivateKey privKey = pair.getPrivate();

        /** Getting the public key from the key pair */
        PublicKey publicKey = pair.getPublic();

        System.out.println("Keys generated");

    }

}
