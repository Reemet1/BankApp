package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Document;

import java.util.List;

public interface DocumentDAO extends IGenericDAO<Document> {

    Document getDocument(long id);

    List<Document> getAllDocuments();

    void saveDocument(Document document);

    void updateDocument(Document document);

    void deleteDocument(long id);

}
