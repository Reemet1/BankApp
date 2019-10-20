package com.prometheus.crypto.api;

import javax.crypto.spec.DHParameterSpec;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;

public class KeyGenerator {


    public KeyPair generateKeyPair(String algorithm, int keySize) throws Exception {

        SecureRandom secureRandom = new SecureRandom();

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);

        AlgorithmParameterSpec paramSpec = getParamSpec(algorithm, keySize);

        //keyPairGenerator.initialize(paramSpec);
        keyPairGenerator.initialize(1024);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        return keyPair;
    }

    public AlgorithmParameterSpec getParamSpec(String algorithm, int keySize) {
        SecureRandom secureRandom = new SecureRandom();

        AlgorithmParameterSpec algorithmParameterSpec = null;

        switch (algorithm) {
            case "RSA": {
                BigInteger publicExponent = BigInteger.probablePrime(128, secureRandom);
                algorithmParameterSpec = new RSAKeyGenParameterSpec(keySize, publicExponent);
                break;
            }
            case "DSA": {
                BigInteger p = BigInteger.probablePrime(1024, secureRandom); //prime modulus
                BigInteger q = BigInteger.probablePrime(160, secureRandom); //sub prime
                BigInteger g = BigInteger.probablePrime(keySize, secureRandom); //base generator
                algorithmParameterSpec = new DSAParameterSpec(p,q,g);
                break;
            }
            case "DH": {
                BigInteger p = BigInteger.probablePrime(512, secureRandom); //prime modulus
                BigInteger g = BigInteger.probablePrime(512, secureRandom); //base generator
                algorithmParameterSpec = new DHParameterSpec(p,g);
            }
        }

        return algorithmParameterSpec;
    }



}

