package com.example.withoutdb.service;

import com.example.withoutdb.model.NewDocument;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewDocumentServiceImpl implements NewDocumentService {



    @Override
    public void saveNewDocument(NewDocument newdocument) {
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO newdocument (documentname, documenttype, relatedto, status, uploadedby, uploadeddate, uploadedtime) VALUES (?, ?, ?, ?, ?, ?, ?)");
            System.out.println(newdocument.getDocumentName() + " " + newdocument.getDocumentType() + " " + newdocument.getRelatedTo() +" " + newdocument.getStatus() +  " " + newdocument.getUploadedBy() +" " + newdocument.getUploadedDate() +" " + newdocument.getUploadedTime() );
            ps.setString(1, newdocument.getDocumentName());
            ps.setString(2, newdocument.getDocumentType());
            ps.setString(3, newdocument.getRelatedTo());
            ps.setString(4, newdocument.getStatus());
            ps.setString(5, newdocument.getUploadedBy());
            ps.setDate(6,  newdocument.getUploadedDate());
            ps.setString(7,  newdocument.getUploadedTime());


            ps.executeUpdate(); // Execute the insert statement

            System.out.println("Data inserted successfully");
        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in saveNewDocument method "+ e);

        }
    }


    @Override
    public List<NewDocument> getAllnewdocuments() {

        List<NewDocument> allnewdocuments = new ArrayList<NewDocument>();
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("select * from newdocument");
            ResultSet rs = ps.executeQuery();
            NewDocument x = null;
            while(rs.next())
            {
                x = new NewDocument();
                x.setDocumentName(rs.getString(1));
                x.setDocumentType(rs.getString(2));
                x.setRelatedTo(rs.getString(3));
                x.setStatus(rs.getString(4));
                x.setUploadedBy(rs.getString(5));
                x.setUploadedDate(rs.getDate(6));
                x.setUploadedTime(rs.getString(7));
                allnewdocuments.add(x);
            }
            con.close();

        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in getNewDocument method "+ e);

        }

        return allnewdocuments;
    }


}
