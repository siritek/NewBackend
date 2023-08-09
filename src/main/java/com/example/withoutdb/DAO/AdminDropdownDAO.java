package com.example.withoutdb.DAO;

import com.example.withoutdb.service.DBConn;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminDropdownDAO {
    private DBConn dbConn = new DBConn();
    public AdminDropdownDAO() {
    }
    public static Map<String, List<String>> getAdminDropdownValues() {
        Map<String, List<String>> typesMap = new HashMap<>();
        List<String> Adjusters = new ArrayList<>();
        List<String> claimanttypes = new ArrayList<>();
        List<String> topics = new ArrayList<>();
        List<String> securityTypes = new ArrayList<>();
        List<String> relatedToValues = new ArrayList<>();
        List<String> states = new ArrayList<>();
        List<String> ExposureStatus = new ArrayList<>();
        List<String> AssignedTo = new ArrayList<>();
        List<String> CreatedBy = new ArrayList<>();
        List<String> relationshiptoinsured = new ArrayList<>();


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

            //get relationshiptoinsured values from relationshiptoinsured table
            PreparedStatement ps8 = connection.prepareStatement("SELECT RelationshiptoInsured_Value FROM relationshiptoinsured");
            ResultSet rs8 = ps8.executeQuery();
            while (rs8.next()) {
                String relationValue = rs8.getString("RelationshiptoInsured_Value");
                relationshiptoinsured.add(relationValue);
            }
            rs8.close();
            typesMap.put("relationshiptoinsured", relationshiptoinsured);

            //get topics from topic table
            PreparedStatement ps9 = connection.prepareStatement("SELECT Name FROM topic");
            ResultSet rs9 = ps9.executeQuery();
            while (rs9.next()) {
                String topicName = rs9.getString("Name");
                topics.add(topicName);
            }
            rs9.close();
            typesMap.put("topic", topics);

            //get security types from securitytype table
            PreparedStatement ps10 = connection.prepareStatement("SELECT Name FROM securitytype");
            ResultSet rs10 = ps10.executeQuery();
            while (rs10.next()) {
                String securityTypeName = rs10.getString("Name");
                securityTypes.add(securityTypeName);
            }
            rs10.close();
            typesMap.put("securityType", securityTypes);

            PreparedStatement ps5 = connection.prepareStatement("SELECT State FROM state");
            ResultSet rs5 = ps5.executeQuery();
            while (rs5.next()) {
                String stateValue = rs5.getString("State");
                states.add(stateValue);
            }
            rs5.close();
            // List<String> states;
            typesMap.put("state", states);


            //get relatedto values from relatedto table
            PreparedStatement ps11 = connection.prepareStatement("SELECT Name FROM relatedto");
            ResultSet rs11 = ps11.executeQuery();
            while (rs11.next()) {
                String relatedToName = rs11.getString("Name");
                relatedToValues.add(relatedToName);
            }
            rs11.close();
            typesMap.put("relatedTo", relatedToValues);


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
            typesMap.put("exposureStatus", ExposureStatus);

            //get assignedto values from assignedto table
            List<String> assignedToValues = new ArrayList<>();
            PreparedStatement ps13 = connection.prepareStatement("SELECT value FROM assignedto");
            ResultSet rs13 = ps13.executeQuery();
            while (rs13.next()) {
                String assignedToValue = rs13.getString("value");
                assignedToValues.add(assignedToValue);
            }
            rs13.close();


//        try {
//            Connection con = DBConn.getMyConnection();
//            System.out.println("Connection reached prepareStatement");
//            PreparedStatement ps = con.prepareStatement("SELECT PolicyStatus_Value FROM policystatus");
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                String adjusters = rs.getString("PolicyStatus_Value");
//                adjuster.add(adjusters);
//                System.out.println(adjusters);
//            }
//            rs.close();
//
//            PreparedStatement ps1 = con.prepareStatement("SELECT Name FROM topic");
//            ResultSet rs1 = ps1.executeQuery();
//
//            while (rs1.next()) {
//                String topics = rs1.getString("Name");
//                Topic.add(topics);
//                System.out.println(topics);
//            }
//            rs1.close();
//
//            PreparedStatement ps2 = con.prepareStatement("SELECT Name FROM securitytype");
//            ResultSet rs2 = ps2.executeQuery();
//
//            while (rs2.next()) {
//                String securityTypes = rs2.getString("Name");
//                SecurityType.add(securityTypes);
//                System.out.println(securityTypes);
//            }
//            rs2.close();

            //typesMap.put("policyStatus", policyStatuss);
            typesMap.put("state", states);
            typesMap.put("adjuster", Adjusters);
            typesMap.put("topic", topics);
            typesMap.put("securityType", securityTypes);
            typesMap.put("relatedTo", relatedToValues);
            typesMap.put("status", ExposureStatus);
            typesMap.put("assignedTo", assignedToValues);
            typesMap.put("createdBy", CreatedBy);
            typesMap.put("relationshiptoinsured", relationshiptoinsured);



//            typesMap.put("adjuster", adjuster);
//            typesMap.put("Topic", Topic);
//            typesMap.put("SecurityType", SecurityType);
//            typesMap.put("RelatedTo", RelatedTo);
//            typesMap.put("Status", Status);
//            typesMap.put("AssignedTo", AssignedTo);
//            typesMap.put("CreatedBy", CreatedBy);
//            typesMap.put("Relationshiptoinsured", Relationshiptoinsured);
            System.out.println("Admin screen dropdowns "+typesMap);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return typesMap; }
}
