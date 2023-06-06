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
            DateTimeUtil dateTimeUtil = new DateTimeUtil();
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO policy_information (PolicyNumber,PolicyVerifed,DateofLoss,TimeofLoss,underwrittingCompany,EffectiveDate,ExpiriationDate,OriginalEffectiveDate,PolicyStatus,PolicyType,Name,Address) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
//            System.out.println(policyinformation.getPolicyStatus()+" "+policyinformation.getPolicyType()+" "+policyinformation.getPolicyNumber()+" "+policyinformation.getUnderWriteCompany()+" "+policyinformation.getAddress()+" "+policyinformation.getName()+" "+policyinformation.getTimeOfLoss()+" "+policyinformation.getOriginalEffectiveDate()+" "+policyinformation.getCancellationDate());


//            ps.setInt(1, Integer.parseInt(policyinformation.getPolicyNumber()));
//            ps.setString(2,policyinformation.getPolicyVerified());  // need check for the data tinyint
//            ps.setDate(3, Date.valueOf(dateTimeUtil.toDate(policyinformation.getDateOfLoss())));
//            ps.setTime(4, Time.valueOf(dateTimeUtil.toTime(policyinformation.getLossTime())));
//            ps.setString(5,policyinformation.getUnderwriting());
//            ps.setDate(6, Date.valueOf(dateTimeUtil.toDate(policyinformation.getEffectiveDate())));
//            ps.setDate(7, Date.valueOf(dateTimeUtil.toDate(policyinformation.getExpirationDate())));
//            ps.setDate(8, Date.valueOf(dateTimeUtil.toDate(policyinformation.getOriginalEffectiveDate())));
//            ps.setString(9,policyinformation.getName());
//            ps.setString(10,policyinformation.getAddress());
//            ps.setString(11,policyinformation.getPolicyStatus());
//            ps.setString(12,policyinformation.getPolicyType());

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
//                x.setPolicyNumber(rs.getInt(1));
//                x.setPolicyVerified(rs.getString(2));
//                x.setDateOfLoss(rs.getDate(3));
//                x.setTimeOfLoss(rs.getTime(4));
//                x.setUnderWriteCompany(rs.getString(5));
//                x.setEffectiveDate(rs.getDate(6));
//                x.setExpirationDate(rs.getDate(7));
//                x.setCancellationDate(rs.getDate(8));
//                x.setOriginalEffectiveDate(rs.getDate(9));
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
