package com.example.withoutdb.model;


public class Fnol {
    //                //policynumber,description, loss_cause,incident_only, coverage_in_question, how_reported, first_suit_notice, weather_related, catastrophe
    private String policyNumber;
    private String description;
    private String loss_cause;
    private Boolean incident_only;
    private Boolean coverage_in_question;
    private String how_reported;
    private Boolean first_suit_notice;
    private Boolean weather_related;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLoss_cause() {
        return loss_cause;
    }

    public void setLoss_cause(String loss_cause) {
        this.loss_cause = loss_cause;
    }

    public Boolean getIncident_only() {
        return incident_only;
    }

    public void setIncident_only(Boolean incident_only) {
        this.incident_only = incident_only;
    }

    public Boolean getCoverage_in_question() {
        return coverage_in_question;
    }

    public void setCoverage_in_question(Boolean coverage_in_question) {
        this.coverage_in_question = coverage_in_question;
    }

    public String getHow_reported() {
        return how_reported;
    }

    public void setHow_reported(String how_reported) {
        this.how_reported = how_reported;
    }

    public Boolean getFirst_suit_notice() {
        return first_suit_notice;
    }

    public void setFirst_suit_notice(Boolean first_suit_notice) {
        this.first_suit_notice = first_suit_notice;
    }

    public Boolean getWeather_related() {
        return weather_related;
    }

    public void setWeather_related(Boolean weather_related) {
        this.weather_related = weather_related;
    }

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
