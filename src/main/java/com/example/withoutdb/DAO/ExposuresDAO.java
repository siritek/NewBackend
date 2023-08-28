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
        List<String>states = new ArrayList<>();
        List<String> relationshiptoinsured = new ArrayList<>();
        List<String> topics = new ArrayList<>();
        List<String> securityTypes = new ArrayList<>();
        List<String> relatedToValues = new ArrayList<>();

        try{
// get claimant types from claimanttype table
            Connection connection = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement in exposuresDAO");
            PreparedStatement ps = connection.prepareStatement("SELECT id, type FROM type");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String claimantType = rs.getString("type");
                claimanttypes.add(claimantType);
            }
            rs.close();

            //get relationshiptoinsured values from relationshiptoinsured table
            PreparedStatement ps8 = connection.prepareStatement("SELECT RelationshiptoInsured_Value FROM relationshiptoinsured");
            ResultSet rs8 = ps8.executeQuery();
            while (rs8.next()) {
                String relationValue = rs8.getString("RelationshiptoInsured_Value");
                relationshiptoinsured.add(relationValue);
            }
            rs8.close();
            typemaps.put("relationshiptoinsured", relationshiptoinsured);

            //get topics from topic table
            PreparedStatement ps9 = connection.prepareStatement("SELECT Name FROM topic");
            ResultSet rs9 = ps9.executeQuery();
            while (rs9.next()) {
                String topicName = rs9.getString("Name");
                topics.add(topicName);
            }
            rs9.close();
            typemaps.put("topic", topics);

            //get security types from securitytype table
            PreparedStatement ps10 = connection.prepareStatement("SELECT Name FROM securitytype");
            ResultSet rs10 = ps10.executeQuery();
            while (rs10.next()) {
                String securityTypeName = rs10.getString("Name");
                securityTypes.add(securityTypeName);
            }
            rs10.close();
            typemaps.put("securityType", securityTypes);

            PreparedStatement ps5 = connection.prepareStatement("SELECT State FROM state");
            ResultSet rs5 = ps5.executeQuery();
            while (rs5.next()) {
                String stateValue = rs5.getString("State");
                states.add(stateValue);
            }
            rs5.close();
           // List<String> states;
            typemaps.put("state", states);


            //get relatedto values from relatedto table
            PreparedStatement ps11 = connection.prepareStatement("SELECT Name FROM relatedto");
            ResultSet rs11 = ps11.executeQuery();
            while (rs11.next()) {
                String relatedToName = rs11.getString("Name");
                relatedToValues.add(relatedToName);
            }
            rs11.close();
            typemaps.put("relatedTo", relatedToValues);


            //get loss parties from lossparty table
            PreparedStatement ps1 = connection.prepareStatement("SELECT id, type FROM lossparty");
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                String lossParty = rs1.getString("type");
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
            rs4.close();
            typemaps.put("exposureStatus", ExposureStatus);

            //get assignedto values from assignedto table
            List<String> assignedToValues = new ArrayList<>();
            PreparedStatement ps13 = connection.prepareStatement("SELECT value FROM assignedto");
            ResultSet rs13 = ps13.executeQuery();
            while (rs13.next()) {
                String assignedToValue = rs13.getString("value");
                assignedToValues.add(assignedToValue);
            }
            rs13.close();
            typemaps.put("assignedto", assignedToValues);


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
