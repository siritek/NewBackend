package com.example.withoutdb.model;

import java.util.Date;

public class Fnol {
    //ClaimNumber,LossLocation,Time-ofLoss,ReportedBy,PolicyNumber

    private int claimnumber;
    private Date lossdate;
    private String losslocation;
    private String timeofloss;
    private String reportedby;
    private Date datereported;

    public Date getLossdate() {
        return lossdate;
    }

    public void setLossdate(Date lossdate) {
        this.lossdate = lossdate;
    }

    public Date getDatereported() {
        return datereported;
    }

    public void setDatereported(Date datereported) {
        this.datereported = datereported;
    }

    private String policynumber;
    public Fnol() {
    }

    public int getClaimnumber() {
        return claimnumber;
    }

    public void setClaimnumber(int claimnumber) {
        this.claimnumber = claimnumber;
    }

    public String getLosslocation() {
        return losslocation;
    }

    public void setLosslocation(String losslocation) {
        this.losslocation = losslocation;
    }

    public String getTimeofloss() {
        return timeofloss;
    }

    public void setTimeofloss(String timeofloss) {
        this.timeofloss = timeofloss;
    }

    public String getReportedby() {
        return reportedby;
    }

    public void setReportedby(String reportedby) {
        this.reportedby = reportedby;
    }

    public String getPolicynumber() {
        return policynumber;
    }

    public void setPolicynumber(String policynumber) {
        this.policynumber = policynumber;
    }


}
