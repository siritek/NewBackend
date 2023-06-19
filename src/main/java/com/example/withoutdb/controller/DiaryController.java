package com.example.withoutdb.controller;

import java.util.List;

import com.example.withoutdb.model.Diary;
import com.example.withoutdb.service.DiaryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diaryfirst")
@CrossOrigin
public class DiaryController {


    private DiaryServiceImpl diaryService = new DiaryServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody Diary diary) {
        try {
            diaryService.saveDiary(diary);
            String json = new ObjectMapper().writeValueAsString(diary);
            System.out.println("received this json from react for dairy :- "+json);
            System.out.println("Connection reached Controller");
        } catch (Exception e) {
            System.out.println(e);
        }
        return "New Diary info is added";
    }

        @GetMapping("/getAll")
    public List<Diary> getAlldiaries() {
        return diaryService.getAlldiaries();
    }
}
