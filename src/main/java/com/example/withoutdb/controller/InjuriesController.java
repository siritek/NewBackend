package com.example.withoutdb.controller;

import com.example.withoutdb.model.Injuries;
import com.example.withoutdb.service.InjuriesServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8090"})
@RestController
@RequestMapping("/injuries")
public class InjuriesController {
    private InjuriesServiceImpl injuriesService = new InjuriesServiceImpl();

    @PostMapping("/all")
    public String all(@RequestBody Injuries injuries){
        try{
            injuriesService.saveInjuries(injuries);
            String json = new ObjectMapper().writeValueAsString(injuries);
            System.out.println("received this json from react for injuries :- " + json);
            System.out.println("Connection reached Controller");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return "";
    }

    @GetMapping("/getAll")
    public List<Injuries> getAllInjuries(){
        return injuriesService.getAllInjuries();
    }
}
