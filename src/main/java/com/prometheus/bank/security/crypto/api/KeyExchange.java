package com.prometheus.bank.security.crypto.api;


import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyExchange {

    public static SecretKey generateSharedSecret(PublicKey otherDHPublicKey, PrivateKey myDHPrivateKey){

        SecretKey sharedSecretKey= null;

        try {
            //KeyGenerator keyGenerator = new KeyGenerator();
            //KeyPair keyPair1 = keyGenerator.generateKeyPair(Algorithms.KeyPairGenerator.DiffieHellman);
            //KeyPair keyPair2 = keyGenerator.generateKeyPair(Algorithms.KeyPairGenerator.DiffieHellman);

            KeyAgreement keyAgreement1 = KeyAgreement.getInstance("DiffieHellman");
            keyAgreement1.init(myDHPrivateKey);
            keyAgreement1.doPhase(otherDHPublicKey, true);

            /* KeyAgreement keyAgreement2 = KeyAgreement.getInstance("DiffieHellman");
            keyAgreement2.init(keyPair2.getPrivate());
            keyAgreement2.doPhase(keyPair1.getPublic(), true); */

            byte[] secret1 = keyAgreement1.generateSecret();
            //byte[] secret2 = keyAgreement2.generateSecret();

            SecretKeyFactory secretKeyFactory1 = SecretKeyFactory.getInstance("DES");
            //SecretKeyFactory secretKeyFactory2 = SecretKeyFactory.getInstance("DES");

            DESKeySpec desKeySpec1 = new DESKeySpec(secret1);
            //DESKeySpec desKeySpec2 = new DESKeySpec(secret2);
            sharedSecretKey = secretKeyFactory1.generateSecret(desKeySpec1);
            //SecretKey secretKey2 = secretKeyFactory2.generateSecret(desKeySpec2);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sharedSecretKey;
    }

}
