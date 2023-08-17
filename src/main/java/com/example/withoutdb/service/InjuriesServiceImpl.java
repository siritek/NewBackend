package com.example.withoutdb.service;

import com.example.withoutdb.model.Injuries;
import org.springframework.stereotype.Service;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
@Service
public class InjuriesServiceImpl implements InjuriesService {
    @Override
    public void saveInjuries(Injuries injuries) {
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO injuries(PolicyNumber, ClaimNumber, Name, Severity, Description) values(?,?,?,?,?)");
            System.out.println(injuries.getPolicyNumber() + " " + injuries.getClaimNumber() + " " + injuries.getName() + " " + injuries.getSeverity() + " " + injuries.getDescription());
            ps.setString(1, injuries.getPolicyNumber());
            ps.setString(2, injuries.getClaimNumber());
            ps.setString(3, injuries.getName());
            ps.setString(4, injuries.getSeverity());
            ps.setString(5, injuries.getDescription());

            ps.executeUpdate();

            System.out.println("Data inserted successfully");
        } catch (Exception e) {
            System.out.println("Exception in saveInjuries method " + e);
        }
    }

    @Override
    public List<Injuries> getAllInjuries() {
        List<Injuries> allInjuries = new ArrayList<Injuries>();
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM injuries");
            ResultSet rs = ps.executeQuery();
            Injuries x = null;

            while (rs.next()) {
                x = new Injuries();
                x.setPolicyNumber(rs.getString(1));
                x.setClaimNumber(rs.getString(2));
                x.setName(rs.getString(3));
                x.setSeverity(rs.getString(4));
                x.setDescription(rs.getString(5));

                allInjuries.add(x);
            }
            con.close();
        }
        catch (SQLException e) {
            System.out.println("Exception in getAllInjuries method " + e);
        }

        return allInjuries;
    }
}
