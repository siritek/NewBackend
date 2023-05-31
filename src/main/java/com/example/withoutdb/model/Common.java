package com.example.withoutdb.model;

public class Common {
    private Fnol fnolData;
    private Policyinformation policyInfoData;
    private LossSummary lossData;
    private Exposure exposureData;

    public Fnol getFnolData() {
        return fnolData;
    }

    public void setFnolData(Fnol fnolData) {
        this.fnolData = fnolData;
    }

    public Policyinformation getPolicyInfoData() {
        return policyInfoData;
    }

    public void setPolicyInfoData(Policyinformation policyInfoData) {
        this.policyInfoData = policyInfoData;
    }

    public LossSummary getLossData() {
        return lossData;
    }

    public void setLossData(LossSummary lossData) {
        this.lossData = lossData;
    }

    public Exposure getExposureData() {
        return exposureData;
    }

    public void setExposureData(Exposure exposureData) {
        this.exposureData = exposureData;
    }
}
