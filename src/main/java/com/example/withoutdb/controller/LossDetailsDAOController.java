package com.example.withoutdb.controller;


import com.example.withoutdb.DAO.LossDetailsDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/lossdetailsDD")
//lossdetails Drop down values

public class LossDetailsDAOController {
    private final LossDetailsDAO lossDetailsDAO;

    public LossDetailsDAOController(LossDetailsDAO lossDetailsDAO) {
        this.lossDetailsDAO = lossDetailsDAO; ;
    }
    @GetMapping
    public Map<String, List<String>> getLossDetails () {
        System.out.println("Connection reached LossCauseDAOController getLossCauses method\n");
        return lossDetailsDAO.getLossDetails();
    }
}
