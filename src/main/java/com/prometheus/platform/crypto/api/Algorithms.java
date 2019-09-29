package com.prometheus.platform.crypto.api;

public class Algorithms {

    public enum KeyPairGenerator {
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

    public enum Signature {

        SHA1withDSA,
        SHA1withRSA,
        SHA256withRSA
    }

    enum Hash {

        SHA256("SHA-256"),
        SHA("SHA"),
        MD5("MD5");

        String algorithm;

        Hash(String algorithm) {
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

    enum Cipher {

        AES_ECB_PKCS5PADDING(CipherAlgorithm.AES, CipherMode.ECB, CipherPadding.PKCS5Padding),
        AES_ECB_NOPADDING(CipherAlgorithm.AES, CipherMode.ECB, CipherPadding.NoPadding),
        AES_CBC_PKCS5PADDING(CipherAlgorithm.AES, CipherMode.CBC, CipherPadding.PKCS5Padding),
        AES_CBC_NOPADDING(CipherAlgorithm.AES, CipherMode.CBC, CipherPadding.NoPadding),
        DES_ECB_PKCS5PADDING(CipherAlgorithm.DES, CipherMode.ECB, CipherPadding.PKCS5Padding),
        DES_ECB_NOPADDING(CipherAlgorithm.DES, CipherMode.ECB, CipherPadding.NoPadding),
        DES_CBC_PKCS5PADDING(CipherAlgorithm.DES, CipherMode.CBC, CipherPadding.PKCS5Padding),
        DES_CBC_NOPADDING(CipherAlgorithm.DES, CipherMode.CBC, CipherPadding.NoPadding),
        RSA_ECB_PKCS1PADDING(CipherAlgorithm.RSA, CipherMode.ECB, CipherPadding.PKCS1Padding);

        private CipherAlgorithm algorithm;
        private CipherMode mode;
        private CipherPadding padding;

        Cipher(CipherAlgorithm algorithm, CipherMode mode, CipherPadding padding) {
            this.algorithm = algorithm;
            this.mode = mode;
            this.padding = padding;
        }

        public CipherAlgorithm getAlgorithm() {
            return algorithm;
        }

        public boolean isSymmetric() {
            if(algorithm != CipherAlgorithm.RSA) return true;
            else return false;
        }

        public String toString() {
            return algorithm+"/"+mode+"/"+padding;
        }

    }

    private enum CipherMode {
        CBC,
        ECB
    }

    private enum CipherAlgorithm {
        AES,
        DES,
        RSA;

    }

    private enum CipherPadding {
        PKCS1Padding,
        PKCS5Padding,
        NoPadding
    }

}
