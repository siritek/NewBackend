package com.example.withoutdb.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.withoutdb.model.SearchNoteModel;

import java.sql.*;

import java.util.List;
import java.sql.Date;


@Service
public class SearchNoteServiceImpl implements SearchNoteService
{

    @Override
    public void saveSearchNote(SearchNoteModel searchNoteModel) {

            try {
                Connection con = DBConn.getMyConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO searchnote(findtext, relatedto, topic) VALUES(?,?,?)");
                System.out.println(searchNoteModel.getFindText() + " " + searchNoteModel.getRelatedTo() + " " + searchNoteModel.getTopic());
                ps.setString(1,searchNoteModel.getFindText());
                ps.setString(2,searchNoteModel.getRelatedTo());
                ps.setString(3,searchNoteModel.getTopic());

                ps.executeUpdate();

                System.out.println("Data inserted sucessfully");
            }
            catch (SQLException e){
                System.out.println("Exception in saveSearchNote method "+e);
            }
        }
    @Override
    public List<SearchNoteModel> getAllsearchnotes() {

        List<SearchNoteModel> allsearchnote = new ArrayList<>();
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("select * from searchnote");
            ResultSet rs = ps.executeQuery();
            SearchNoteModel x = null;
            while (rs.next())
            {
                x = new SearchNoteModel();
                x.setFindText(rs.getString(1));
                x.setRelatedTo(rs.getString(2));
                x.setTopic(rs.getString(3));

                allsearchnote.add(x);
            }
            con.close();
        }
        catch (SQLException e){
            System.out.println("Exception in getsearchnote method "+ e);
        }
        return allsearchnote;
    }

}


