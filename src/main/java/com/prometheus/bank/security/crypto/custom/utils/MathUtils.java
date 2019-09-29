package com.prometheus.bank.security.crypto.custom.utils;

import java.math.BigInteger;

public class MathUtils {


    public static BigInteger gcd(BigInteger bigInt1, BigInteger bigInt2) {

        BigInteger bigger = bigInt1;
        BigInteger smaller = bigInt2;

        if(bigInt1.compareTo(bigInt2) > 0) {
            bigger = bigInt1;
            smaller = bigInt2;
        } else {
            bigger = bigInt2;
            smaller = bigInt1;
        }

        if(bigger.mod(smaller).equals(BigInteger.ZERO)) {
            return smaller;
        }

        BigInteger previousRemainder = BigInteger.ZERO;
        BigInteger currentRemainder = BigInteger.ZERO;
        BigInteger tempReminder = BigInteger.ZERO;

        previousRemainder = bigger.mod(smaller);
        currentRemainder = smaller.mod(previousRemainder);

        while(!currentRemainder.equals(BigInteger.ZERO)) {
            tempReminder = currentRemainder;
            currentRemainder = previousRemainder.mod(currentRemainder);
            previousRemainder = tempReminder;
        }

        return previousRemainder;
    }

    public static BigInteger lcm(BigInteger bigInt1, BigInteger bigInt2) {

        return bigInt1.multiply(bigInt2).abs().divide(gcd(bigInt1,bigInt2));
    }


}
