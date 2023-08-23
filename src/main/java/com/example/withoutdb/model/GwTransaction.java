package com.example.withoutdb.model;

public class GwTransaction
{
    private String Id;
    private String GWClaimNumber;
    private String CreateDateTime;
    private String BaseClaimNumber;
    private String BasePolicyNumber;
    private String Status;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getGWClaimNumber() {
        return GWClaimNumber;
    }

    public void setGWClaimNumber(String GWClaimNumber) {
        this.GWClaimNumber = GWClaimNumber;
    }

    public String getCreateDateTime() {
        return CreateDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        CreateDateTime = createDateTime;
    }

    public String getBaseClaimNumber() {
        return BaseClaimNumber;
    }

    public void setBaseClaimNumber(String baseClaimNumber) {
        BaseClaimNumber = baseClaimNumber;
    }

    public String getBasePolicyNumber() {
        return BasePolicyNumber;
    }

    public void setBasePolicyNumber(String basePolicyNumber) {
        BasePolicyNumber = basePolicyNumber;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
