package com.example.withoutdb.controller;


import com.example.withoutdb.DAO.NewDocumentDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/newDocumentDD")
//newDocument Drop down values

public class NewDocumentDAOController {
    private final NewDocumentDAO newDocumentDAO;

    public NewDocumentDAOController(NewDocumentDAO newDocumentDAO) {
        this.newDocumentDAO = newDocumentDAO ;
    }
    @GetMapping
    public Map<String, List<String>> getNewDocument () {
        System.out.println("Connection reached NewDocumentDAOController getNewDocument method\n");
        return newDocumentDAO.getNewDocument();
    }
}
