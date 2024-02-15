package com.example.withoutdb.controller;

import java.util.List;

import com.example.withoutdb.model.SearchNoteModel;
import com.example.withoutdb.service.SearchNoteServiceImpl;
import org.springframework.web.bind.annotation.*;
import  com.example.withoutdb.service.SearchNoteService;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8090"})
@RestController
@RequestMapping("/searchnotefirst")
public class SearchNoteController
{
    private SearchNoteServiceImpl SearchNoteService = new SearchNoteServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody SearchNoteModel searchNoteModel) {
        SearchNoteService.saveSearchNote(searchNoteModel);
        System.out.println("Connection reached Controller");
        return "Search note info is added";
        }
        @GetMapping("/getAll")
        public List<SearchNoteModel> getAllsearchnotes(){
        return SearchNoteService.getAllsearchnotes();
        }

    }

