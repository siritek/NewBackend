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
public class NewDocumentDAO {
    private DBConn dbConn = new DBConn();
    public NewDocumentDAO() {
    }
    public Map<String, List<String>> getNewDocument() {
        Map<String, List<String>> typesMap = new HashMap<>();

        List<String> documentTypes = new ArrayList<>();
        List<String> relatedTos = new ArrayList<>();
        List<String> statuses = new ArrayList<>();


        try {
            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement documentType");
            PreparedStatement ps = con.prepareStatement("SELECT Name FROM document_type");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String documentType = rs.getString("Name");
                documentTypes.add(documentType);
            }
            rs.close();

           PreparedStatement ps1 = con.prepareStatement("SELECT Name from relatedto");
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                String relatedTo = rs1.getString("Name");
                relatedTos.add(relatedTo);
            }
            rs1.close();

            PreparedStatement ps2 = con.prepareStatement("SELECT Name from document_status");
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                String status = rs2.getString("Name");
                statuses.add(status);
            }
            rs2.close();

            typesMap.put("documentTypes", documentTypes);
           typesMap.put("relatedTos", relatedTos);
            typesMap.put("statuses", statuses);
            System.out.println(typesMap);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return typesMap;
    }
}
