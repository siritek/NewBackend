package com.example.withoutdb.model;

public class Injuries {
    private String PolicyNumber;
    private String ClaimNumber;
    private String Name;
    private String Severity;

    public String getPolicyNumber() {
        return PolicyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        PolicyNumber = policyNumber;
    }

    public String getClaimNumber() {
        return ClaimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        ClaimNumber = claimNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String severity) {
        Severity = severity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String Description;

}