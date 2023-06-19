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

            DateTimeUtil dateTimeUtil = new DateTimeUtil();

//            System.out.println(fnol.getPolicyNumber());
//            System.out.println(fnol.getDateOfLoss());
//            System.out.println(fnol.getLossLocation());
//            System.out.println(fnol.getLossTime());
//            System.out.println(fnol.getReportedBy());
//            System.out.println(fnol.getDateOfReport());

            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO fnol (PolicyNumber,DateofLoss, LossLocation, TimeofLoss,  Reportedby, DateReporetd) VALUES (?, ?, ?, ?, ?,?)");

            ps.setInt(1, Integer.parseInt(fnol.getPolicyNumber()));
            ps.setDate(2, Date.valueOf(dateTimeUtil.toDate(fnol.getDateOfLoss())));
            ps.setString(3,fnol.getLossLocation());
            ps.setTime(4, Time.valueOf(dateTimeUtil.toTime(fnol.getLossTime())));
            ps.setString(5,fnol.getReportedBy());
            ps.setDate(6, Date.valueOf(dateTimeUtil.toDate(fnol.getDateOfReport())));


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




//            String dateString = "2023-06-01";
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            LocalDate date = LocalDate.parse(dateString, formatter);
//            System.out.println(date);
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//            LocalTime time = LocalTime.parse(timeString, formatter);
//            System.out.println(time);
