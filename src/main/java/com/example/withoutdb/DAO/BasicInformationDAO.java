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
public class BasicInformationDAO {
    private DBConn dbConn = new DBConn();
    public BasicInformationDAO() {
    }
    public Map<String, List<String>> getBasicInformation() {
        Map<String, List<String>> typesMap = new HashMap<>();

        List<String> policyTypes = new ArrayList<>();
        List<String> policyStatus = new ArrayList<>();


        try {
            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement in policetypeDAO");
            PreparedStatement ps = con.prepareStatement("SELECT PolicyType_Value FROM policytype");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String policyType = rs.getString("PolicyType_Value");
                policyTypes.add(policyType);
            }
            rs.close();
            //Status,


                PreparedStatement ps1 = con.prepareStatement("SELECT PolicyStatus_Value FROM policystatus");
                ResultSet rs1 = ps1.executeQuery();

                while (rs1.next()) {
                    String Status = rs1.getString("PolicyStatus_Value");
                    policyStatus.add(Status);
                    System.out.println(Status);
                }
            rs1.close();


            typesMap.put("policyTypes", policyTypes);
            typesMap.put("policyStatuses", policyStatus);
            System.out.println("BAsic info  : - "+typesMap);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return typesMap;
    }
}
