package com.example.withoutdb.controller;

import com.example.withoutdb.model.GwTransaction;
import com.example.withoutdb.service.DBConn;
import com.example.withoutdb.service.GwTransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/nxt_gwtransaction")
public class GwTransactionController
{
    private final GwTransactionServiceImpl transactionService;
    private final DBConn dbConn;

    @Autowired
    public GwTransactionController(DBConn dbConn, GwTransactionServiceImpl transactionService) {
        this.dbConn = dbConn;
        this.transactionService = transactionService;
    }


    @GetMapping("/getAll")
    public List<GwTransaction> getAllGwTransactions() {
        return transactionService.getAllGwTransactions();
    }
}