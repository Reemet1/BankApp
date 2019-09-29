package com.prometheus.bank.service;

import com.prometheus.bank.dao.DocumentDAO;
import com.prometheus.bank.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl extends AbstractService<Document> implements DocumentService {

    @Autowired
    private DocumentDAO documentDAO;

    @Override
    public Document getDocument(long id) {
        return documentDAO.getDocument(id);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentDAO.getAllDocuments();
    }

    @Override
    public void saveDocument(Document document) {
        documentDAO.saveDocument(document);
    }

    @Override
    public void updateDocument(Document document) {
        documentDAO.updateDocument(document);
    }

    @Override
    public void deleteDocument(long id) {
        documentDAO.deleteDocument(id);
    }
}
