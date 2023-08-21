package com.example.withoutdb.service;

import com.example.withoutdb.model.GwTransaction;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GwTransactionServiceImpl implements GwTransactionService
{
    @Override
    public void saveGwTransaction(GwTransaction gwTransaction) {
        try{
            Connection con =DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO gw_transaction(Id, GWClaimNumber, CreateDateTime, BaseClaimNumber, BasePolicyNumber, Status) values(?,?,?,?,?,?)");
            System.out.println(gwTransaction.getId() + " " + gwTransaction.getGWClaimNumber() + " " + gwTransaction.getCreateDateTime() + " " + gwTransaction.getBaseClaimNumber() + " " + gwTransaction.getBasePolicyNumber() + " " + gwTransaction.getStatus());
            ps.setString(1, gwTransaction.getId());
            ps.setString(2, gwTransaction.getGWClaimNumber());
            ps.setString(3, gwTransaction.getCreateDateTime());
            ps.setString(4, gwTransaction.getBaseClaimNumber());
            ps.setString(5, gwTransaction.getBasePolicyNumber());
            ps.setString(6, gwTransaction.getStatus());

            ps.executeQuery();

            System.out.println("Data inserted successfully");
        }
        catch (Exception e){
            System.out.println("Exception in saveGwTransaction method " + e);
        }
    }

    @Override
    public List<GwTransaction> getAllGwTransactions() {
        List<GwTransaction> allGwTransactions = new ArrayList<GwTransaction>();
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM gw_transaction");
            ResultSet rs = ps.executeQuery();
            GwTransaction x = null;

            while (rs.next()) {
                x = new GwTransaction();
                x.setId(rs.getString(1));
                x.setGWClaimNumber(rs.getString(2));
                x.setCreateDateTime(rs.getString(3));
                x.setBaseClaimNumber(rs.getString(4));
                x.setBasePolicyNumber(rs.getString(5));
                x.setStatus(rs.getString(6));

                allGwTransactions.add(x);
            }
            con.close();
        }
        catch (SQLException e) {
            System.out.println("Exception in getAllGwTransactions method " + e);
        }
        return allGwTransactions;
    }
}
