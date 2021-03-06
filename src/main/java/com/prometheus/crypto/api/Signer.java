package com.prometheus.crypto.api;

import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.X509Certificate;

public class Signer {


    public byte[] createDigitalSignature(byte[] message, PrivateKey privKey, Algorithms.Signature signatureAlgorithm) throws Exception{

        /** Creating a Signature object */
        Signature sign = Signature.getInstance(signatureAlgorithm.toString());

        /** Initialize the signature */
        sign.initSign(privKey);

        /** Adding data to the signature */
        sign.update(message);

        /** Calculating the signature */
        byte[] signature = sign.sign();

        /** Printing the signature */
        System.out.println("Digital signature for given text: "+new String(signature, "UTF8"));

        return signature;
    }

    public boolean verifyDigitalSignature(byte[] messageToverify, X509Certificate certificate, byte[] signature, Algorithms.Signature signatureAlgorithm) throws Exception{

        //Creating a Signature object
        Signature sign = Signature.getInstance(signatureAlgorithm.toString());

        sign.initVerify(certificate);
        sign.update(messageToverify);

        //Verifying the signature
        boolean isValid = sign.verify(signature);
        return isValid;
        //System.out.println("Signature valid: " + bool);
    }

}
