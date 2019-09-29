package com.prometheus.bank.service;

import com.prometheus.bank.dao.IGenericDAO;
import com.prometheus.bank.entity.Document;

import java.util.List;

public interface DocumentService extends IGenericDAO<Document> {

    Document getDocument(long id);

    List<Document> getAllDocuments();

    void saveDocument(Document document);

    void updateDocument(Document document);

    void deleteDocument(long id);

}
