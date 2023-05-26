package com.NewNotepage.NewNote.Controller;

import org.springframework.web.bind.annotation.*;


import com.NewNotepage.NewNote.Model.LossSummary;
import com.NewNotepage.NewNote.Service.LossSummaryServiceImpl;



import java.util.List;
@RestController
@RequestMapping("/losssummaryfirst")
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


