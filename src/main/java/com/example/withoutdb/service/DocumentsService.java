package com.example.withoutdb.service;

import com.example.withoutdb.model.Documents;

import java.sql.SQLException;
import java.util.List;

public interface DocumentsService {


    public void saveDocuments(Documents documents);

    public List<Documents> getAlldocuments() ;
}
