package com.example.withoutdb.model;

import java.util.Date;
import java.sql.*;

public class Fnol {



    private int policynumber;
    private Date lossdate;
    private String losslocation;
    private Time timeofloss;

    private String lossdescription;
    private String reportedby;
    private Date datereported;

    public int getPolicynumber() {
        return policynumber;
    }

    public void setPolicynumber(int policynumber) {
        this.policynumber = policynumber;
    }

    public String getLossdescription() {
        return lossdescription;
    }

    public void setLossdescription(String lossdescription) {
        this.lossdescription = lossdescription;
    }

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


    public Fnol() {
    }



    public String getLosslocation() {
        return losslocation;
    }

    public void setLosslocation(String losslocation) {
        this.losslocation = losslocation;
    }

    public Time getTimeofloss() {
        return timeofloss;
    }

    public void setTimeofloss(Time timeofloss) {
        this.timeofloss = timeofloss;
    }

    public String getReportedby() {
        return reportedby;
    }

    public void setReportedby(String reportedby) {
        this.reportedby = reportedby;
    }


}
