package com.example.withoutdb.controller;

import com.example.withoutdb.DAO.ClaimantTypeDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/claimanttypes")
public class ClaimantTypeDAOController {
    private final ClaimantTypeDAO claimantTypeDAO;
    public ClaimantTypeDAOController(ClaimantTypeDAO claimantTypeDAO) {
        this.claimantTypeDAO = claimantTypeDAO;
    }
    @GetMapping
    public List<String> getClaimantTypes() {
        return claimantTypeDAO.getClaimantTypes();
    }
}
