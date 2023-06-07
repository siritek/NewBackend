package com.example.withoutdb.DAO;

import com.example.withoutdb.service.DBConn;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Service
public class PolicyStatusDAO {
    private DBConn dbConn = new DBConn();
    public PolicyStatusDAO() {
    }
    public List getPolicyStatus() {
        List<String> policyStatuss = new ArrayList<>();
        try {
            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement");
            PreparedStatement ps = con.prepareStatement("SELECT PolicyStatus_Value FROM policystatus");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String policyStatus = rs.getString("PolicyStatus_Value");
                policyStatuss.add(policyStatus);
                System.out.println(policyStatus);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return policyStatuss;
    }
}
