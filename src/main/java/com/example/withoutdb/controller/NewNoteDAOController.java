package com.example.withoutdb.controller;


import com.example.withoutdb.DAO.NewNoteDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/newnoteDD")
//newnote Drop down values

public class NewNoteDAOController {
    private final NewNoteDAO newNoteDAO;

    public NewNoteDAOController(NewNoteDAO newNoteDAO) {
        this.newNoteDAO = newNoteDAO; ;
    }
    @GetMapping
    public Map<String, List<String>> getNewNote () {
        //System.out.println("Connection reached NewNoteDAOController getNewNote method\n");
        return newNoteDAO.getNewNote();
    }
}
