package com.example.withoutdb.controller;

import com.example.withoutdb.model.Common;
import com.example.withoutdb.model.Fnol;
import com.example.withoutdb.service.CommonServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/common")

public class CommonController {

    private CommonServiceImpl CommonService = new CommonServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody Common common){
        try {
            CommonService.saveCommon(common);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
