package com.example.withoutdb.controller;

import com.example.withoutdb.DAO.ExposuresDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/exposuresDD")
public class ExposuresDAOController {
    // exposures screen  Dropdowns values

    private final ExposuresDAO exposuresDAO;
    public ExposuresDAOController(ExposuresDAO exposuresDAO) {
        this.exposuresDAO = exposuresDAO;
    }

    @GetMapping
    public Map<String, List<String>> getExposures () {
        return exposuresDAO.getExposures();
    }
}
