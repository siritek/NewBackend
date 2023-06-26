package com.example.withoutdb.controller;

import com.example.withoutdb.model.SearchData;
import com.example.withoutdb.service.DBConn;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/claim")
public class SearchScreen {

    private final DBConn dbConn;

    public SearchScreen(DBConn dbConn) {
        this.dbConn = dbConn;
    }

    @PostMapping("/search")
    public List<SearchData> searchClaims(@RequestBody SearchData searchData) {
        List<SearchData> searchDataResultList = new ArrayList<>();

        try {
            Connection conn = dbConn.getMyConnection();
            PreparedStatement statement = prepareStatement(searchData, conn);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                SearchData searchDataResult = new SearchData();
                searchDataResult.setClaimNumber(rs.getString("ClaimNumber"));
                searchDataResult.setPolicyNumber(rs.getString("PolicyNumber"));
                searchDataResult.setInsuredName(rs.getString("Name"));
                searchDataResult.setAdjuster(rs.getString("Adjuster"));
                searchDataResult.setDateOfLoss(rs.getDate("DateofLoss"));
                searchDataResult.setPolicyStatus(rs.getString("PolicyStatus"));

                searchDataResultList.add(searchDataResult);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Exception in searchClaims method: " + e);
        }
        System.out.println("added in searchDataResult method: " + searchDataResultList );
        return searchDataResultList;
    }


    private PreparedStatement prepareStatement(SearchData searchData, Connection conn) throws SQLException {
        String query = "SELECT ClaimNumber, Name, PolicyNumber, Claimant, DateofLoss, Adjuster, PolicyStatus FROM NXT_Master WHERE 1 = 1";

        if (searchData.getClaimNumber() != null && !searchData.getClaimNumber().isEmpty()) {
            query += " AND ClaimNumber = ? ";
        }

        if (searchData.getPolicyNumber() != null && !searchData.getPolicyNumber().isEmpty()) {
            query += " AND PolicyNumber = ? ";
        }

        if (searchData.getInsuredName() != null && !searchData.getInsuredName().isEmpty()) {
            query += " AND Name = ? ";
        }

        if (searchData.getClaimantName() != null && !searchData.getClaimantName().isEmpty()) {
            query += " AND Claimant = ? ";
        }

        PreparedStatement statement = conn.prepareStatement(query);
        int parameterIndex = 1;

        if (searchData.getClaimNumber() != null && !searchData.getClaimNumber().isEmpty()) {
            statement.setString(parameterIndex++, searchData.getClaimNumber());
        }

        if (searchData.getPolicyNumber() != null && !searchData.getPolicyNumber().isEmpty()) {
            statement.setString(parameterIndex++, searchData.getPolicyNumber());
        }

        if (searchData.getInsuredName() != null && !searchData.getInsuredName().isEmpty()) {
            statement.setString(parameterIndex++, searchData.getInsuredName());
        }

        if (searchData.getClaimantName() != null && !searchData.getClaimantName().isEmpty()) {
            statement.setString(parameterIndex, searchData.getClaimantName());
        }

        return statement;
    }

    @GetMapping
    public List<SearchData> getAllClaims() {
        List<SearchData> searchDataList = new ArrayList<>();

        try {
            Connection conn = dbConn.getMyConnection();
            System.out.println(" connection reached gellallclaims method" );
            PreparedStatement statement = conn.prepareStatement("SELECT ClaimNumber, Name, PolicyNumber, Claimant, DateofLoss, Adjuster, PolicyStatus FROM NXT_Master");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                SearchData searchData = new SearchData();
                searchData.setClaimNumber(rs.getString("ClaimNumber"));
                searchData.setPolicyNumber(rs.getString("PolicyNumber"));
                searchData.setInsuredName(rs.getString("Name"));
                searchData.setAdjuster(rs.getString("Adjuster"));
                searchData.setDateOfLoss(rs.getDate("DateofLoss"));
                searchData.setPolicyStatus(rs.getString("PolicyStatus"));
                searchDataList.add(searchData);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Exception in getAllClaims method: " + e);
        }

        return searchDataList;
    }
}  