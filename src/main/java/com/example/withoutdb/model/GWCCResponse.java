package com.example.withoutdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GWCCResponse {

    public GWCCResponse() {

    }
    private String response;
    private String baseClaimNumber;
    private String basePolicyNumber;
    private String gwClaimnumber;
    private String other;
    private String createdDate;


    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getBaseClaimNumber() {
        return baseClaimNumber;
    }

    public void setBaseClaimNumber(String baseClaimNumber) {
        this.baseClaimNumber = baseClaimNumber;
    }

    public String getBasePolicyNumber() {
        return basePolicyNumber;
    }

    public void setBasePolicyNumber(String basePolicyNumber) {
        this.basePolicyNumber = basePolicyNumber;
    }

    public String getGwClaimnumber() {
        return gwClaimnumber;
    }

    public void setGwClaimnumber(String gwClaimnumber) {
        this.gwClaimnumber = gwClaimnumber;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
