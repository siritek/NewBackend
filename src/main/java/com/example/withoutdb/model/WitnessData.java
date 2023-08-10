package com.example.withoutdb.model;

public class WitnessData {
    private String witnessId;
    private String witnessName;
    private String witnessPhone1;
    private String witnessPhone2;
    private String witnessEmail;
    private String recordeStatement ;


    public String getWitnessId() {
        return witnessId;
    }

    public void setWitnessId(String witnessId) {
        this.witnessId = witnessId;
    }

    public String getWitnessName() {
        return witnessName;
    }

    public void setWitnessName(String witnessName) {
        this.witnessName = witnessName;
    }

    public String getWitnessPhone1() {
        return witnessPhone1;
    }

    public void setWitnessPhone1(String witnessPhone1) {
        this.witnessPhone1 = witnessPhone1;
    }

    public String getWitnessPhone2() {
        return witnessPhone2;
    }

    public void setWitnessPhone2(String witnessPhone2) {
        this.witnessPhone2 = witnessPhone2;
    }

    public String getWitnessEmail() {
        return witnessEmail;
    }

    public void setWitnessEmail(String witnessEmail) {
        this.witnessEmail = witnessEmail;
    }

    public String getRecordeStatement() {
        return recordeStatement;
    }

    public void setRecordeStatement(String recordeStatement) {
        this.recordeStatement = recordeStatement;
    }

    public void setRecordedStatement(boolean recordedStatement) {
    }
}
