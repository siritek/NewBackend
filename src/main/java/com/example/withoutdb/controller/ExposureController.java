package com.example.withoutdb.controller;

import com.example.withoutdb.model.Exposure;
import com.example.withoutdb.service.ExposureServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/fnolfirst")
@CrossOrigin
public class ExposureController {


    private ExposureServiceImpl exposureService = new ExposureServiceImpl();

    @PostMapping("/add")
    public Object add(@RequestBody Exposure exposure){
        exposureService.saveExposure(exposure );
        System.out.println("Connection reached Controller");
       // System.out.println("New Exposure info is added");
        return "New Exposure info is added";
    }
    @GetMapping("/getAll")
    public List<Exposure> getAllexposures() {
        return exposureService.getAllexposures();
    }
}
