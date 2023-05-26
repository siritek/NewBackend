package com.NewNotepage.NewNote.Model;


import java.sql.*;

public class LossSummary {

    //Adjuster
    //Loss Description
    //Loss Cause
    //Other Description
    //Type of Loss
    //Weather Involved
    //Weather Description
    //Date of loss*
    //Time of loss*
    //Location
    //Address 1
    //Address 2
    //Address 3
    // Country
    // City
    // State
    // Zip Code
    // Jurisdiction

    private String Adjuster;
    private String LossDescription;
    private String LossCause;
    private String OtherDescription;
    private String TypeOfLoss;
    private String WeatherInvolved;
    private String WeatherDescription;

    private String Location;
    private String Address1;
    private String Address2;
    private String Address3;

    private String Country;

    private String City;
    private String State;

    private Integer ZipCode;
    private String Jurisdiction;
    private java.sql.Date DateOfLoss;
    private Time TimeOfLoss;

    public LossSummary() {
    }

    public String getAdjuster() {
        return Adjuster;
    }

    public void setAdjuster(String adjuster) {
        Adjuster = adjuster;
    }

    public String getLossDescription() {
        return LossDescription;
    }

    public void setLossDescription(String lossDescription) {
        LossDescription = lossDescription;
    }

    public String getLossCause() {
        return LossCause;
    }

    public void setLossCause(String lossCause) {
        LossCause = lossCause;
    }

    public String getOtherDescription() {
        return OtherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        OtherDescription = otherDescription;
    }

    public String getTypeOfLoss() {
        return TypeOfLoss;
    }

    public void setTypeOfLoss(String typeOfLoss) {
        TypeOfLoss = typeOfLoss;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getAddress3() {
        return Address3;
    }

    public void setAddress3(String address3) {
        Address3 = address3;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public Integer getZipCode() {
        return ZipCode;
    }

    public void setZipCode(Integer zipCode) {
        ZipCode = zipCode;
    }

    public String getJurisdiction() {
        return Jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        Jurisdiction = jurisdiction;
    }

    public Date getDateOfLoss() {
        return DateOfLoss;
    }

    public void setDateOfLoss(Date dateOfLoss) {
        DateOfLoss = dateOfLoss;
    }

    public Time getTimeOfLoss() {
        return TimeOfLoss;
    }

    public void setTimeOfLoss(Time timeOfLoss) {
        TimeOfLoss = timeOfLoss;
    }

    public String getWeatherInvolved() {
        return WeatherInvolved;
    }

    public void setWeatherInvolved(String weatherInvolved) {
        WeatherInvolved = weatherInvolved;
    }

    public String getWeatherDescription() {
        return WeatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        WeatherDescription = weatherDescription;
    }




}
