package com.example.withoutdb.controller;

import com.example.withoutdb.model.Fnol;
import com.example.withoutdb.service.DBConn;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClaimController {

    private final DBConn dbConn;

    public ClaimController(DBConn dbConn) {
        this.dbConn = dbConn;
    }

    public static class FnolWrapper {
        private List<Fnol> claimloss;
        public FnolWrapper(List<Fnol> claimloss) {
            this.claimloss = claimloss;
        }
        public List<Fnol> getClaimloss() {
            return claimloss;
        }

        public void setClaimloss(List<Fnol> claimloss) {
            this.claimloss = claimloss;
        }
    }

    @GetMapping("/loss/{policy}")
    public Fnol createLoss(@PathVariable("policy") String policy) {
        Fnol claimLoss = new Fnol();

        try {
            Connection conn = dbConn.getMyConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT reportedby, FROM fnol WHERE policynumber = ?");
            statement.setString(1, policy);


            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                claimLoss.setReportedBy(rs.getString("reportedby"));


            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Exception in createLoss method: " + e);
        }

        return claimLoss;
    }}