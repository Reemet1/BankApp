package com.prometheus.bank.service;

import org.digidoc4j.Configuration;
import org.digidoc4j.Container;
import org.digidoc4j.DataFile;
import org.digidoc4j.DataToSign;

import java.security.cert.X509Certificate;

public interface IFileSigner {

    public Container createContainer(DataFile dataFile);

    public DataToSign getDataToSign(Container containerToSign, String certificateInHex);

    public void signContainer(Container container, DataToSign dataToSign, String signatureInHex);

    public void setConfiguration(Configuration configuration);

    public X509Certificate getCertificate(String certificateInHex);

}
