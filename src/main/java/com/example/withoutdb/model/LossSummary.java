package com.example.withoutdb.model;

import java.sql.Time;
import java.util.Date;

public class LossSummary {


    private String adjuster;
    private String lossDescription;
    private String lossCause;
    private String otherDescription;
    private String typeOfLoss;
    private String weatherInvolved;   //weatherInvloved
    private String weatherDescription;

    private String location;
    private String address1;
    private String address2;
    private String address3;

    private String country;

    private String city;
    private String state;

    private String zipCode;
    private String jurisdiction;
    private String dateOfLoss;
    private String timeOfLoss;
    private  String reportedBy;
    private  String relationshipToInsured;

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getRelationshipToInsured() {
        return relationshipToInsured;
    }

    public void setRelationshipToInsured(String relationshipToInsured) {
        this.relationshipToInsured = relationshipToInsured;
    }

    public String getAdjuster() {
        return adjuster;
    }

    public void setAdjuster(String adjuster) {
        this.adjuster = adjuster;
    }

    public String getLossDescription() {
        return lossDescription;
    }

    public void setLossDescription(String lossDescription) {
        this.lossDescription = lossDescription;
    }

    public String getLossCause() {
        return lossCause;
    }

    public void setLossCause(String lossCause) {
        this.lossCause = lossCause;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public String getTypeOfLoss() {
        return typeOfLoss;
    }

    public void setTypeOfLoss(String typeOfLoss) {
        this.typeOfLoss = typeOfLoss;
    }

    public String getWeatherInvolved() {
        return weatherInvolved;
    }

    public void setWeatherInvolved(String weatherInvolved) {
        this.weatherInvolved = weatherInvolved;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getDateOfLoss() {
        return dateOfLoss;
    }

    public void setDateOfLoss(String dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public String getTimeOfLoss() {
        return timeOfLoss;
    }

    public void setTimeOfLoss(String timeOfLoss) {
        this.timeOfLoss = timeOfLoss;
    }
}
