package com.example.withoutdb.DAO;

import com.example.withoutdb.service.DBConn;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Service
public class PolicyTypeDAO {
    private DBConn dbConn = new DBConn();
    public PolicyTypeDAO() {
    }
    public List getPolicyTypes() {
        List<String> policyTypes = new ArrayList<>();
        try {
            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement in policetypeDAO");
            PreparedStatement ps = con.prepareStatement("SELECT PolicyType_Value FROM policytype");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String policyType = rs.getString("PolicyType_Value");
                policyTypes.add(policyType);
                //System.out.println(policyType);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return policyTypes;
    }
}
