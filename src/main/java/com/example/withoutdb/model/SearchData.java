package com.example.withoutdb.model;

import java.util.Date;

public class SearchData {
    private String claimNumber;
    private String insuredName;
    private String policyNumber;
    private String claimantName;
    private Date dateOfLoss;
    private String adjuster;
    private String policyStatus;

    // Constructors, getters, and setters

    public SearchData() {
    }

    public SearchData(String claimNumber, String insuredName, String policyNumber, String claimantName, Date dateOfLoss, String adjuster, String policyStatus) {
        this.claimNumber = claimNumber;
        this.insuredName = insuredName;
        this.policyNumber = policyNumber;
        this.claimantName = claimantName;
        this.dateOfLoss = dateOfLoss;
        this.adjuster = adjuster;
        this.policyStatus = policyStatus;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public void setClaimantName(String claimantName) {
        this.claimantName = claimantName;
    }

    public Date getDateOfLoss() {
        return dateOfLoss;
    }

    public void setDateOfLoss(Date dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public String getAdjuster() {
        return adjuster;
    }

    public void setAdjuster(String adjuster) {
        this.adjuster = adjuster;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }
}