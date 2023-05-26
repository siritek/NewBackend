package com.example.withoutdb.service;

import com.example.withoutdb.model.Fnol;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

@Service
public class FnolServiceImpl implements FnolService {



    @Override

    public void saveFnol(Fnol fnol) {
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO fnol (PolicyNumber,DateofLoss, LossLocation, TimeofLoss, LossDescription, Reportedby, DateReporetd) VALUES (?, ?, ?, ?, ?,?,?)");
            System.out.println(fnol.getLosslocation() + " " + fnol.getTimeofloss() +" " + fnol.getReportedby() +  " " + fnol.getPolicynumber() +" "+fnol.getLossdate() );

            ps.setInt(1, fnol.getPolicynumber());
            java.sql.Date dateofloss = new java.sql.Date(fnol.getLossdate().getTime());
            ps.setDate(2,  dateofloss);
            ps.setString(3, fnol.getLosslocation());
            ps.setTime(4, fnol.getTimeofloss());
            ps.setString(5,fnol.getLossdescription());
            ps.setString(6, fnol.getReportedby());
            java.sql.Date reportedby = new java.sql.Date(fnol.getDatereported().getTime());
            ps.setDate(7,reportedby);


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

                x.setPolicynumber(rs.getInt(1));
                x.setLossdate(rs.getDate(2));
                x.setLosslocation(rs.getString(3));
                x.setTimeofloss(rs.getTime(4));
                x.setLossdescription(rs.getString(5));
                x.setReportedby(rs.getString(6));
                x.setDatereported(rs.getDate(7));

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
