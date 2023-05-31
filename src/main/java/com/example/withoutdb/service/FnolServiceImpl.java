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

            ps.setInt(1, Integer.parseInt(fnol.getPolicyNumber()));



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

                x.setPolicyNumber(Integer.toString(rs.getInt(1)));

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
