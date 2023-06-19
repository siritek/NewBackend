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
public class DocumentsDAO {
    private DBConn dbConn = new DBConn();
    public DocumentsDAO() {
    }
    public Map<String, List<String>> getDocuments() {
        Map<String, List<String>> typesMap = new HashMap<>();

        List<String> relatedTos = new ArrayList<>();
        List<String> statuses = new ArrayList<>();


        try {
            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement relatedto");
            /*PreparedStatement ps = con.prepareStatement("SELECT Name from relatedTo");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String relatedTo = rs.getString("Name");
                relatedTos.add(relatedTo);
            }
            rs.close();*/
            //Status,

            PreparedStatement ps1 = con.prepareStatement("SELECT Name from document_status");
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                String status = rs1.getString("Name");
                statuses.add(status);
            }
            rs1.close();


          //  typesMap.put("relatedTos", relatedTos);
            typesMap.put("statuses", statuses);
            System.out.println("documents : - "+typesMap);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return typesMap;
    }
}
