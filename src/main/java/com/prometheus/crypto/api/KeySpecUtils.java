package com.prometheus.crypto.api;

import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;

public class KeySpecUtils {

    public KeySpec getKeySpec(Key key) {

        KeyFactory keyFactory = null;
        KeySpec keySpec = null;

        try {
            if(key.getAlgorithm().equals("RSA")) {
                keyFactory = KeyFactory.getInstance("RSA");
                if(key instanceof PublicKey) {
                    keySpec = keyFactory.getKeySpec(key, RSAPublicKeySpec.class);
                } else if(key instanceof PrivateKey) {
                    keySpec = keyFactory.getKeySpec(key, RSAPrivateKeySpec.class);
                } else {

                }

            } else if(key.getAlgorithm().equals("DSA")) {
                keyFactory = KeyFactory.getInstance("DSA");
                if(key instanceof PublicKey) {
                    keySpec = keyFactory.getKeySpec(key, DSAPublicKeySpec.class);
                } else if(key instanceof PrivateKey) {
                    keySpec = keyFactory.getKeySpec(key, DSAPrivateKeySpec.class);
                } else {

                }
            } else {
                keyFactory = KeyFactory.getInstance("DH");
                if(key instanceof PublicKey) {
                    keySpec = keyFactory.getKeySpec(key, DHPublicKeySpec.class);
                } else if(key instanceof PrivateKey) {
                    keyFactory.getKeySpec(key, DHPrivateKeySpec.class);
                } else {

                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }


        return keySpec;
    }


    public void printSpec(KeySpec keySpec) {

        if(keySpec.getClass().equals(RSAPublicKeySpec.class)) {

            RSAPublicKeySpec rsaPublicKeySpec = (RSAPublicKeySpec)keySpec;
            BigInteger modulus = rsaPublicKeySpec.getModulus();
            BigInteger publicExp = rsaPublicKeySpec.getPublicExponent();
            System.out.println("#################### RSA PUBLIC KEY ##################");
            System.out.println("Modulus: " + modulus);
            System.out.println("Public exponent:" + publicExp);
            System.out.println("######################################################");

        } else if(keySpec.getClass().equals(RSAPrivateKeySpec.class)) {

            RSAPrivateKeySpec rsaPrivateKeySpec = (RSAPrivateKeySpec)keySpec;
            BigInteger modulus = rsaPrivateKeySpec.getModulus();
            BigInteger privateExp = rsaPrivateKeySpec.getPrivateExponent();
            System.out.println("#################### RSA PRIVATE KEY ##################");
            System.out.println("Modulus: " + modulus);
            System.out.println("Private exponent: " + privateExp);
            System.out.println("#######################################################");

        } else if(keySpec.getClass().equals(DSAPublicKeySpec.class)) {

            DSAPublicKeySpec dsaPublicKeySpec = (DSAPublicKeySpec) keySpec;
            BigInteger g = dsaPublicKeySpec.getG();
            BigInteger p = dsaPublicKeySpec.getP();
            BigInteger q = dsaPublicKeySpec.getQ();
            BigInteger y = dsaPublicKeySpec.getY();
            System.out.println("################ DSA PUBLIC KEY #################");
            System.out.println("G: " + g);
            System.out.println("P: " + p);
            System.out.println("Q: " + q);
            System.out.println("Y: " + y);
            System.out.println("##################################################");

        } else if(keySpec.getClass().equals(DSAPrivateKeySpec.class)) {

            DSAPrivateKeySpec dsaPrivateKeySpec = (DSAPrivateKeySpec)keySpec;
            BigInteger g = dsaPrivateKeySpec.getG();
            BigInteger p = dsaPrivateKeySpec.getP();
            BigInteger q = dsaPrivateKeySpec.getQ();
            BigInteger x = dsaPrivateKeySpec.getX();
            System.out.println("################ DSA PRIVATE KEY #################");
            System.out.println("G: " + g);
            System.out.println("P: " + p);
            System.out.println("Q: " + q);
            System.out.println("X: " + x);
            System.out.println("##################################################");

        } else if(keySpec.getClass().equals(DHPublicKeySpec.class)) {

            DHPublicKeySpec dhPublicKeySpec = (DHPublicKeySpec)keySpec;
            BigInteger g = dhPublicKeySpec.getG();
            BigInteger p = dhPublicKeySpec.getP();
            BigInteger y = dhPublicKeySpec.getY();
            System.out.println("################ DH PUBLIC KEY ##################");
            System.out.println("G: " + g);
            System.out.println("P: " + p);
            System.out.println("Y: " + y);
            System.out.println("##################################################");


        } else if(keySpec.getClass().equals(DHPrivateKeySpec.class)) {

            DHPrivateKeySpec dhPrivateKeySpec = (DHPrivateKeySpec)keySpec;
            BigInteger g = dhPrivateKeySpec.getG();
            BigInteger p = dhPrivateKeySpec.getP();
            BigInteger x = dhPrivateKeySpec.getX();
            System.out.println("################ DH PRIVATE KEY ##################");
            System.out.println("G: " + g);
            System.out.println("P: " + p);
            System.out.println("X: " + x);
            System.out.println("##################################################");
        }







    }

}
