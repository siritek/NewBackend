package com.example.withoutdb.service;

import com.example.withoutdb.model.PolicyLevelCoverage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
@Service
public class PolicyLevelCoverageServiceImpl implements PolicyLevelCoverageService
{
    @Override
    public void savePolicyLevelCoverage(PolicyLevelCoverage policyLevelCoverage)
    {
        try{
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO policylevelcoverage(PolicyNumber, Coverage_Type, Incident_Limits, Per_Person_Limit, ClaimNumber) values(?,?,?,?,?)");
            System.out.println(policyLevelCoverage.getPolicyNumber() + " " + policyLevelCoverage.getCoverage_Type() + " " + policyLevelCoverage.getIncident_Limit() + " " + policyLevelCoverage.getPer_Person_Limit() + " " + policyLevelCoverage.getClaimNumber());
            ps.setString(1, policyLevelCoverage.getPolicyNumber());
            ps.setString(2, policyLevelCoverage.getCoverage_Type());
            ps.setString(3, policyLevelCoverage.getIncident_Limit());
            ps.setString(4, policyLevelCoverage.getPer_Person_Limit());
            ps.setString(5, policyLevelCoverage.getClaimNumber());

            ps.executeUpdate();

            System.out.println("Data inserted successfully");
        }
        catch(Exception e){
            System.out.println("Exception in savePolicyLevelCoverage method " + e);
        }
    }




    @Override
    public List<PolicyLevelCoverage> getAllpolicyLevelCoverages() {
       List<PolicyLevelCoverage> allpolicyLevelCoverages = new ArrayList<PolicyLevelCoverage>();
       try{
           Connection con = DBConn.getMyConnection();
           PreparedStatement ps = con.prepareStatement("SELECT * FROM policylevelcoverage");
           ResultSet rs = ps.executeQuery();
           PolicyLevelCoverage x = null;

           while(rs.next()){
               x = new PolicyLevelCoverage();
               x.setPolicyNumber(rs.getString(1));
               x.setCoverage_Type(rs.getString(2));
               x.setIncident_Limit(rs.getString(3));
               x.setPer_Person_Limit(rs.getString(4));
               x.setClaimNumber(rs.getString(5));

               allpolicyLevelCoverages.add(x);
           }
           con.close();
       }
       catch (SQLException e){
           System.out.println("Exception in getAllPolicyLevelCoverages method " + e);
       }
       return allpolicyLevelCoverages;
    }
}
