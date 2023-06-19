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
public class LossDetailsDAO {
    private DBConn dbConn = new DBConn();
    public LossDetailsDAO() {
    }
    public Map<String, List<String>> getLossDetails() {
        Map<String, List<String>> typesMap = new HashMap<>();

        List<String> lossCauses = new ArrayList<>();
        List<String> typeOflosses = new ArrayList<>();
        List<String> Adjusters = new ArrayList<>();
        List<String> relationshipToinsureds = new ArrayList<>();

        try {
            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement loss cause");
            PreparedStatement ps = con.prepareStatement("SELECT name FROM losscause");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String lossCause = rs.getString("name");
                lossCauses.add(lossCause);
            }
            rs.close();
            //Type of Loss,Relationship to Insured,

            PreparedStatement ps1 = con.prepareStatement("SELECT TypeofLoss_Value FROM typeofloss");
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                String typeOfLosses = rs1.getString("TypeofLoss_Value");
                typeOflosses.add(typeOfLosses);
            }
            rs1.close();

            PreparedStatement ps2 = con.prepareStatement("SELECT RelationshipToInsured_Value FROM relationshiptoinsured");
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                String relationshipToInsureds = rs2.getString("RelationshipToInsured_Value");
                relationshipToinsureds.add(relationshipToInsureds);
            }
            rs2.close();

            PreparedStatement ps3 = con.prepareStatement("SELECT Adjuster_Value FROM adjuster");
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                String adjuster = rs3.getString("Adjuster_Value");
                Adjusters.add(adjuster);
            }
            rs3.close();

            typesMap.put("lossCauses", lossCauses);
            typesMap.put("typeOfLosses", typeOflosses);
            typesMap.put("relationshipToInsureds", relationshipToinsureds);
            typesMap.put("adjusters", Adjusters);
            System.out.println("loss details : - "+typesMap);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return typesMap;
    }
}
