package com.example.withoutdb.controller;

import com.example.withoutdb.DAO.BasicInformationDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/basicinformationDD")
public class BasicInformationDAOController {
    private final BasicInformationDAO basicInformationDAO;
    public BasicInformationDAOController(BasicInformationDAO basicInformationDAO) {
        this.basicInformationDAO = basicInformationDAO; ;
    }
    @GetMapping
    public Map<String, List<String>> getBasicInformation () {
        System.out.println("Connection reached BasicInformationDAOController getBasicInformation method\n");
        return basicInformationDAO.getBasicInformation();
    }
}
