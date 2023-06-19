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
public class DiaryDAO {
    private DBConn dbConn = new DBConn();
    public DiaryDAO() {
    }
    public Map<String, List<String>> getDiary() {
        Map<String, List<String>> typesMap = new HashMap<>();

        List<String> relatedTos = new ArrayList<>();
        List<String> assignees = new ArrayList<>();
        List<String> createdBy = new ArrayList<>();



        try {
            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement relatedto in dairy DAO");
            PreparedStatement ps = con.prepareStatement("SELECT Name from relatedto");
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String relatedTo = rs.getString("Name");
                relatedTos.add(relatedTo);
            }
            rs.close();
            //Assigned To, Created By,

            PreparedStatement ps1 = con.prepareStatement("SELECT value from assignedto");
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                String assignedTo = rs1.getString("value");
                assignees.add(assignedTo);
            }
            rs1.close();

            PreparedStatement ps2 = con.prepareStatement("SELECT value from createdby");
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                String createdby = rs2.getString("value");
                createdBy.add(createdby);
            }


            typesMap.put("relatedTos", relatedTos);
            typesMap.put("assignees", assignees);
            typesMap.put("createdBy", createdBy);
            System.out.println("Diary : - "+typesMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return typesMap;
    }
}
