package com.example.withoutdb.service;

import com.example.withoutdb.model.LossSummary;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LossSummaryServiceImpl implements LossSummaryService {


    @Override
    public void saveLossSummary(LossSummary losssummary) {
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO losssummary (Adjuster ,LossDescription, LossCause,OtherDescription,TypeOfLoss, WeatherInvolved, WeatherDescription,Location, Address1,Address2, Address3,Country,City,State,ZipCode,Jurisdiction,DateOfLoss,TimeOfLoss) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?)");
            System.out.println(losssummary.getAdjuster() + " " + losssummary.getLossDescription() + " " + losssummary.getLossCause() +" " + losssummary.getOtherDescription() +  " " + losssummary.getTypeOfLoss() +  " " + losssummary.getWeatherInvolved()+  " " + losssummary.getWeatherDescription()+  " " + losssummary.getLocation()+  " " + losssummary.getAddress1() +  " " + losssummary.getAddress2()
                    +  " " + losssummary.getAddress3()+  " " + losssummary.getCountry()+  " " + losssummary.getCity()+  " " + losssummary.getState()+  " " + losssummary.getZipCode()+  " " + losssummary.getJurisdiction()+  " " + losssummary.getDateOfLoss()+  " " + losssummary.getTimeOfLoss());
            ps.setString(1, losssummary.getAdjuster());
            ps.setString(2, losssummary.getLossDescription());
            ps.setString(3, losssummary.getLossCause());
            ps.setString(4, losssummary.getOtherDescription());
            ps.setString(5, losssummary.getTypeOfLoss());
            ps.setString(6, losssummary.getWeatherInvolved());
            ps.setString(7, losssummary.getWeatherDescription());
            java.sql.Date dateofloss = new java.sql.Date(losssummary.getDateOfLoss().getTime());
            ps.setDate(8,dateofloss);
            ps.setTime(9, losssummary.getTimeOfLoss());
            ps.setString(10, losssummary.getLocation());
            ps.setString(11, losssummary.getAddress1());
            ps.setString(12, losssummary.getAddress2());
            ps.setString(13, losssummary.getAddress3());
            ps.setString(14, losssummary.getCountry());
            ps.setString(15, losssummary.getCity());
            ps.setString(16, losssummary.getState());
            ps.setInt(17, losssummary.getZipCode());
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
                x.setOtherDescription(rs.getString(4));
                x.setTypeOfLoss(rs.getString(5));
                x.setWeatherInvolved(rs.getString(6));
                x.setWeatherDescription(rs.getString(7));
                x.setDateOfLoss(rs.getDate(8));
                x.setTimeOfLoss(rs.getTime(9));
                x.setLocation(rs.getString(10));
                x.setAddress1(rs.getString(11));
                x.setAddress2(rs.getString(12));
                x.setAddress3(rs.getString(13));
                x.setCountry(rs.getString(14));
                x.setCity(rs.getString(15));
                x.setState(rs.getString(16));
                x.setZipCode(rs.getInt(17));
                x.setJurisdiction(rs.getString(18));

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
