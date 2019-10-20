package com.prometheus.crypto.api;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.bc.BcRSAContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

import javax.security.auth.x500.X500Principal;
import java.io.*;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.cert.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class X509CertBuilder {

    /*
    private X509CertInfo x509CertInfo;

    public X509CertBuilder() {
        x509CertInfo = new X509CertInfo();
    }

    public X509Certificate build() {
        return new X509CertImpl(x509CertInfo);
    }

    public void setPublicKey(PublicKey publicKey) {
        try {
            x509CertInfo.set(CertAttr.KEY.getAttr(), new CertificateX509Key(publicKey));
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCertVersion(CertificateVersion ver) {
        try {
            x509CertInfo.set(CertAttr.VERSION.getAttr(), ver);
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCertSerialNumber(BigInteger certSerialNumber) {
        try {
            x509CertInfo.set(CertAttr.SERIAL_NUMBER.getAttr(), new CertificateSerialNumber(certSerialNumber));
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCertAlgorithmId(String algId) {
        ObjectIdentifier objectIdentifier = null;
        try {
            objectIdentifier = new ObjectIdentifier(algId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AlgorithmId algorithmId = new AlgorithmId(objectIdentifier);
        CertificateAlgorithmId certificateAlgorithmId = new CertificateAlgorithmId(algorithmId);
        try {
            x509CertInfo.set(CertAttr.ALGORITHM_ID.getAttr(), certificateAlgorithmId);
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setIssuer(RDN[] rdns) {
        try {
            x509CertInfo.set(CertAttr.ISSUER.getAttr(), new X500Name(rdns));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }

    public void setSubject(RDN[] rdns) {
        try {
            x509CertInfo.set(CertAttr.SUBJECT.getAttr(), new X500Name(rdns));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }

    public void setIssuerUniqueID(byte[] uid) {
        try {
            x509CertInfo.set(CertAttr.ISSUER_ID.getAttr(), new UniqueIdentity(uid));
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setSubjectUniqueID(byte[] uid) {
        try {
            x509CertInfo.set(CertAttr.SUBJECT_ID.getAttr(), new UniqueIdentity(uid));
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setExtensions(CertificateExtensions extensions) {

        try {
            x509CertInfo.set(CertAttr.EXTENSIONS.getAttr(), extensions);
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setCertValidity(Date notBefore, Date notAfter) {
        try {
            x509CertInfo.set(CertAttr.VALIDITY.getAttr(), new CertificateValidity(notBefore,notAfter));
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */

    enum CertVersion {
        V1(1),
        V2(2),
        V3(3);

        private int ver;

        private CertVersion(int ver) {
            this.ver = ver;
        }

        public int getVer() {
            return ver;
        }
    }

    enum CertAttr {

        VERSION("version"),
        SERIAL_NUMBER("serialNumber"),
        ALGORITHM_ID("algorithmID"),
        ISSUER("issuer"),
        VALIDITY("validity"),
        SUBJECT("subject"),
        KEY("key"),
        ISSUER_ID("issuerID"),
        SUBJECT_ID("subjectID"),
        EXTENSIONS("extensions");


        String attrName;

        private CertAttr(String attrName) {
            this.attrName = attrName;
        }

        public String getAttr() {
            return attrName;
        }
    }

    public PKCS10CertificationRequest generateCSR(KeyPair keyPair) {

        PKCS10CertificationRequestBuilder p10Builder = new JcaPKCS10CertificationRequestBuilder(
                new X500Principal("C=EE, L=Tartu, O=PT, CN=yourdomain.com/emailAddress=your@email.com"),
                keyPair.getPublic()
        );
        JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder("SHA256withRSA");
        ContentSigner signer = null;
        try {
            signer = csBuilder.build(keyPair.getPrivate());
        } catch (OperatorCreationException e) {
            throw new RuntimeException(e);
        }


        PKCS10CertificationRequest csr = p10Builder.build(signer);
        return csr;

    }

    public X509Certificate getCAsignedCertFromCSR(PKCS10CertificationRequest csr, KeyPair caKeyPair) throws Exception {

        PKCS10CertificationRequest csrHolder = new PKCS10CertificationRequest(csr.getEncoded());
        AlgorithmIdentifier sigAlgId = new DefaultSignatureAlgorithmIdentifierFinder().find("SHA256withRSA");
        AlgorithmIdentifier digAlgId = new DefaultDigestAlgorithmIdentifierFinder().find(sigAlgId);

        X509v3CertificateBuilder certificateGenerator = new X509v3CertificateBuilder(
                //These are the details of the CA
                new org.bouncycastle.asn1.x500.X500Name("C=US, L=Vienna, O=Your CA Inc"),
                //This should be a serial number that the CA keeps track of
                new BigInteger("1"),
                //Certificate validity start
                Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)),
                //Certificate validity end
                Date.from(LocalDateTime.now().plusDays(365).toInstant(ZoneOffset.UTC)),
                //Blanket grant the subject as requested in the CSR
                //A real CA would want to vet this.
                csrHolder.getSubject(),
                //Public key of the certificate authority
                //SubjectPublicKeyInfo.getInstance(ASN1Sequence.getInstance(caKeyPair.getPublic().getEncoded()))
                //SubjectPublicKeyInfo.getInstance(ASN1Sequence.getInstance(caKeyPair.getPublic().getEncoded()))
                csr.getSubjectPublicKeyInfo()
        );
        ContentSigner sigGen = new BcRSAContentSignerBuilder(sigAlgId, digAlgId)
                .build(PrivateKeyFactory.createKey(caKeyPair.getPrivate().getEncoded()));

        X509CertificateHolder holder = certificateGenerator.build(sigGen);
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509", "BC");
        X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(
                new ByteArrayInputStream(
                        holder.toASN1Structure().getEncoded()
                )
        );

        ByteArrayOutputStream certOutputStream = new ByteArrayOutputStream();
        FileOutputStream certOutput = new FileOutputStream("cert.cer");
        try (PemWriter pemWriter = new PemWriter(new OutputStreamWriter(certOutput))) {
            pemWriter.writeObject(new PemObject("CERTIFICATE", certificate.getEncoded()));
        } catch (IOException | CertificateEncodingException e) {
            throw new RuntimeException(e);
        }


        return certificate;

    }


    public X509Certificate readCert(String certPath) {

        FileInputStream fis;
        X509Certificate x509Cert = null;

        try {
            fis = new FileInputStream(certPath);
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Certificate certificate = certificateFactory.generateCertificate(fis);
            x509Cert = (X509Certificate)certificate;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return x509Cert;
    }


}
