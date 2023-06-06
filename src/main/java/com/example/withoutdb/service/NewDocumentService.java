package com.example.withoutdb.service;

import com.example.withoutdb.model.Fnol;
import com.example.withoutdb.model.NewDocument;

import java.sql.SQLException;
import java.util.List;

public interface NewDocumentService {


    public void saveNewDocument(NewDocument newdocument);

    public List<NewDocument> getAllnewdocuments() ;
}
