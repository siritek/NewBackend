package com.example.withoutdb.service;

import com.example.withoutdb.model.Fnol;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class FnolServiceImpl implements FnolService {



    @Override
    public void saveFnol(Fnol fnol) {
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO fnol (claimnumber , losslocation, timeofloss, reportedby, policynumber) VALUES (?, ?, ?, ?, ?)");
            System.out.println(fnol.getClaimnumber() + " " + fnol.getLosslocation() + " " + fnol.getTimeofloss() +" " + fnol.getReportedby() +  " " + fnol.getPolicynumber() );
            ps.setInt(1, fnol.getClaimnumber());
           // ps.setDate(2, fnol.getLossdate());
            ps.setString(2, fnol.getLosslocation());
            ps.setString(3, fnol.getTimeofloss());
            ps.setString(4, fnol.getReportedby());
           // ps.setDate(2, fnol.getDatereported());
            ps.setString(5, fnol.getPolicynumber());


            ps.executeUpdate(); // Execute the insert statement

            System.out.println("Data inserted successfully");
        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in saveFnol method "+ e);

        }
    }


    @Override
    public List<Fnol> getAllfnols() {

        List<Fnol> allfnols = new ArrayList<Fnol>();
        try {
        Connection con = DBConn.getMyConnection();
        PreparedStatement ps = con.prepareStatement("select * from fnol");
        ResultSet rs = ps.executeQuery();
        Fnol x = null;
        while(rs.next())
        {
            x = new Fnol();
            x.setClaimnumber(rs.getInt(1));
            x.setLosslocation(rs.getString(2));
            x.setTimeofloss(rs.getString(3));
            x.setReportedby(rs.getString(4));
            x.setPolicynumber(rs.getString(5));
            allfnols.add(x);
        }
        con.close();

    }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in getFnol method "+ e);

        }

        return allfnols;
}


}
