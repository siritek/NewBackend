package com.example.withoutdb.DAO;

import com.example.withoutdb.service.DBConn;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Service
public class CoverageTypeDAO {
    private DBConn dbConn = new DBConn();
    public CoverageTypeDAO() {
    }
    public List getCoverageTypes() {
        List<String> coverageTypes = new ArrayList<>();
        try {
            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement in coverageTypeDAO");
            PreparedStatement ps = con.prepareStatement("SELECT name FROM coveragetype");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String coverageType = rs.getString("name");
                coverageTypes.add(coverageType);
                System.out.println("coverage type are :- \t "+coverageType);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return coverageTypes;
    }
}
