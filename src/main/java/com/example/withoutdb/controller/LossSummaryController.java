package com.example.withoutdb.controller;


import com.example.withoutdb.model.LossSummary;
import com.example.withoutdb.service.LossSummaryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/fnolfirst")
@CrossOrigin
public class LossSummaryController {
    private LossSummaryServiceImpl LossSummaryService = new LossSummaryServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody LossSummary losssummary){
        LossSummaryService.saveLossSummary(losssummary);
        System.out.println("Connection reached Controller");
        return "New Loss Summary info is added";
    }

    @GetMapping("/getAll")
    public List<LossSummary> getAlllosssummarys(){
        return LossSummaryService.getAlllosssummarys();
    }

    }


