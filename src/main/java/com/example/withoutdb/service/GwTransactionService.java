package com.example.withoutdb.service;


import com.example.withoutdb.model.GwTransaction;
import java.sql.*;
import java.util.List;

public interface GwTransactionService
{
    public void saveGwTransaction(GwTransaction gwTransaction);

    public List<GwTransaction> getAllGwTransactions();
}
