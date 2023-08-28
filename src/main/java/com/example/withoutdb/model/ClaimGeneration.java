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
    private String timeOfLoss;
    private String reportedBy;
    private String policyType;
    private String effectiveDate;
    private String expirationDate;
    private String cancellationDate;
    private String lossCause;
    private String typeOfLoss;
    private String address;
    private String lossParty;
    private String primaryCoverage;
    private String exposuresStatus;
    private String countries;
    private String city;
    private String state;
    private String zipcode;

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

    public String getTimeOfLoss() {
        return timeOfLoss;
    }

    public void setTimeOfLoss(String timeOfLoss) {
        this.timeOfLoss = timeOfLoss;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(String cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public String getLossCause() {
        return lossCause;
    }

    public void setLossCause(String lossCause) {
        this.lossCause = lossCause;
    }

    public String getTypeOfLoss() {
        return typeOfLoss;
    }

    public void setTypeOfLoss(String typeOfLoss) {
        this.typeOfLoss = typeOfLoss;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getExposuresStatus() {
        return exposuresStatus;
    }

    public void setExposuresStatus(String exposuresStatus) {
        this.exposuresStatus = exposuresStatus;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
                ", timeOfLoss='" + timeOfLoss + '\'' +
                ", reportedBy='" + reportedBy + '\'' +
                ", policyType='" + policyType + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cancellationDate='" + cancellationDate + '\'' +
                ", lossCause='" + lossCause + '\'' +
                ", typeOfLoss='" + typeOfLoss + '\'' +
                ", address='" + address + '\'' +
                ", lossParty='" + lossParty + '\'' +
                ", primaryCoverage='" + primaryCoverage + '\'' +
                ", exposuresStatus='" + exposuresStatus + '\'' +
                ", countries='" + countries + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}