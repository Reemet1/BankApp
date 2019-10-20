package com.prometheus.crypto.api;

import org.bouncycastle.pkcs.PKCS10CertificationRequest;

import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());


        KeySpecUtils keySpecPrinter = new KeySpecUtils();
        KeyGenerator generator = new KeyGenerator();
        KeySpecUtils keySpecUtils = new KeySpecUtils();

        Person reemet = new Person("Reemet","Ammer");
        Person andrus = new Person("Andrus","Kelgu");

        reemet.generateKeyPair();
        reemet.generateDHKeyPair();
        andrus.generateKeyPair();
        andrus.generateDHKeyPair();

        System.out.println();

        //save(reemet.getKeyPair());

        keySpecPrinter.printSpec(keySpecUtils.getKeySpec(reemet.getKeyPair().getPublic()));
        keySpecPrinter.printSpec(keySpecUtils.getKeySpec(reemet.getKeyPair().getPrivate()));
        keySpecPrinter.printSpec(keySpecUtils.getKeySpec(andrus.getKeyPair().getPublic()));
        keySpecPrinter.printSpec(keySpecUtils.getKeySpec(andrus.getKeyPair().getPrivate()));

        PKCS10CertificationRequest reemetCSR = reemet.generateCSR();
        PKCS10CertificationRequest andrusCSR = andrus.generateCSR();

        CertificateAuthority ca = CertificateAuthority.getInstance();

        X509Certificate reemetCert = ca.issueCert(reemet, reemetCSR);
        X509Certificate andrusCert = ca.issueCert(andrus, andrusCSR);

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec;
        X509EncodedKeySpec x509EncodedKeySpec;

        reemet.getKeyPair().getPublic().equals(reemetCert.getPublicKey());


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

        boolean verified = signer.verifyDigitalSignature(decryptedMessage, reemetCert, decryptedSignature, Algorithms.Signature.SHA256withRSA);
        System.out.println("Validating signature for a given message: " + verified);



    }

    public static void save(KeyPair keyPair) throws IOException {
        final PrivateKey privateKey = keyPair.getPrivate();
        final PublicKey publicKey = keyPair.getPublic();

        // Store Public Key
        final File publicKeyFile = new File("publicout.pem");
        //publicKeyFile.getParentFile().mkdirs(); // make directories if they do not exist
        final X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
        try (FileOutputStream fos = new FileOutputStream(publicKeyFile)) {
            fos.write(x509EncodedKeySpec.getEncoded());
        }

        // Store Private Key.
        final File privateKeyFile = new File("privateout.pem");
        //privateKeyFile.getParentFile().mkdirs(); // make directories if they do not exist
        final PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
        try (FileOutputStream fos = new FileOutputStream(privateKeyFile)) {
            fos.write(pkcs8EncodedKeySpec.getEncoded());
        }
    }
}
