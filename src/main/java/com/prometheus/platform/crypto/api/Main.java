package com.prometheus.platform.crypto.api;

import javax.crypto.SecretKey;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        Person reemet = new Person("Reemet","Ammer");
        Person andrus = new Person("Andrus","Kelgu");

        reemet.generateKeyPair();
        reemet.generateDHKeyPair();
        andrus.generateKeyPair();
        andrus.generateDHKeyPair();

        reemet.sendDHPublicKey(andrus);
        andrus.sendDHPublicKey(reemet);

        reemet.generateSharedSecret(reemet.getOtherDHPublicKey());
        andrus.generateSharedSecret(andrus.getOtherDHPublicKey());

        SecretKey secretKey1 = reemet.getSharedSecret();
        SecretKey secretKey2 = andrus.getSharedSecret();

        if(Arrays.equals(secretKey1.getEncoded(), secretKey2.getEncoded())) {
            System.out.println("Secret keys are equal");
        } else throw new RuntimeException("Secret keys are not equal");

        SecretKey encryptionKey = secretKey1;


        KeyGenerator keyGenerator = new KeyGenerator();
        Encrypter encrypter = new Encrypter();
        Signer signer = new Signer();

        String message = "Random message";
        System.out.println("Message: " + message);

        byte[] signature = signer.createDigitalSignature(message.getBytes(), reemet.getKeyPair().getPrivate(), Algorithms.Signature.SHA256withRSA);
        System.out.println("Signed message: " + new String(signature));

        String encryptedMessage = encrypter.encrypt(message.getBytes(), encryptionKey, Algorithms.Cipher.AES_CBC_PKCS5PADDING);
        System.out.println("Enrypting message: " + encryptedMessage);
        String encryptedSignature = encrypter.encrypt(signature, encryptionKey, Algorithms.Cipher.AES_CBC_PKCS5PADDING);
        System.out.println("Enrypting signature: " + encryptedSignature);

        System.out.println("Sending encrypted message and signature");
        System.out.println("Received encrypted message and signature");

        byte[] decryptedMessage = encrypter.decrypt(encryptionKey, encryptedMessage, Algorithms.Cipher.AES_CBC_PKCS5PADDING);
        byte[] decryptedSignature = encrypter.decrypt(encryptionKey, encryptedSignature, Algorithms.Cipher.AES_CBC_PKCS5PADDING);
        System.out.println("Message decrypted: " + new String(decryptedMessage));
        System.out.println("Signature decrypted: " + new String(decryptedSignature));

        boolean verified = signer.verifyDigitalSignature(decryptedMessage, reemet.getKeyPair().getPublic(), decryptedSignature, Algorithms.Signature.SHA256withRSA);
        System.out.println("Validating signature for a given message: " + verified);



    }
}
