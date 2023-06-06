package com.example.withoutdb.service;

import com.example.withoutdb.model.Exposure;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExposureServiceImpl implements ExposureService {

    @Override
    public void saveExposure(Exposure exposure) {
        try {
            DateTimeUtil dateTimeUtil = new DateTimeUtil();
            Connection con = DBConn.getMyConnection();
           PreparedStatement ps = con.prepareStatement("INSERT INTO exposures(lossparty , primarycoverage, Adjuster, ExposuresStatus, CreationDate, Claimant, ClaimantType, Phone, Address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
//    //       System.out.println(exposure.getLossParty() + " " + exposure.getPrimaryCoverage()+ " " + exposure.getAdjuster() +" " + exposure.getStatus() +  " " + exposure.getStatus() +  " " + exposure.getClaimant() +  " " + exposure.getClaimantType() +  " " + exposure.getPrimaryPhone() +  " " + exposure.getAddress() );
//            ps.setString(1, exposure.getLossParty());
//            ps.setString(2, exposure.getPrimaryCoverage());
//            ps.setString(3, exposure.getAdjuster());
//            ps.setString(4, exposure.getStatus());
//            ps.setDate(5, Date.valueOf(dateTimeUtil.toDate(exposure.getCreationDate())));
//            ps.setString(6, exposure.getClaimant());
//            ps.setString(7, exposure.getClaimantType());
//            ps.setString(8, exposure.getPrimaryPhone());
//            ps.setString(9, exposure.getAddress());
//

            ps.executeUpdate(); // Execute the insert statement

            System.out.println("Data inserted successfully");
        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in saveExposure method "+ e);

        }
    }


    @Override
    public List<Exposure> getAllexposures() {

        List<Exposure> allexposures = new ArrayList<Exposure>();
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("select * from exposure");
            ResultSet rs = ps.executeQuery();
            Exposure x = null;
            while(rs.next())
            {
                x = new Exposure();
              //  x.setLossparty(rs.getString(1));
             //   x.setPrimarycoverage(rs.getString(2));
                x.setAdjuster(rs.getString(3));
                x.setStatus(rs.getString(4));
              //  x.setCreationdate(rs.getDate(5));
                x.setClaimant(rs.getString(6));
             //   x.setClaimanttype(rs.getString(7));
             //   x.setPrimaryphone(rs.getString(8));
                x.setAddress(rs.getString(9));
                allexposures.add(x);
            }
            con.close();

        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in getExposure method "+ e);

        }

        return allexposures;
    }



}
