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
public class NewNoteDAO {
    private DBConn dbConn = new DBConn();
    public NewNoteDAO() {
    }
    public Map<String, List<String>> getNewNote() {
        Map<String, List<String>> typesMap = new HashMap<>();

        List<String> topics = new ArrayList<>();
        List<String> securityTypes = new ArrayList<>();
        List<String> relatedTos = new ArrayList<>();

        try {
            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement new note topic");
            PreparedStatement ps = con.prepareStatement("SELECT Name from topic");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String topic = rs.getString("Name");
                topics.add(topic);
            }
            rs.close();
            //Security Type, Related To,

            PreparedStatement ps1 = con.prepareStatement("SELECT Name from securitytype");
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                String securityType = rs1.getString("Name");
                securityTypes.add(securityType);
            }
            rs1.close();
            /*PreparedStatement ps2 = con.prepareStatement("SELECT RelatedTo from relatedto");
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                String relatedTo = rs2.getString("RelatedTo");
                relatedTos.add(relatedTo);
            }*/
            typesMap.put("topics", topics);
            typesMap.put("securityTypes", securityTypes);
            //typesMap.put("relatedTos", relatedTos);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return typesMap;
    }
}
