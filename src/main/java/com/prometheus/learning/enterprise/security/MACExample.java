package com.prometheus.learning.enterprise.security;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import java.security.Key;
import java.security.SecureRandom;

/**
 * MAC (Message Authentication Code) algorithm is a symmetric key cryptographic technique to provide
 * message authentication. For establishing MAC process, the sender and receiver share a symmetric key K.
 *
 * Essentially, a MAC is an encrypted checksum generated on the underlying message that is
 * sent along with a message to ensure message authentication.
 */

public class MACExample {


    public void createAndVerifyMAC() throws Exception{
        String message = "Hi, how are you?";

        /** Creating a KeyGenerator object with the given algorithm */
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");

        /** Creating a SecureRandom object, which generates strong random numbers */
        SecureRandom secRandom = new SecureRandom();

        /** Initializing the KeyGenerator with a given string random number */
        keyGen.init(secRandom);


        /** Creating/Generating a key */
        Key key = keyGen.generateKey();

        /** Creating a Mac object */
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);

        byte[] bytes = message.getBytes();

        /** Combining message with a generated key and returns the checksum */
        byte[] macResult = mac.doFinal(bytes);

        String hexString = getHexString(macResult);

        verifyMessage(message, key, hexString);

    }

    public void verifyMessage(String message, Key key, String checksum) throws Exception{

        /** Creating a Mac object */
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);

        byte[] bytes = message.getBytes();

        byte[] macResult = mac.doFinal(bytes);
        String hexString = getHexString(macResult);

        System.out.println(hexString.equals(checksum));
    }

    public String getHexString(byte[] bytes) {
        /** Converting the byte array in to HexString format */
        StringBuffer hexString = new StringBuffer();

        for (int i = 0;i<bytes.length;i++) {
            hexString.append(Integer.toHexString(0xFF & bytes[i]));
        }
        return hexString.toString();
    }


}
