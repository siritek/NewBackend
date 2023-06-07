package com.example.withoutdb.controller;

import com.example.withoutdb.DAO.PolicyStatusDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/policystatus")

public class PolicyStatusDAOController {
    private final PolicyStatusDAO policyStatusDAO;

    public PolicyStatusDAOController(PolicyStatusDAO policyStatusDAO) {
        this.policyStatusDAO = policyStatusDAO;
    }

    @GetMapping
    public List<String> getPolicyTypes() {
        System.out.println("Connection reached PolicyTypeDAOController getPolicyTypes method\n");
        return policyStatusDAO.getPolicyStatus();
    }
}
