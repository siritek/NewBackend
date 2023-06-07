package com.example.withoutdb.controller;

import com.example.withoutdb.DAO.LossPartyDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/lossParty")

public class LossPartyDAOController {
    private final LossPartyDAO lossPartyDAO;

    public LossPartyDAOController(LossPartyDAO lossPartyDAO) {
        this.lossPartyDAO = lossPartyDAO;
    }
    @GetMapping
    public List<String> getlossParties() {
        System.out.println("Connection reached lossPartyDAOController getlossParties method\n");
        return lossPartyDAO.getlossParties();
    }
}
