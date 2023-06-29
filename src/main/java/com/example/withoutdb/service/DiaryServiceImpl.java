package com.example.withoutdb.service;

import com.example.withoutdb.model.Diary;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {



    @Override
    public void saveDiary(Diary diary) {
        try {

            DateTimeUtil dateTimeUtil = new DateTimeUtil();
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO diary (ClaimNumber,Subject, Description, RelatedTo, DueDate, Details, AssignedTo, CreatedBy, DateCreated) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)");
            System.out.println(diary.getSubject() + " " + diary.getDescription() + " " + diary.getRelatedTo() +" " + diary.getDueDate() +  " " + " " + diary.getDetails() +  " " + diary.getAssignedTo() +  " " + diary.getCreatedBy() +  " " + diary.getDateCreated());


           ps.setString(1, diary.getClaimNumber());
            ps.setString(2, diary.getSubject());
            ps.setString(3, diary.getDescription());
            ps.setString(4, diary.getRelatedTo());
            ps.setDate(5, Date.valueOf(dateTimeUtil.toDate(diary.getDueDate())));
            ps.setString(6, diary.getDetails());
            ps.setString(7, diary.getAssignedTo());
            ps.setString(8, diary.getCreatedBy());
            ps.setDate(9, Date.valueOf(dateTimeUtil.toDate(diary.getDateCreated())));



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
//                x.setDueDate(rs.getDate(4));
//                x.setPriority(rs.getString(5));
                x.setDetails(rs.getString(6));
                x.setAssignedTo(rs.getString(7));
                x.setCreatedBy(rs.getString(8));
//                x.setDateCreated(rs.getDate(9));
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
