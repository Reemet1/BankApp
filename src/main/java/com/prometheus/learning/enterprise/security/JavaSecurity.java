package com.prometheus.learning.enterprise.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import java.security.*;
import java.util.Arrays;

public class JavaSecurity {

    public void javaSecurity() throws Exception{

        String message = "Message";

        KeyPair keyPairSignature = generateKeyPair("DSA");
        KeyPair keyPairEncryption = generateKeyPair("RSA");

        byte[] encrypted = encrypt(message, keyPairEncryption.getPublic());

        byte[] signature = DigitalSignature.
                createDigitalSignature(encrypted, keyPairSignature.getPrivate());
        boolean verified = DigitalSignature.
                verifyDigitalSignature(encrypted, keyPairSignature.getPublic(), signature);

        System.out.println("Is signature valid: " + verified);

        byte[] decrypted = decrypt(encrypted, keyPairEncryption.getPrivate());
        System.out.println("Encrypted message: " + new String(decrypted));

        /*
        Key key = generateKey();
        byte[] mac = createMACMessage(message, key);
        boolean validMessage = verifyMessage(message, key, mac);
        System.out.println("Is message valid: " + validMessage); */


    }

    public KeyPair generateKeyPair(String algorithm) throws Exception{

        /** Creating KeyPair generator object */
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(algorithm);

        /** Initializing the KeyPairGenerator */
        keyPairGen.initialize(2048);

        /** Generate the pair of keys */
        KeyPair pair = keyPairGen.generateKeyPair();

        return pair;
    }

    public Key generateKey() throws  Exception{
        /** Creating a KeyGenerator object with the given algorithm */
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");

        /** Creating a SecureRandom object, which generates strong random numbers */
        SecureRandom secRandom = new SecureRandom();

        /** Initializing the KeyGenerator with a given string random number */
        keyGen.init(secRandom);


        /** Creating/Generating a key */
        Key key = keyGen.generateKey();

        return key;
    }

    public byte[] encrypt(String message, PublicKey publicKey) throws Exception{

        /** Creating a Cipher object */
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        /** Initializing a Cipher object */
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);


        /** Adding data to the cipher */
        byte[] input = message.getBytes();
        cipher.update(input);

        /** Encrypting the data */
        byte[] cipherText = cipher.doFinal();

        return cipherText;

    }

    public byte[] decrypt(byte[] cipherText, PrivateKey privateKey) throws Exception{
        /** Creating a Cipher object */
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        /** Initializing a Cipher object */
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        /** Decrypting the text */
        byte[] decipheredText = cipher.doFinal(cipherText);

        return decipheredText;
    }

    public byte[] createMACMessage(String message, Key key) throws Exception{

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


}
