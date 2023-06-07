package com.example.withoutdb.DAO;

import com.example.withoutdb.service.DBConn;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Service
public class LossPartyDAO {
    private DBConn dbConn = new DBConn();
    public LossPartyDAO() {
    }
    public List getlossParties () {
        List<String> lossParties = new ArrayList<>();
        try {
            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached prepareStatement");
            PreparedStatement ps = con.prepareStatement("SELECT LossParty_Value FROM lossparty");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String lossParty = rs.getString("LossParty_Value");
                lossParties.add(lossParty);
                System.out.println(lossParty);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lossParties;
    }

}