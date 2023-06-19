package com.example.withoutdb.model;

public class Documents {
    //RelatedTo,Status,Name
    private String DocType;
    private String DocName;

    public String getDocName() {
        return DocName;
    }

    public void setDocName(String docName) {
        DocName = docName;
    }

    private String RelatedTo;
    private String Status;
    private String UploadedBy;
    private String UDate;
    private String UTime;


    public String getDocType() {
        return DocType;
    }
    public void setDocType(String docType) {
        DocType = docType;
    }

    public String getRelatedTo() {
        return RelatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        RelatedTo = relatedTo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUploadedBy() {
        return UploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        UploadedBy = uploadedBy;
    }

    public String getUDate() {
        return UDate;
    }

    public void setUDate(String UDate) {
        this.UDate = UDate;
    }

    public String getUTime() {
        return UTime;
    }

    public void setUTime(String UTime) {
        this.UTime = UTime;
    }
}
