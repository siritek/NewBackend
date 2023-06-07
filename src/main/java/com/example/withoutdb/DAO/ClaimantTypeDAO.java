package com.example.withoutdb.DAO;

import com.example.withoutdb.service.DBConn;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Service
public class ClaimantTypeDAO {
    private DBConn dbConn = new DBConn();
    public ClaimantTypeDAO() {
    }
    public List getClaimantTypes() {
        List<String> claimantTypes = new ArrayList<>();
        try {
            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement");
            PreparedStatement ps = con.prepareStatement("SELECT ClaimantType_Value FROM claimanttype");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String claimantType = rs.getString("ClaimantType_Value");
                claimantTypes.add(claimantType);
                System.out.println(claimantType);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return claimantTypes;
    }
}
