package com.example.withoutdb.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.withoutdb.model.NewNoteModel;


import java.sql.*;

import java.util.List;
import java.sql.Date;





    @Service
    public class NewNoteServiceImpl implements NewNoteService {



        @Override
        public void saveNewNote(NewNoteModel newnote) {
            try {
                Connection con = DBConn.getMyConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO newnote (topic , securitytype, subject, relatedto,text, confidential, dateofloss,timeofloss) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                System.out.println(newnote.getTopic() + " " + newnote.getSecurityType() + " " + newnote.getSubject() +" " + newnote.getRelatedTo()  + " " + newnote.getText() +  " " + newnote.getConfidential() +" " + newnote.getDateofloss() +" " + newnote.getTimeofloss() );
                ps.setString(1, newnote.getTopic());
                ps.setString(2, newnote.getSecurityType());

                ps.setString(3, newnote.getSubject());
                ps.setString(4, newnote.getRelatedTo());

                ps.setString(5, newnote.getText());
                ps.setString(6, newnote.getConfidential());

                ps.setDate(7, newnote.getDateofloss());
                ps.setString(8, newnote.getTimeofloss());



                ps.executeUpdate(); // Execute the insert statement

                System.out.println("Data inserted successfully");
            }
            catch(SQLException e) {
                // Handle exceptions appropriately
                System.out.println("Exception in saveNewNote method "+ e);

            }
        }


        @Override
        public List<NewNoteModel> getAllnewnotes() {

            List<NewNoteModel> allnewnotes = new ArrayList<NewNoteModel>();
            try {
                Connection con = DBConn.getMyConnection();
                PreparedStatement ps = con.prepareStatement("select * from newnote2");
                ResultSet rs = ps.executeQuery();
                NewNoteModel x = null;
                while(rs.next())
                {
                    x = new NewNoteModel();
                    x.setTopic(rs.getString(1));
                    x.setSecurityType(rs.getString(2));
                    x.setSubject(rs.getString(3));
                    x.setRelatedTo(rs.getString(4));
                    x.setText(rs.getString(5));
                    x.setConfidential(rs.getString(6));
                    x.setDateofloss(rs.getDate(7));
                    x.setTimeofloss(rs.getString(8));

                    allnewnotes.add(x);
                }
                con.close();

            }
            catch(SQLException e) {
                // Handle exceptions appropriately
                System.out.println("Exception in getnewnote method "+ e);

            }

            return allnewnotes;
        }


    }




/*
import com.NewNotepage.NewNote.Model.NewNoteModel;
        import org.springframework.stereotype.Service;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Date;

@Service
public class NewNoteServiceImpl implements NewNoteService {



    @Override
    public void saveNewNote(NewNoteModel newnote) {
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO newnote2_db (topic , securitytype, subject, relatedto, confidentitial,text) VALUES (?, ?, ?, ?, ?, ?)");
            System.out.println(newnote2_db.gettopic() + " " + newnote2_db.getsecuritytype() + " " + newnote2_db.getsubject() +" " + newnote2_db.getrelatedto() +  " " + newnote2_db.getconfidential() +  " " + newnote2_db.gettext() );
            ps.setString(1, newnote2_db.gettopic());
            ps.setString(2, newnote2_db.getsecuritytype());

            ps.setString(3, newnote2_db.getsubject());
            ps.setString(4, newnote2_db.getrelatedto());
            ps.setString(5, newnote2_db.getconfidential());
            ps.setString(6, newnote2_db.gettext());


            ps.executeUpdate(); // Execute the insert statement

            System.out.println("Data inserted successfully");
        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in saveNewNote method "+ e);

        }
    }


    @Override
    public List<NewNoteModel> getAllnewnotes() {

        List<NewNoteModel> allnewnotes = new ArrayList<NewNoteModel>();
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("select * from newnote2_db");
            ResultSet rs = ps.executeQuery();
            NewNoteModel x = null;
            while(rs.next())
            {
                x = new NewNoteModel();
                x.settopic(rs.getString(1));
                x.setsecuritytype(rs.getString(2));
                x.setsubject(rs.getString(3));
                x.setrelatedto(rs.getString(4));
                x.setconfidential(rs.getString(5));
                x.settext(rs.getString(5));
                allnewnotes.add(x);
            }
            con.close();

        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in getnewnote method "+ e);

        }

        return allnewnotes;
    }


}
*/