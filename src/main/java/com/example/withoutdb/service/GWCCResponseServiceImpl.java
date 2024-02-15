package com.example.withoutdb.service;

import com.example.withoutdb.model.GWCCResponse;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GWCCResponseServiceImpl implements GWCCResponseService {
    public boolean saveGWCCResponse(GWCCResponse gwccResponse) {
        System.out.println("Connection reached  GWCCResponse Service");

        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO GWCCResponsetable (BasepolicyNumber,BaseClaimNumber, GWCCClaimnumber ,response,createdDate,other) VALUES (?, ?, ?,?,?,?)");

            ps.setString(1, gwccResponse.getBasePolicyNumber());
            ps.setString(2, gwccResponse.getBaseClaimNumber());
            ps.setString(3, gwccResponse.getGwClaimnumber());
            //ps.setString(4, gwccResponse.getResponse());
            ps.setString(4,"testing it out no need of response");

            ps.setString(5, gwccResponse.getCreatedDate());
            //ps.setString(6, gwccResponse.getOther());
            ps.setString(6,"Success");

            System.out.println( "data is instered in GWCCResponse" );
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception in GWCCResponse service method "+ e);
            throw new RuntimeException(e);
        }
        return true;
    }
        @Override
    public List<GWCCResponse> getAllGWCCresponses() {
            List<GWCCResponse> allresponses = new ArrayList<GWCCResponse>();
            try {
                Connection con = DBConn.getMyConnection();
                PreparedStatement ps = con.prepareStatement("select * from GWCCResponsetable");
                ResultSet rs = ps.executeQuery();
                GWCCResponse x = null;
                while(rs.next())
                {
                    x = new GWCCResponse();
                    x.setBasePolicyNumber(rs.getString(1));
                    x.setBaseClaimNumber(rs.getString(2));
                    x.setGwClaimnumber(rs.getString(3));
                    x.setResponse(rs.getString(4));
                    x.setCreatedDate(rs.getString(5));
                    allresponses.add(x);
                }
                con.close();
            }
            catch(SQLException e) {
                System.out.println("Exception in get GWCCresponses  method "+ e);
            }
            return allresponses;
        }

}


