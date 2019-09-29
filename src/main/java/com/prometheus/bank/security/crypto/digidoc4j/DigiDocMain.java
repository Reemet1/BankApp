package com.prometheus.bank.security.crypto.digidoc4j;

import com.prometheus.bank.security.crypto.api.Algorithms;
import com.prometheus.bank.security.crypto.api.KeyGenerator;
import com.prometheus.bank.security.crypto.api.Signer;
import org.digidoc4j.*;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class DigiDocMain {

    public static void main(String[] args) {


        //Create a container with a text file to be signed
        Container container = ContainerBuilder.
                aContainer().
                withDataFile("testfiles/contract.txt", "text/plain").
                build();

//Get the certificate (with a browser plugin, for example)
        X509Certificate signingCert = getSignerCert();


        KeyFactory kf = null;
        try {
            String privateKeyContent = new String(Files.readAllBytes(Paths.get("testfiles/reemet1.pem")));
            privateKeyContent = privateKeyContent.replaceAll("(-+BEGIN RSA PRIVATE KEY-+\\r?\\n|-+END RSA PRIVATE KEY-+\\r?\\n?)", "");
            kf = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyContent));
            //PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(privateKeyContent.getBytes());
            PrivateKey privKey = kf.generatePrivate(keySpecPKCS8);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Get the data to be signed by the user
        DataToSign dataToSign = SignatureBuilder.
                aSignature(container).
                withSigningCertificate(signingCert).
                withSignatureDigestAlgorithm(DigestAlgorithm.SHA256).
                buildDataToSign();

        //Data to sign contains the signature dataset with digest of file that should be signed
        byte[] signatureToSign = dataToSign.getDataToSign();
        //Sign the signature dataset with digest of file
        byte[] signatureValue = signDigest(signatureToSign, DigestAlgorithm.SHA256, container, signingCert);
        //signDigest(signatureToSign, DigestAlgorithm.SHA256, container, signingCert);

        //Finalize the signature with OCSP response and timestamp (or timemark)
        Signature signature1 = dataToSign.finalize(signatureValue);

        //Add signature to the container
        container.addSignature(signature1);

        //Save the container as a .bdoc file
        container.saveAsFile("testfiles/test-container.bdoc");

    }

    public static byte[] signDigest(byte[] signatureToSign, DigestAlgorithm digestAlgorithm, Container container, X509Certificate signerCert) {

        SignatureBuilder builder = SignatureBuilder.
                aSignature(container).
                withSignatureDigestAlgorithm(DigestAlgorithm.SHA256).
                withSignatureProfile(SignatureProfile.LT_TM).
                withSignatureId("S0").
                withSigningCertificate(signerCert);

        //Add the signature to the container
        //container.addSignature(builder.invokeSigning());

        Signer signer = new Signer();

        KeyGenerator keyGenerator = new KeyGenerator();
        PrivateKey privateKey = null;
        byte[] signature = null;
        try {
            privateKey = keyGenerator.generateKeyPair(Algorithms.KeyPairGenerator.RSA).getPrivate();
            signature = signer.createDigitalSignature(signatureToSign, privateKey, Algorithms.Signature.SHA256withRSA);
        } catch (Exception e) {

        }


        return signature;
    }

    public static X509Certificate getSignerCert() {

        X509Certificate cert = null;

        try {
            File file = new File("testfiles/reemet.cer");
            FileInputStream is = new FileInputStream (file);
            CertificateFactory fact = CertificateFactory.getInstance("X.509");
            cert = (X509Certificate)fact.generateCertificate(is);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cert;
    }

    public void createCert() {


    }

}
