package com.example.withoutdb.model;


import java.sql.Time;
import java.util.Date;

public class Policyinformation {

    private int policyNumber;
    private String policyType;

    private String policyVerified;


    private Date dateOfLoss;
    private Time timeOfLoss;
    private String underWriteCompany;
    private Date effectiveDate;

    private Date expirationDate;
    private Date cancellationDate;

    private Date originalEffectiveDate;

    private String policyStatus;

    private  String name;

    private String address;

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getPolicyVerified() {
        return policyVerified;
    }

    public void setPolicyVerified(String policyVerified) {
        this.policyVerified = policyVerified;
    }

    public Date getDateOfLoss() {
        return dateOfLoss;
    }

    public void setDateOfLoss(Date dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public Time getTimeOfLoss() {
        return timeOfLoss;
    }

    public void setTimeOfLoss(Time timeOfLoss) {
        this.timeOfLoss = timeOfLoss;
    }

    public String getUnderWriteCompany() {
        return underWriteCompany;
    }

    public void setUnderWriteCompany(String underWriteCompany) {
        this.underWriteCompany = underWriteCompany;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(Date cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public Date getOriginalEffectiveDate() {
        return originalEffectiveDate;
    }

    public void setOriginalEffectiveDate(Date originalEffectiveDate) {
        this.originalEffectiveDate = originalEffectiveDate;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}






