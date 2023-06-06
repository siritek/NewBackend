package com.example.withoutdb.controller;

import java.util.List;

import com.example.withoutdb.model.Documents;
import com.example.withoutdb.service.DocumentsServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documentsfirst")
@CrossOrigin
public class DocumentsController {


    private DocumentsServiceImpl documentsService = new DocumentsServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody Documents documents){
        documentsService.saveDocuments(documents);
        System.out.println("Connection reached Controller");
        return "New Documents info is added";
    }

    @GetMapping("/getAll")
    public List<Documents> getAlldocuments() {
        return documentsService.getAlldocuments();
    }
}
