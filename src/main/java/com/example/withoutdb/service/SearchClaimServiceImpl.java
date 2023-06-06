package com.example.withoutdb.service;

import com.example.withoutdb.model.SearchClaim;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class SearchClaimServiceImpl implements SearchClaimService {


    @Override
    public void saveSearchClaim(SearchClaim NXT_Master) {
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO NXT_Master (ClaimNumber ,policyNumber, SearchFor, FirstName,LastName, OrganizationName, TaxID,Insured, Claimant, LossDate, Adjuster, Status, RemainingReserves, FuturePayments, Paid)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)");
            System.out.println( NXT_Master.getClaimNumber() + " " + NXT_Master.getPolicyNumber() + " " + NXT_Master.getSearchFor() +" " + NXT_Master.getFirstName()  + " " + NXT_Master.getLastName() +  " " + NXT_Master.getOrganizationName() +" " + NXT_Master.getTaxID() );
            ps.setString(1, NXT_Master.getClaimNumber());
            ps.setString(2, NXT_Master.getPolicyNumber());

            ps.setString(3, NXT_Master.getSearchFor());
            ps.setString(4, NXT_Master.getFirstName());

            ps.setString(5, NXT_Master.getLastName());
            ps.setString(6, NXT_Master.getOrganizationName());

            ps.setString(7, NXT_Master.getTaxID());




            ps.executeUpdate(); // Execute the insert statement

            System.out.println("Data inserted successfully");
        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in saveNewNote method "+ e);

        }
    }


    @Override
    public List<SearchClaim> getAllsearchclaims() {

        List<SearchClaim> allsearchclaims = new ArrayList<SearchClaim>();
        try {
            Connection con = DBConn.getMyConnection();
            PreparedStatement ps = con.prepareStatement("select * from NXT_Master");
            ResultSet rs = ps.executeQuery();
            SearchClaim x = null;
            while(rs.next())
            {
                x = new SearchClaim();
                x.setClaimNumber(rs.getString(1));
                x.setPolicyNumber(rs.getString(2));
                x.setSearchFor(rs.getString(3));
                x.setFirstName(rs.getString(4));
                x.setLastName(rs.getString(5));
                x.setOrganizationName(rs.getString(6));
                x.setTaxID(rs.getString(7));


                allsearchclaims.add(x);
            }
            con.close();

        }
        catch(SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in getnewnote method "+ e);

        }

        return allsearchclaims;
    }



}
