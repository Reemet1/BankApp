package com.prometheus.platform.crypto.api;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class CertificateAuthority {

    private Map<Person, PublicKey> publicKeys;

    private String name;

    public CertificateAuthority(String name) {
        this.name = name;
        publicKeys = new HashMap<>();
    }

    public void addPublicKey(Person person, PublicKey publicKey) {
        publicKeys.put(person, publicKey);
    }

    public PublicKey getPublicKey(Person person) {
        return publicKeys.get(person);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
