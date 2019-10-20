package com.prometheus.crypto.api;

import org.bouncycastle.pkcs.PKCS10CertificationRequest;

import java.security.*;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * Trusted third party which signs and issues public certificates.
 */
public class CertificateAuthority {

    private Map<Person, X509Certificate> certs;

    private KeyPair caKeyPair;

    private String name;
    private static CertificateAuthority instance;

    private X509CertBuilder certBuilder;

    private CertificateAuthority(String name) {
        this.name = name;
        certs = new HashMap<>();
        certBuilder = new X509CertBuilder();
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA","BC");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        caKeyPair = keyPairGen.generateKeyPair();
    }

    public static CertificateAuthority getInstance() {

        if(instance == null) {
            instance = new CertificateAuthority("CertificateAuthority");
        }
        return instance;
    }

    public void addCert(Person person, X509Certificate cert) {
        certs.put(person, cert);
    }

    public X509Certificate getCert(Person person) {
        return certs.get(person);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PublicKey getCAPublicKey() {
        return caKeyPair.getPublic();
    }

    public X509Certificate issueCert(Person person, PKCS10CertificationRequest csr) throws Exception {

        X509Certificate cert = certBuilder.getCAsignedCertFromCSR(csr, caKeyPair);
        certs.put(person, cert);

        return cert;
    }

}
