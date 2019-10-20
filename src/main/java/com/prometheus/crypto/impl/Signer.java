package com.prometheus.crypto.impl;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;

public class Signer {

    private static final int reductionPolynomial = 0b100011011;

    public void sign(String message, KeyPair keyPair)  throws Exception {

        modInverse(2,3);

        KeyFactory keyFactory = KeyFactory.getInstance("DSA");

        DSAPrivateKeySpec privKeySpec = keyFactory.getKeySpec(keyPair.getPrivate(), DSAPrivateKeySpec.class);
        DSAPublicKeySpec pubKeySpec = keyFactory.getKeySpec(keyPair.getPublic(), DSAPublicKeySpec.class);

        int[] LNPair1 = {1024,160};
        int[] LNPair2 = {2048,224};
        int[] LNPair3 = {2048,256};
        int[] LNPair4 = {3072,256};


        int L = LNPair1[0];
        int N = LNPair1[1];

        //prime divisor of (p-1), where 2^{N-1} < q < 2^N, and N is the bit length of q.
        BigInteger q = privKeySpec.getQ();

        //prime modulus, where 2^{L-1} < p < 2^L is the bit length of p
        BigInteger p = privKeySpec.getP();

        //generator of a subgroup of order q in the multiplicative group of GF(p), such that 1 < g < p
        BigInteger g = privKeySpec.getG();

        //private key that must remain secret, x is a randomly or pseudorandomly generated integer,
        //such that 0 < x < q
        BigInteger x = new BigInteger(keyPair.getPrivate().getEncoded());

        //public key, where y = g^x mod p
        BigInteger y = new BigInteger(keyPair.getPublic().getEncoded());

        //secret number that is unique to each message. K is randomly or pseudorandomly generated integer,
        //such that 0 < k < q
        BigInteger k = BigInteger.TEN;

        //Domain parameters are p,q and g

        MessageDigest md = MessageDigest.getInstance("SHA-256");


        BigInteger r = (g.pow(k.intValue()).mod(q)).mod(q);
        BigInteger s = (k.modInverse(q).multiply(x.multiply(r).add(new BigInteger(md.digest(message.getBytes()))))).mod(q);

        //Verify

        BigInteger w = s.modInverse(q);
        BigInteger u1 = new BigInteger(md.digest(message.getBytes())).multiply(w).mod(q);
        BigInteger u2 = r.mod(w).mod(q);
        BigInteger v = (pow(g,u1).multiply(pow(g,u2)).mod(p)).mod(q);

        System.out.println();

    }

    BigInteger inverse(BigInteger x, BigInteger mod) {

        BigInteger bigInt = BigInteger.valueOf(1);

        BigInteger inverse = x.pow(mod.intValue());

        while(bigInt.multiply(x).mod(mod).equals(BigInteger.ONE) == false) {
            bigInt = bigInt.add(BigInteger.ONE);
        }

        return bigInt;
    }

    BigInteger pow(BigInteger base, BigInteger exponent) {
        BigInteger result = BigInteger.ONE;
        while (exponent.signum() > 0) {
            if (exponent.testBit(0)) result = result.multiply(base);
            base = base.multiply(base);
            exponent = exponent.shiftRight(1);
        }
        return result;
    }

    static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }

}
