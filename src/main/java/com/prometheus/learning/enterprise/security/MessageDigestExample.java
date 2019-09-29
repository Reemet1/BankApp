package com.prometheus.learning.enterprise.security;

import java.security.MessageDigest;

/**
 * A hash function is a mathematical function that converts a numerical input value into another
 * compressed numerical value. The input to the hash function is of arbitrary length but output is
 * always of fixed length. Values returned by a hash function are called message digest or simply hash values.
 */
public class MessageDigestExample {


    public void messageDigest() throws Exception{
        String message = "Message";

        MessageDigest messageDigest = MessageDigest.getInstance(HashAlgorithm.SHA256.toString());

        messageDigest.update(message.getBytes());

        byte[] digest = messageDigest.digest();

        //Converting the byte array in to HexString format
        StringBuffer hexString = new StringBuffer();

        for (int i = 0;i<digest.length;i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        System.out.println("Hex format : " + hexString.toString());
    }

    enum HashAlgorithm {

        SHA256("SHA-256"),
        SHA("SHA"),
        MD5("MD5");

        String algorithm;

        HashAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }

        public String toString() {
            return algorithm;
        }

    }

}
