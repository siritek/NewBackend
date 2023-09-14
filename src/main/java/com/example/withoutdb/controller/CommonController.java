//package com.example.withoutdb.controller;
//
//import com.example.withoutdb.model.Common;
//import com.example.withoutdb.model.Fnol;
//import com.example.withoutdb.service.CommonServiceImpl;
//import org.springframework.web.bind.annotation.*;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/common")
//
//public class CommonController {
//
//    private CommonServiceImpl CommonService = new CommonServiceImpl();
//
//    @PostMapping("/add")
//    public String add(@RequestBody Common common){
//        try {
//            CommonService.saveCommon(common);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return "";
//    }
//}

package com.example.withoutdb.controller;

import com.example.withoutdb.model.Common;
import com.example.withoutdb.model.Fnol;
import com.example.withoutdb.service.CommonServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/common")
public class CommonController {

    private CommonServiceImpl CommonService = new CommonServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody Common common){
        String claimNumber = null;
        try {
            System.out.println("connection reached Common controller");
            claimNumber = CommonService.saveCommon(common);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(claimNumber + " in controller");
        return "{\"claimNumber\": \"" + claimNumber + "\"}";
    }
}
