package com.example.withoutdb.model;

import java.util.Date;

public class Documents {
    //RelatedTo,Status,Name



    private String relatedTo;
    private String status;
    private String name;

    public String getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
