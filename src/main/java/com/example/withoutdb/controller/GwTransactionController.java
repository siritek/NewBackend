package com.example.withoutdb.controller;

import com.example.withoutdb.model.GwTransaction;
import com.example.withoutdb.service.GwTransactionServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/gw-transaction")
public class GwTransactionController
{
    private GwTransactionServiceImpl gwTransactionService = new GwTransactionServiceImpl();

    @GetMapping("/all")
    public String all(@RequestBody GwTransaction gwTransaction)
    {
        try
        {
            gwTransactionService.saveGwTransaction(gwTransaction);
            String json = new ObjectMapper().writeValueAsString(gwTransaction);
            System.out.println("received this json from react for gw-transaction :- " + json);
            System.out.println("Connection reached Controller");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return "";
    }
}
