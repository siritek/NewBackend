package com.example.withoutdb.controller;

import com.example.withoutdb.model.Common;
import com.example.withoutdb.service.CommonServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fnolfirst")
@CrossOrigin


public class CommonController {

    private CommonServiceImpl CommonService = new CommonServiceImpl();

//    @PostMapping("/add")
//    public String add(@RequestBody Common common){
//        CommonService.saveCommon(common);
//        System.out.println("Connection reached Controller");
//        return "New common info is added";
 //   }




}
