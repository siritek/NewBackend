package com.example.withoutdb.controller;


import com.example.withoutdb.model.Policyinformation;
import com.example.withoutdb.service.PolicyinformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

import java.util.List;

@RestController
@RequestMapping("/fnolfirst")

@CrossOrigin


public class PolicyinformationController {



    @Autowired

    private PolicyinformationServiceImpl policyinformationService = new PolicyinformationServiceImpl();

    @PostMapping("/add{myPolicyInfo}")
    public String add(@RequestBody Policyinformation policyinformation){
        policyinformationService.savePolicyinformation(policyinformation);
        System.out.println("Connection reached Controller");
        //System.out.println(policyinformation.getDateOfLoss());
        return "New Policyinformation info is added";
    }

    @GetMapping("/getAll")
    public List<Policyinformation> getAllpolicyinformations() {
        return policyinformationService.getAllpolicyinformations();
    }
}
