
package com.example.withoutdb.controller;

import com.example.withoutdb.DAO.PolicyTypeDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/policytypes")

public class PolicyTypeDAOController {
    private final PolicyTypeDAO policyTypeDAO;

    public PolicyTypeDAOController(PolicyTypeDAO policyTypeDAO) {
        this.policyTypeDAO = policyTypeDAO;
    }
    @GetMapping
    public List<String> getPolicyTypes() {
        //System.out.println("Connection reached PolicyTypeDAOController getPolicyTypes method\n");
        return policyTypeDAO.getPolicyTypes();
    }
}
