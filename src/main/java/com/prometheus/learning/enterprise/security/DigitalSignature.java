package com.prometheus.learning.enterprise.security;

import java.security.*;

public class DigitalSignature {

    public void createAndVerifySignature() throws Exception{

        String message = "Hi, how are you?";

        /** Creating KeyPair generator object */
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");

        /** Initializing the KeyPairGenerator */
        keyPairGen.initialize(2048);

        /** Generate the pair of keys */
        KeyPair pair = keyPairGen.generateKeyPair();

        /** Getting the private key from the key pair */
        PrivateKey privKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        byte[] signature = createDigitalSignature(message.getBytes(), privKey);

        verifyDigitalSignature(message.getBytes(), publicKey, signature);

    }

    public static byte[] createDigitalSignature(byte[] message, PrivateKey privKey) throws Exception{

        /** Creating a Signature object */
        Signature sign = Signature.getInstance("SHA256withDSA");

        /** Initialize the signature */
        sign.initSign(privKey);

        byte[] bytes = message;

        /** Adding data to the signature */
        sign.update(bytes);

        /** Calculating the signature */
        byte[] signature = sign.sign();

        /** Printing the signature */
        System.out.println("Digital signature for given text: "+new String(signature, "UTF8"));

        return signature;
    }

    public static boolean verifyDigitalSignature(byte[] messageToverify, PublicKey publicKey, byte[] signature) throws Exception{

        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withDSA");

        sign.initVerify(publicKey);
        sign.update(messageToverify);

        //Verifying the signature
        boolean isValid = sign.verify(signature);
        return isValid;
        //System.out.println("Signature valid: " + bool);
    }

}
