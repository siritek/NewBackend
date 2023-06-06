package com.example.withoutdb.controller;

import java.util.List;

import com.example.withoutdb.model.Diary;
import com.example.withoutdb.service.DiaryServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diaryfirst")
@CrossOrigin
public class DiaryController {


    private DiaryServiceImpl diaryService = new DiaryServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody Diary diary){
        diaryService.saveDiary(diary);
        System.out.println("Connection reached Controller");
        return "New Diary info is added";
    }

    @GetMapping("/getAll")
    public List<Diary> getAlldiaries() {
        return diaryService.getAlldiaries();
    }
}
