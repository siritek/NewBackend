package com.example.withoutdb.service;

import java.util.concurrent.atomic.AtomicInteger;
import java.sql.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/claim")
public class ClaimGeneration {

    // Declare the necessary dependencies
    private AtomicInteger lastClaimNumber = new AtomicInteger(9999); // Start from 9999
    private DBConn dbConn;

    // Constructor injection for the DBConn dependency
    public ClaimGeneration(DBConn dbConn) {
        this.dbConn = dbConn;
    }

    @PostMapping("/generateClaimNumber")
    public ClaimNumberResponse generateClaimNumber(@RequestParam String policyNumber) {
        String claimNumber = getNextClaimNumber();
        saveNextClaimNumber(claimNumber, policyNumber);

        System.out.println("Generated Claim Number: " + claimNumber);

        return new ClaimNumberResponse(claimNumber);
    }

    private String getNextClaimNumber() {
        // Increment the last claim number
        int nextClaimNumber = lastClaimNumber.incrementAndGet();
        // Extract the main part and sequence number
        int mainPart = 10000;
        int sequenceNumber = nextClaimNumber - 10000;
        // Format the claim number
        return String.format("%05d-%03d", mainPart, sequenceNumber);
    }

    private void saveNextClaimNumber(String nextClaimNumber, String policyNumber) {
        Connection con = null;
        try {
            // Get a connection to the database
            con = dbConn.getMyConnection();

            // Start a transaction
            con.setAutoCommit(false);

            // Prepare the update statement
            PreparedStatement ps = con.prepareStatement("UPDATE NXT_Master SET ClaimNumber = ? WHERE PolicyNumber = ?");
            ps.setString(1, nextClaimNumber);
            ps.setString(2, policyNumber);

            // Execute the update statement
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Claim number updated for policy number: " + policyNumber);
            } else {
                System.out.println("Failed to update claim number for policy number: " + policyNumber);
            }

            // Commit the transaction
            con.commit();
        } catch (SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in saveNextClaimNumber method: " + e);
            // Rollback the transaction if an exception occurs
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    System.out.println("Exception while rolling back transaction: " + ex);
                }
            }
        } finally {
            // Close the database connection
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Exception while closing connection: " + ex);
                }
            }
        }
    }



    // Response object to hold the claim number
    private static class ClaimNumberResponse {
        private String claimNumber;

        public ClaimNumberResponse(String claimNumber) {
            this.claimNumber = claimNumber;
        }

        public String getClaimNumber() {
            return claimNumber;
        }

        public void setClaimNumber(String claimNumber) {
            this.claimNumber = claimNumber;
        }
    }
}