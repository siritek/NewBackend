package com.example.withoutdb.model;

import java.util.Date;

public class Exposure {

    private String lossparty;
    private String primarycoverage;
    private String adjuster;
    private String status;
    private Date creationdate;
    private String claimant;
    private String claimanttype;
    private String primaryphone;
    private String address;


    //getters setters
    public String getLossparty() {
        return lossparty;
    }

    public void setLossparty(String lossparty) {
        this.lossparty = lossparty;
    }

    public String getPrimarycoverage() {
        return primarycoverage;
    }

    public void setPrimarycoverage(String primarycoverage) {
        this.primarycoverage = primarycoverage;
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

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getClaimant() {
        return claimant;
    }

    public void setClaimant(String claimant) {
        this.claimant = claimant;
    }

    public String getClaimanttype() {
        return claimanttype;
    }

    public void setClaimanttype(String claimanttype) {
        this.claimanttype = claimanttype;
    }

    public String getPrimaryphone() {
        return primaryphone;
    }

    public void setPrimaryphone(String primaryphone) {
        this.primaryphone = primaryphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
