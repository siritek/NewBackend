package com.example.withoutdb.controller;


import com.example.withoutdb.DAO.DocumentsDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/documentsDD")
//documents Drop down values

public class DocumentsDAOController {
    private final DocumentsDAO documentsDAO;

    public DocumentsDAOController(DocumentsDAO documentsDAO) {
        this.documentsDAO = documentsDAO; ;
    }
    @GetMapping
    public Map<String, List<String>> getDocuments () {
        System.out.println("Connection reached DocumentsDAOController getDocuments method\n");
        return documentsDAO.getDocuments();
    }
}
