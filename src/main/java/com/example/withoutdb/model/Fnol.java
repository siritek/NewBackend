package com.example.withoutdb.model;


public class Fnol {
    private String policyNumber;
    private String  dateOfLoss;
    private String lossLocation;
    private String lossTime;
    private String reportedBy;
    private String dateOfReport;

    public String getDateOfLoss() {
        return dateOfLoss;
    }

    public void setDateOfLoss(String dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public String getLossLocation() {
        return lossLocation;
    }

    public void setLossLocation(String lossLocation) {
        this.lossLocation = lossLocation;
    }

    public String getLossTime() {
        return lossTime;
    }

    public void setLossTime(String lossTime) {
        this.lossTime = lossTime;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getDateOfReport() {
        return dateOfReport;
    }

    public void setDateOfReport(String dateOfReport) {
        this.dateOfReport = dateOfReport;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
}
