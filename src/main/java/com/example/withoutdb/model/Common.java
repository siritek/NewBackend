package com.example.withoutdb.model;

public class Common {

    private String Fnol;
    private String Exposure;
    private  String LossSummary;
    private  String Policyinformation;


    public String getFnol() {
        return Fnol;
    }

    public void setFnol(String fnol) {
        Fnol = fnol;
    }

    public String getExposure() {
        return Exposure;
    }

    public void setExposure(String exposure) {
        Exposure = exposure;
    }

    public String getLossSummary() {
        return LossSummary;
    }

    public void setLossSummary(String lossSummary) {
        LossSummary = lossSummary;
    }

    public String getPolicyinformation() {
        return Policyinformation;
    }

    public void setPolicyinformation(String policyinformation) {
        Policyinformation = policyinformation;
    }
}
