package com.example.withoutdb.service;

import com.example.withoutdb.model.Diary;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class DiaryServiceImpl implements DiaryService {



    @Override
    public void saveDiary(Diary diary) {
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO diary (Subject, Description, RelatedTo, DueDate, Priority, Details, AssignedTo, CreatedBy, DateCreated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            System.out.println(diary.getSubject() + " " + diary.getDescription() + " " + diary.getRelatedTo() +" " + diary.getDueDate() +  " " + diary.getPriority() + " " + diary.getDetails() +  " " + diary.getAssignedTo() +  " " + diary.getCreatedBy() +  " " + diary.getDateCreated());
            ps.setString(1, diary.getSubject());
            ps.setString(2, diary.getDescription());
            ps.setString(3, diary.getRelatedTo());
            //ps.setDate(4, diary.getDueDate());
            ps.setString(4, diary.getPriority());
            ps.setString(5, diary.getDetails());
            ps.setString(6, diary.getAssignedTo());
            ps.setString(7, diary.getCreatedBy());
            //ps.setDate(9, diary.getDateCreated());



            ps.executeUpdate(); // Execute the insert statement

            System.out.println("Data inserted successfully");
        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in saveDiary method "+ e);

        }
    }


    @Override
    public List<Diary> getAlldiaries() {

        List<Diary> alldiaries = new ArrayList<Diary>();
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("select * from diary");
            ResultSet rs = ps.executeQuery();
            Diary x = null;
            while(rs.next())
            {
                x = new Diary();
                x.setSubject(rs.getString(1));
                x.setDescription(rs.getString(2));
                x.setRelatedTo(rs.getString(3));
                x.setDueDate(rs.getDate(4));
                x.setPriority(rs.getString(5));
                x.setDetails(rs.getString(6));
                x.setAssignedTo(rs.getString(7));
                x.setCreatedBy(rs.getString(8));
                x.setDateCreated(rs.getDate(9));
                alldiaries.add(x);
            }
            con.close();

        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in getDiary method "+ e);

        }

        return alldiaries;
    }


}
