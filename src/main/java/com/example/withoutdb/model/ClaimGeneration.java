package com.example.withoutdb.model;


import java.util.Date;

public class ClaimGeneration {


    private String claimNumber;
    //    private String policyType;
    private String policyNumber;
    private String name;
    private String dateOfLoss;
    private String adjuster;
    private String dateOfReport;
    private String address1;
    private String lossDescription;

    // Constructor
    public ClaimGeneration() {
    }

    // Getters and Setters

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }
//    public String getPolicyType() {
//        return policyType;
//    }
//
//    public void setPolicyType(String policyType) {
//        this.policyType = policyType;
//    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfLoss() {
        return dateOfLoss;
    }

    public void setDateOfLoss(String dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public String getAdjuster() {
        return adjuster;
    }

    public void setAdjuster(String adjuster) {
        this.adjuster = adjuster;
    }

    public String getDateOfReport() {
        return dateOfReport;
    }

    public void setDateOfReport(String dateOfReport) {
        this.dateOfReport = dateOfReport;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }


    public String getLossDescription() {
        return lossDescription;
    }

    public void setLossDescription(String lossDescription) {
        this.lossDescription = lossDescription;
    }

    @Override
    public String toString() {
        return "ClaimGeneration{" +
                "claimNumber='" + claimNumber + '\'' +
//                ", policyType='" + policyType + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", name='" + name + '\'' +
                ", dateOfLoss='" + dateOfLoss + '\'' +
                ", adjuster='" + adjuster + '\'' +
                ", dateOfReport='" + dateOfReport + '\'' +
                ", address1='" + address1 + '\'' +
                ", lossDescription='" + lossDescription + '\'' +
                '}';
    }
}