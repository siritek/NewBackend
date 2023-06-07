package com.example.withoutdb.service;

import com.example.withoutdb.model.Documents;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class DocumentsServiceImpl implements DocumentsService {



    @Override
    public void saveDocuments(Documents documents) {
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO documents (RelatedTo, Status, Name) VALUES (?, ?, ?)");
            System.out.println(documents.getRelatedTo() + " " + documents.getStatus() + " " + documents.getName()  );
            ps.setString(1, documents.getRelatedTo());
            ps.setString(2, documents.getStatus());
            ps.setString(3, documents.getName());



            ps.executeUpdate(); // Execute the insert statement

            System.out.println("Data inserted successfully");
        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in saveDocuments method "+ e);

        }
    }


    @Override
    public List<Documents> getAlldocuments() {

        List<Documents> alldocuments = new ArrayList<Documents>();
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("select * from documents");
            ResultSet rs = ps.executeQuery();
            Documents x = null;
            while(rs.next())
            {
                x = new Documents();
                x.setRelatedTo(rs.getString(1));
                x.setStatus(rs.getString(2));
                x.setName(rs.getString(3));
                alldocuments.add(x);
            }
            con.close();

        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in getDocuments method "+ e);

        }

        return alldocuments;
    }


}
