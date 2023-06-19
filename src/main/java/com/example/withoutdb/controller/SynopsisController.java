package com.example.withoutdb.controller;


import com.example.withoutdb.model.Synopsis;
import com.example.withoutdb.service.SynopsisServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SynopsisController {

    private SynopsisServiceImpl SynopsisService = new SynopsisServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody Synopsis synopsis){
        try {
            SynopsisService.saveSynopsis(synopsis);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
