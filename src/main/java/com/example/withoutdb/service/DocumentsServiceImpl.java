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
            PreparedStatement ps = con.prepareStatement("INSERT INTO documents (DocName,RelatedTo, Status) VALUES (?, ?, ?)");
            System.out.println(documents.getRelatedTo() + " " + documents.getStatus() + " " + documents.getDocName() );

           ps.setString(1, documents.getDocName());
            ps.setString(2, documents.getRelatedTo());
            ps.setString(3, documents.getStatus());
           /* ps.setString(4, documents.getDocType());
            ps.setString(5, documents.getUploadedBy());
            ps.setString(6, documents.getUDate());
            ps.setString(7, documents.getUTime());*/


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
                x.setDocName(rs.getString(3));
               /* x.setDocType(rs.getString(4));
                x.setUploadedBy(rs.getString(5));
                x.setUDate(rs.getString(6));
                x.setUTime(rs.getString(7));*/

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
