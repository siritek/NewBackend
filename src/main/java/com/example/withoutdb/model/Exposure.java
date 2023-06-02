package com.example.withoutdb.model;

import java.util.Date;

public class Exposure {

    private String lossParty;
    private String primaryCoverage;
    private String adjuster;
    private String status;
    private String creationDate;
    private String claimant;
    private String claimantType;
    private String primaryPhone;
    private String address;


    //getters setters

    public String getLossParty() {
        return lossParty;
    }

    public void setLossParty(String lossParty) {
        this.lossParty = lossParty;
    }

    public String getPrimaryCoverage() {
        return primaryCoverage;
    }

    public void setPrimaryCoverage(String primaryCoverage) {
        this.primaryCoverage = primaryCoverage;
    }

    public String getAdjuster() {
        return adjuster;
    }

    public void setAdjuster(String adjuster) {
        this.adjuster = adjuster;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getClaimant() {
        return claimant;
    }

    public void setClaimant(String claimant) {
        this.claimant = claimant;
    }

    public String getClaimantType() {
        return claimantType;
    }

    public void setClaimantType(String claimantType) {
        this.claimantType = claimantType;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
