package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentDaoImpl extends GenericDaoImpl<Document> implements DocumentDAO {

    @Override
    public Document getDocument(long id) {
        return get(id);
    }

    @Override
    public List<Document> getAllDocuments() {
        return getAll();
    }

    @Override
    public void saveDocument(Document document) {
        save(document);
    }

    @Override
    public void updateDocument(Document document) {
        update(document);
    }

    @Override
    public void deleteDocument(long id) {
        delete(id);
    }
}
