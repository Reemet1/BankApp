package com.prometheus.crypto.impl;

import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {


    public BigInteger[] generateKeyPair() {

        PrimeGenerator primeGenerator = new PrimeGenerator();

        BigInteger[] keyPair = new BigInteger[3];

        BigInteger prime1 = primeGenerator.generatePrime(1024);
        BigInteger prime2 = primeGenerator.generatePrime(1024);

        BigInteger module = prime1.mod(prime2);

        BigInteger phiN = prime1.subtract(BigInteger.ONE).multiply(prime2.subtract(BigInteger.ONE));

        Random random = new Random();
        BigInteger publicExp = new BigInteger(phiN.bitCount()-1,random);
        while(!MathUtils.gcd(publicExp, phiN).equals(BigInteger.ONE)) {
            publicExp = new BigInteger(phiN.bitCount()-1,random);
        }

        BigInteger secretExp = new BigInteger(phiN.bitCount()-1,random);
        while(!secretExp.multiply(publicExp).mod(phiN).equals(BigInteger.ONE)) {
            secretExp = new BigInteger(phiN.bitCount()-1,random);
        }

        keyPair[0] = module;
        keyPair[1] = publicExp;
        keyPair[2] = secretExp;

        return keyPair;
    }

}
