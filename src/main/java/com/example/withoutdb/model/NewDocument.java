package com.example.withoutdb.model;

import java.sql.Date;
import java.sql.Time;

public class NewDocument {
    //DocumentName,DocumentType,RelatedTo,Status,UploadedBy,UploadedDate,UploadedTime

    private String documentName;
    private String documentType;
    private String relatedTo;
    private String status;
    private String uploadedBy;
    private java.sql.Date uploadedDate;
    private String uploadedTime;

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public String getUploadedTime() {
        return uploadedTime;
    }

    public void setUploadedTime(String uploadedTime) {
        this.uploadedTime = uploadedTime;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }



    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

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

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }


}
