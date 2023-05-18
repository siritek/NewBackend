package com.example.withoutdb.controller;

import java.util.List;

import com.example.withoutdb.model.Fnol;
import com.example.withoutdb.service.FnolServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fnolfirst")
@CrossOrigin
public class FnolController {


    private FnolServiceImpl fnolService = new FnolServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody Fnol fnol){
        fnolService.saveFnol(fnol);
        System.out.println("Connection reached Controller");
        return "New FNOL info is added";
    }

    @GetMapping("/getAll")
    public List<Fnol> getAllfnols() {
        return fnolService.getAllfnols();
    }
}
