package com.prometheus.learning.enterprise.security;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class EncryptDecrypt {

    public void encryptDecrypt() throws Exception{

        String message = "Hi, how are you?";

        /** Creating KeyPair generator object */
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        /** Initializing the KeyPairGenerator */
        keyPairGen.initialize(2048);

        /** Generate the pair of keys */
        KeyPair pair = keyPairGen.generateKeyPair();

        /** Getting the public key from the key pair */
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();

        byte[] cipherText = encrypt(message, publicKey);

        String originalMessage = decrypt(cipherText, privateKey);

        System.out.println(originalMessage);

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

    public String decrypt(byte[] cipherText, PrivateKey privateKey) throws Exception{
        /** Creating a Cipher object */
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        /** Initializing a Cipher object */
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        /** Decrypting the text */
        byte[] decipheredText = cipher.doFinal(cipherText);

        return new String(decipheredText);
    }
}
