package com.prometheus.bank.rest.controller;

import com.prometheus.bank.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

@RestController
@RequestMapping("/api")
public class DocumentRestController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/get")
    public String getDocuments() {
        return new String("abc");
    }

    /*
    @RequestMapping("/post")
    public @ResponseBody String postMapping(@RequestBody String body) throws Exception {
        String hex = body.substring(4);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        //byte[] decoded = Base64.getDecoder().decode(hex);
        InputStream is = new ByteArrayInputStream(hex.getBytes());
        Certificate cert = cf.generateCertificate(is);
        return body;
    }
    */




    @GetMapping("/getDocument/{id}")
    public String getDocument() {
        return "";
    }

    @PostMapping("/addDocument")
    public String addDocument() {
        return "";
    }

    @DeleteMapping("/deleteDocument/{id}")
    public String deleteDocument() {
        return "";
    }
}
