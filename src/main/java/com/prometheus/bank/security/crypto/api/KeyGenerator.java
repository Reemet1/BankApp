package com.prometheus.bank.security.crypto.api;

import java.security.*;

public class KeyGenerator {

    public KeyPair generateKeyPair(Algorithms.KeyPairGenerator algorithm) throws Exception{

        /** Creating KeyPair generator object */
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(algorithm.toString());

        /** Initializing the KeyPairGenerator */
        keyPairGen.initialize(2048);

        /** Generate the pair of keys */
        KeyPair pair = keyPairGen.generateKeyPair();

        /** Getting the private key from the key pair */
        PrivateKey privKey = pair.getPrivate();

        /** Getting the public key from the key pair */
        PublicKey publicKey = pair.getPublic();

        System.out.println("Keys generated");
        /*System.out.println("Public key: " + publicKey.toString());
        System.out.println("Private key: " + privKey.toString()); */

        return pair;
    }

    public Key generateKey(Algorithms.KeyGenerator algorithm) throws  Exception{
        /** Creating a KeyGenerator object with the given algorithm */
        javax.crypto.KeyGenerator keyGen = javax.crypto.KeyGenerator.getInstance(algorithm.toString());

        /** Creating a SecureRandom object, which generates strong random numbers */
        SecureRandom secRandom = new SecureRandom();

        /** Initializing the KeyGenerator with a given string random number */
        keyGen.init(secRandom);


        /** Creating/Generating a key */
        Key key = keyGen.generateKey();

        return key;
    }

}
