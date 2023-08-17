package com.example.withoutdb.model;

import java.util.List;

public class PolicyLevelCoverage
{
    private String PolicyNumber;
    private String Coverage_Type;
    private String Incident_Limit;
    private String Per_Person_Limit;
    private String ClaimNumber;

    public static void savePolicyLevelCoverage(PolicyLevelCoverage policyLevelCoverage) {
    }

    public String getPolicyNumber() {
        return PolicyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        PolicyNumber = policyNumber;
    }

    public String getCoverage_Type() {
        return Coverage_Type;
    }

    public void setCoverage_Type(String coverage_Type) {
        Coverage_Type = coverage_Type;
    }

    public String getIncident_Limit() {
        return Incident_Limit;
    }

    public void setIncident_Limit(String incident_Type) {
        Incident_Limit = incident_Type;
    }

    public String getPer_Person_Limit() {
        return Per_Person_Limit;
    }

    public void setPer_Person_Limit(String per_Person_Limit) {
        Per_Person_Limit = per_Person_Limit;
    }

    public String getClaimNumber() {
        return ClaimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        ClaimNumber = claimNumber;
    }
}

