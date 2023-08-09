package com.example.withoutdb.service;

import com.example.withoutdb.model.LossSummary;
import org.springframework.stereotype.Service;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class LossSummaryServiceImpl implements LossSummaryService {


    @Override
    public void saveLossSummary(LossSummary losssummary) {
        try {
            DateTimeUtil dateTimeUtil = new DateTimeUtil();

            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO losssummary (Adjuster, LossDescription, OtherDescription, typeofloss, LossCause, WeatherInvolved, WeatherDescription, DateofLoss, TimeofLoss, Reportedby, Relationshiptoinsured, Location, address1, address2, address3, countries, city, zipcode, state, jurisdiction) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//            System.out.println("adjuster"+ losssummary.getAdjuster());
//            System.out.println("description"+losssummary.getLossDescription());
//            System.out.println("losscause"+losssummary.getLossCause());
//            System.out.println("otherdes"+losssummary.getOtherDescription());
//            System.out.println("typeofloss"+losssummary.getTypeOfLoss());
//            System.out.println("weather"+losssummary.getWeatherInvolved());
//            System.out.println("weatherd"+losssummary.getWeatherDescription());
//            System.out.println( "location"+losssummary.getLocation());
//            System.out.println(  "address1"+ losssummary.getAddress1() );
//            System.out.println("address2"+ losssummary.getAddress2() );
//            System.out.println("address3"+ losssummary.getAddress3());
//            System.out.println("country"+losssummary.getCountry());
//            System.out.println("city"+losssummary.getCity());
//            System.out.println("state"+losssummary.getState());
//            System.out.println( "zip"+losssummary.getZipCode());
//            System.out.println("jud"+ losssummary.getJurisdiction());
//            System.out.println( "date"+losssummary.getDateOfLoss());
//            System.out.println( "relation"+losssummary.getRelationshipToInsured());
//            System.out.println("reportedby"+losssummary.getReportedBy());
//            System.out.println("time"+losssummary.getTimeOfLoss());

//Adjuster, LossDescription, OtherDescription, typeofloss, LossCause, WeatherInvolved, WeatherDescription, DateofLoss, TimeofLoss, Reportedby, Relationshiptoinsured,
// Location, address1, address2, address3, countries, city, zipcode, state, jurisdiction

            ps.setString(1, losssummary.getAdjuster());
            ps.setString(2, losssummary.getLossDescription());
            ps.setString(5, losssummary.getLossCause());
         //   ps.setString(3, losssummary.getOtherDescription());
            ps.setString(4, losssummary.getTypeOfLoss());
            ps.setString(6, losssummary.getWeatherInvolved());
            ps.setString(7, losssummary.getWeatherDescription()); // need check for the data tinyint
            ps.setDate(8, Date.valueOf(dateTimeUtil.toDate(losssummary.getDateOfLoss())));
            ps.setTime(9, Time.valueOf(dateTimeUtil.toTime(losssummary. getTimeOfLoss())));
            ps.setString(10,losssummary.getReportedBy());
            ps.setString(11,losssummary.getRelationshipToInsured());
            ps.setString(12, losssummary.getLocation());
            ps.setString(13, losssummary.getLossAddress());
            ps.setString(14, losssummary.getCountry());
            ps.setString(15, losssummary.getCity());
            ps.setString(16, losssummary.getState());
            ps.setString(17, losssummary.getZipCode());
            ps.setString(18, losssummary.getJurisdiction());

            ps.executeUpdate(); // Execute the insert statement

            System.out.println("Data inserted successfully");
        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in saveLossSummary method "+ e);

        }
    }


    @Override
    public List<LossSummary> getAlllosssummarys() {

        List<LossSummary> alllosssummarys = new ArrayList<LossSummary>();
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("select * from losssummary");
            ResultSet rs = ps.executeQuery();
            LossSummary x = null;
            while(rs.next())
            {
                x = new LossSummary();
                x.setAdjuster(rs.getString(1));
                x.setLossDescription(rs.getString(2));
                x.setLossCause(rs.getString(3));
              //  x.setOtherDescription(rs.getString(4));
                x.setTypeOfLoss(rs.getString(5));
                x.setWeatherInvolved(rs.getString(6));
                x.setWeatherDescription(rs.getString(7));
                //x.setDateOfLoss(rs.getDate(8));
                //   x.setTimeOfLoss(rs.getTime(9));
                x.setLocation(rs.getString(10));
              x.setLossAddress(rs.getString(11));
                x.setCountry(rs.getString(12));
                x.setCity(rs.getString(13));
                x.setState(rs.getString(14));
                //x.setZipCode(rs.getInt(17));
                x.setJurisdiction(rs.getString(16));

                alllosssummarys.add(x);
            }
            con.close();

        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in getlosssummarys method "+ e);

        }

        return alllosssummarys;
    }


}
