package com.prometheus.crypto.api;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class Encrypter {

    public String encrypt(byte[] message, Key key, Algorithms.Cipher algorithm) {


        try {
            Cipher cipher = Cipher.getInstance(algorithm.toString());

            if(algorithm.isSymmetric()) {
                //Iv must be 16 bytes long, and can be sent along with encrypted message as plaintext
                //Iv ensures that the same plaintext gets encrypted into a different ciphertext
                String initVector = "RandomIVString56";

                IvParameterSpec ivSpec = new IvParameterSpec(initVector.getBytes("UTF-8"));
                SecretKeySpec skeySpec = new SecretKeySpec(key.getEncoded(), ""+algorithm.getAlgorithm());
                //tLen values {128, 120, 112, 104, 96}
                //GCMParameterSpec gcmSpec = new GCMParameterSpec(128, ivSpec.getIV());

                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivSpec);
                //cipher.updateAAD();

            } else {
                cipher.init(Cipher.ENCRYPT_MODE, key);
            }

            byte[] encrypted = cipher.doFinal(message);

            return Base64.getEncoder().encodeToString(encrypted);
            //return encrypted;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public byte[] decrypt(Key key, String encrypted, Algorithms.Cipher algorithm) {
        try {

            Cipher cipher = Cipher.getInstance(algorithm.toString());

            if(algorithm.isSymmetric()) {
                String initVector = "RandomIVString56";

                IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
                SecretKeySpec skeySpec = new SecretKeySpec(key.getEncoded(), ""+algorithm.getAlgorithm());
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, key);
            }

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
            return original;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }


}
