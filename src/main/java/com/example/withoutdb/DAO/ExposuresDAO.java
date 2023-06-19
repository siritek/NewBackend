package com.example.withoutdb.DAO;

import com.example.withoutdb.service.DBConn;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExposuresDAO {

    public DBConn dbConn = new DBConn();
    public ExposuresDAO() {
    }

    public Map<String ,List<String>> getExposures() {
        Map<String, List<String>> typemaps = new HashMap<>();
        List<String> claimanttypes = new ArrayList<>();
        List<String> lossparties = new ArrayList<>();
        List<String> Adjusters = new ArrayList<>();
        List<String> primarycoverages = new ArrayList<>();
        List<String> ExposureStatus = new ArrayList<>();

        try{
// get claimant types from claimanttype table
            Connection connection = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement in exposuresDAO");
            PreparedStatement ps = connection.prepareStatement("SELECT ClaimantType_Value FROM claimanttype");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String claimantType = rs.getString("ClaimantType_Value");
                claimanttypes.add(claimantType);
            }
            rs.close();

            //get loss parties from lossparty table
            PreparedStatement ps1 = connection.prepareStatement("SELECT LossParty_Value FROM lossparty");
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                String lossParty = rs1.getString("LossParty_Value");
                lossparties.add(lossParty);
            }
            rs1.close();

            //get primary coverages from primarycoverage table
            PreparedStatement ps2 = connection.prepareStatement("SELECT PrimaryCoverage_Value FROM primarycoverage");
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                String primaryCoverage = rs2.getString("PrimaryCoverage_Value");
                primarycoverages.add(primaryCoverage);

            }
            rs2.close();
            PreparedStatement ps3 = connection.prepareStatement("SELECT Adjuster_Value FROM adjuster");
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                String adjuster = rs3.getString("Adjuster_Value");
                Adjusters.add(adjuster);
            }
            rs3.close();

            PreparedStatement ps4 = connection.prepareStatement("SELECT exposure_status_value FROM exposure_status");
            ResultSet rs4 = ps4.executeQuery();
            while (rs4.next()) {
                String exposureStatus = rs4.getString("exposure_status_value");
                ExposureStatus.add(exposureStatus);
            }


            typemaps.put("claimantType",claimanttypes);
            typemaps.put("lossParty",lossparties);
            typemaps.put("adjuster",Adjusters);
            typemaps.put("exposureStatus",ExposureStatus);
            typemaps.put("primaryCoverage",primarycoverages);
            System.out.println("exposures:- " +typemaps);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        return typemaps;
    }

}
