package com.example.withoutdb.service;

import com.example.withoutdb.model.*;

import java.sql.*;
import java.util.List;

public class CommonServiceImpl  implements  CommonService {

    public void saveCommon(Common common) {
        try {
            Fnol fnol = common.getFnolData();
            Policyinformation policyinformation = common.getPolicyInfoData();
            LossSummary lossSummary = common.getLossData();
            Exposure exposure = common.getExposureData();
            DateTimeUtil dateTimeUtil = new DateTimeUtil();

            Connection con = DBConn.getMyConnection();
            System.out.println("Connection reached Common Service");

            PreparedStatement ps = con.prepareStatement("INSERT INTO NXT_Master (PolicyNumber, DateofLoss, LossLocation, TimeofLoss, Reportedby, DateReported,UnderwritingCompany, EffectiveDate,CancellationDate, ExpirationDate, PolicyStatus, PolicyType, Name, Address, Phone, Adjuster, LossDescription, LossCause, TypeofLoss, WeatherInvolved, WeatherDescription, RelationshipToInsured, LossAddress, Countries, City, Zipcode, State, LossParty, PrimaryCoverage, ExposuresStatus, CreationDate, Claimant, ClaimantType,  ExposureAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, fnol.getPolicyNumber());
            ps.setDate(2, Date.valueOf(dateTimeUtil.toDate(fnol.getDateOfLoss())));
            ps.setString(3, fnol.getLossLocation());
            ps.setTime(4, Time.valueOf(dateTimeUtil.toTime(fnol.getLossTime())));
            ps.setString(5, fnol.getReportedBy());
            ps.setDate(6, Date.valueOf(dateTimeUtil.toDate(fnol.getDateOfReport())));

            //ps.setString(7, policyinformation.getPolicyVerified());
            ps.setString(7, policyinformation.getUnderwriting());
            ps.setDate(8, Date.valueOf(dateTimeUtil.toDate(policyinformation.getEffectiveDate())));
            ps.setDate(9, Date.valueOf(dateTimeUtil.toDate(policyinformation.getExpirationDate())));
            ps.setDate(10, Date.valueOf(dateTimeUtil.toDate(policyinformation.getCancellationDate())));
           // ps.setDate(12, Date.valueOf(dateTimeUtil.toDate(policyinformation.getOriginalEffectiveDate())));
            ps.setString(11, policyinformation.getPolicyStatus());
            ps.setString(12, policyinformation.getPolicyType());
            ps.setString(13, policyinformation.getName());
            ps.setString(14, policyinformation.getAddress());
            ps.setString(15, policyinformation.getPrimaryPhone());

            ps.setString(16, lossSummary.getAdjuster());
            ps.setString(17, lossSummary.getLossDescription());
            ps.setString(18, lossSummary.getLossCause());
            //ps.setString(21, lossSummary.getOtherDescription());
            ps.setString(19, lossSummary.getTypeOfLoss());
            ps.setString(20, lossSummary.getWeatherInvolved());
            ps.setString(21, lossSummary.getWeatherDescription());
            ps.setString(22, lossSummary.getRelationshipToInsured());
            ps.setString(23, lossSummary.getLossAddress());
            ps.setString(24, lossSummary.getCountry());
            ps.setString(25, lossSummary.getCity());
            ps.setString(26, lossSummary.getZipCode());
            ps.setString(27, lossSummary.getState());


            ps.setString(28, exposure.getLossParty());
            ps.setString(29, exposure.getPrimaryCoverage());
            ps.setString(30, exposure.getStatus());
            ps.setDate(31, Date.valueOf(dateTimeUtil.toDate(exposure.getCreationDate())));
            ps.setString(32, exposure.getClaimant());
            ps.setString(33, exposure.getClaimantType());
            ps.setString(34, exposure.getAddress());

            ps.executeUpdate(); // Execute the insert statement

            System.out.println("Data inserted successfully,Inserted values: " + fnol.getPolicyNumber() + ", " +
                    dateTimeUtil.toDate(fnol.getDateOfLoss()) + ", " +
                    fnol.getLossLocation() + ", " +
                    dateTimeUtil.toTime(fnol.getLossTime()) + ", " +
                    fnol.getReportedBy() + ", " +
                    dateTimeUtil.toDate(fnol.getDateOfReport()) + ", " +
                  //  policyinformation.getPolicyVerified() + ", " +
                    policyinformation.getUnderwriting() + ", " +
                    dateTimeUtil.toDate(policyinformation.getEffectiveDate()) + ", " +
                    dateTimeUtil.toDate(policyinformation.getExpirationDate()) + ", " +
                   // dateTimeUtil.toDate(policyinformation.getOriginalEffectiveDate()) + ", " +
                    policyinformation.getPolicyStatus() + ", " +
                    policyinformation.getPolicyType() + ", " +
                    policyinformation.getName() + ", " +
                    policyinformation.getAddress() + ", " +
                    policyinformation.getPrimaryPhone() + ", " +
                    lossSummary.getAdjuster() + ", " +
                    lossSummary.getLossDescription() + ", " +
                    lossSummary.getLossCause() + ", " +
                   // lossSummary.getOtherDescription() + ", " +
                    lossSummary.getTypeOfLoss() + ", " +
                    lossSummary.getWeatherInvolved() + ", " +
                    lossSummary.getWeatherDescription() + ", " +
                    lossSummary.getRelationshipToInsured() + ", " +
                    lossSummary.getLossAddress() + ", " +
                    lossSummary.getCountry() + ", " +
                    lossSummary.getCity() + ", " +
                    lossSummary.getZipCode() + ", " +
                    lossSummary.getState() + ", " +
                    lossSummary.getJurisdiction() + ", " +
                    exposure.getLossParty() + ", " +
                    exposure.getPrimaryCoverage() + ", " +
                    exposure.getStatus() + ", " +
                    dateTimeUtil.toDate(exposure.getCreationDate()) + ", " +
                    exposure.getClaimant() + ", " +
                    exposure.getClaimantType() + ", " +
                    exposure.getAddress());
        } catch (SQLException e) {
            // Handle exceptions appropriately
            System.out.println("Exception in saveFnol method " + e);

        }
    }

    @Override
    public List<Common> getAllcommons() {
        return null;
    }
}