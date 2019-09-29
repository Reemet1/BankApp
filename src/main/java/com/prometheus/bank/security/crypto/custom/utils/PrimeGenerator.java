package com.prometheus.bank.security.crypto.custom.utils;

import java.math.BigInteger;
import java.util.Random;

public class PrimeGenerator {

    public BigInteger generatePrime(int bits) {

        return generatePrime(bits, 0.99999);
    }


    public BigInteger generatePrime(int bits, double probability) {

        BigInteger bigInt;
        do {
            bigInt = getRandomInt(bits);
        } while (!isPrime(bigInt, probability));

        return bigInt;
    }

    private BigInteger getRandomInt(int bits) {

        BigInteger randomInt = new BigInteger(bits, new Random());

        return randomInt;
    }

    private boolean isPrime(BigInteger bigInt, double probability) {

        if(bigInt.compareTo(BigInteger.valueOf(2)) < 1 || bigInt.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
            return false;
        }


        int i = 1;
        while(Math.pow(0.25, i) > 1-probability) {
            i++;
        }

        boolean isPrime = true;

        BigInteger random;
        for(int j = 0; j < i; j++) {
            random = getRandomInt(bigInt.bitCount());
            if(!random.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) &&
                    isMillerRabinWitness(getRandomInt(bigInt.bitCount()), bigInt)) {
                return false;
            }
        }

        return isPrime;
    }

    private boolean isMillerRabinWitness(BigInteger bigInt, BigInteger mod) {

        BigInteger nMinusOne = mod.subtract(BigInteger.ONE);
        BigInteger ti = getTi(nMinusOne, 2);
        int pow = getPow(nMinusOne, 2);

        boolean isWitness = true;

        if(!bigInt.modPow(ti, mod).equals(BigInteger.ONE)) {

            for(int i = 0; i < pow; i++) {
                if(bigInt.modPow(BigInteger.valueOf(2).pow(i).multiply(ti), mod).equals(mod.subtract(BigInteger.ONE))) {
                    return false;
                }
            }

        } else isWitness = false;

        return isWitness;
    }

    private int getPow(BigInteger bigInteger, int base) {

        int pow = 0;
        while (bigInteger.mod(BigInteger.valueOf(base)).equals(BigInteger.ZERO)) {
            bigInteger = bigInteger.divide(BigInteger.valueOf(base));
            pow++;
        }

        return pow;
    }


    private BigInteger getTi(BigInteger bigInt, int base) {

        int pow = getPow(bigInt, base);

        return bigInt.divide(BigInteger.valueOf((long)Math.pow(base,pow)));
    }

}
