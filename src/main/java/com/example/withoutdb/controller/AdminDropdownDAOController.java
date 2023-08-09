package com.example.withoutdb.controller;

import com.example.withoutdb.DAO.AdminDropdownDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admindropdownsDD")


public class AdminDropdownDAOController {
    
    private final AdminDropdownDAO adminDropdownDAO;

    public AdminDropdownDAOController(AdminDropdownDAO adminDropdownDAO) {
        this.adminDropdownDAO = adminDropdownDAO;
    }


    @GetMapping
    public Map<String, List<String>> getAdminDropdownValues() {
        System.out.println("Connection reached PolicyTypeDAOController getPolicyTypes method\n");
        return AdminDropdownDAO.getAdminDropdownValues();
    }
}
