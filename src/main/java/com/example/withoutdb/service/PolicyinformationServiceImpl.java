package com.example.withoutdb.service;

import com.example.withoutdb.model.Policyinformation;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


@Service
public class PolicyinformationServiceImpl  implements PolicyinformationService {
    @Override
    public void savePolicyinformation(Policyinformation policyinformation) {
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO policy_information (PolicyNumber,PolicyVerifed,DateofLoss,TimeofLoss,underwrittingCompany,EffectiveDate,ExpiriationDate,OriginalEffectiveDate,InsuredName,InsuredAddress,PolicyStatus,PolicyType) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            System.out.println(policyinformation.getPolicyStatus()+" "+policyinformation.getPolicyType()+" "+policyinformation.getPolicyNumber()+" "+policyinformation.getUnderWriteCompany()+" "+policyinformation.getAddress()+" "+policyinformation.getName()+" "+policyinformation.getTimeOfLoss()+" "+policyinformation.getOriginalEffectiveDate()+" "+policyinformation.getCancellationDate());


            ps.setInt(1, policyinformation.getPolicyNumber());
            ps.setString(2,policyinformation.getPolicyVerified());
            java.sql.Date dateofloss = new java.sql.Date(policyinformation.getDateOfLoss().getTime());
            ps.setDate(3, dateofloss);
            ps.setTime(4, policyinformation.getTimeOfLoss());
            ps.setString(5, policyinformation.getUnderWriteCompany());
            java.sql.Date effectiveDate = new java.sql.Date(policyinformation.getEffectiveDate().getTime());
            ps.setDate(6, effectiveDate);
            java.sql.Date expirationDate = new java.sql.Date(policyinformation.getExpirationDate().getTime());
            ps.setDate(7, expirationDate);
            java.sql.Date cancellationDate = new java.sql.Date(policyinformation.getCancellationDate().getTime());
            ps.setDate(8, cancellationDate);
            java.sql.Date originalEffectiveDate = new java.sql.Date(policyinformation.getOriginalEffectiveDate().getTime());
            ps.setDate(9, originalEffectiveDate);
            ps.setString(10, policyinformation.getName());
            ps.setString(11, policyinformation.getAddress());
            ps.setString(12, policyinformation.getPolicyStatus());
            ps.setString(13, policyinformation.getPolicyType());


            ps.executeUpdate();
            System.out.println("Data inserted successfully");
        }
        catch (Exception e) {
            // Handle exceptions appropriately
            System.out.println("Exception in savePolicyinformation method " + e);

        }
    }







    @Override
    public List<Policyinformation> getAllpolicyinformations(){
        List<Policyinformation> allpolicyinformations = new ArrayList<Policyinformation>();

        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("select * from poilcyinformation");
            ResultSet rs = ps.executeQuery();
            Policyinformation x = null;
            while(rs.next())
            {
                x = new Policyinformation();
                x.setPolicyNumber(rs.getInt(1));
                x.setPolicyVerified(rs.getString(2));
                x.setDateOfLoss(rs.getDate(3));
                x.setTimeOfLoss(rs.getTime(4));
                x.setUnderWriteCompany(rs.getString(5));
                x.setEffectiveDate(rs.getDate(6));
                x.setExpirationDate(rs.getDate(7));
                x.setCancellationDate(rs.getDate(8));
                x.setOriginalEffectiveDate(rs.getDate(9));
                x.setName(rs.getString(10));
                x.setAddress(rs.getString(11));
                x.setPolicyStatus(rs.getString(12));
                x.setPolicyType(rs.getString(13));

                allpolicyinformations.add(x);
            }

            con.close();

        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in getPolicyinformation method "+ e);

        }

        return getAllpolicyinformations();
    }
}
