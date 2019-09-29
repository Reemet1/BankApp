package com.prometheus.learning.enterprise.security;

public class Algorithms {

    enum KeyPairGenerator {
        DiffieHellman("DiffieHellman"), //Diffie-Hellman KeyAgreement algorithm
        DSA("DSA"), //Digital Signature Algorithm
        RSA("RSA"), // RSA algorithm (Signature/Cipher)
        EC("EC"); //Elliptic Curve algorithm

        private String algorithm;

        KeyPairGenerator(String algorithm) {
            this.algorithm = algorithm;
        }

        public String toString() {
            return algorithm;
        }
    }


    enum MessageDigest {

        MD2("MD2"),
        MD5("MD5"),
        SHA1("SHA-1"),
        SHA256("SHA-256"),
        SHA384("SHA-384"),
        SHA512("SHA-512");

        String algorithm;

        MessageDigest(String algorithm) {
            this.algorithm = algorithm;
        }

        public String toString() {
            return algorithm;
        }
    }

    enum KeyGenerator {

        AES("AES"),
        DES("DES"),
        DESede("DESede"),
        HmacSHA1("HmacSHA1"),
        HmacSHA256("HmacSHA256");


        String algorithm;

        KeyGenerator(String algorithm) {
            this.algorithm = algorithm;
        }

        public String toString() {
            return algorithm;
        }
    }

    enum Mac {

        HmacMD5("HmacMD5"),
        HmacSHA1("HmacSHA1"),
        HmacSHA256("HmacSHA256"),
        HmacSHA384("HmacSHA284"),
        HmacSHA512("HmacSHA512");

        String algorithm;

        Mac(String algorithm) {
            this.algorithm = algorithm;
        }

        public String toString() {
            return algorithm;
        }
    }



}
