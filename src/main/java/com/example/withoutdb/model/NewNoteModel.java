package com.example.withoutdb.model;



import java.sql.Date;




public class NewNoteModel {


        private long id;
        private String Topic;
        private String SecurityType ;

        private String Confidential;

    public String getConfidential() {
        return Confidential;
    }

    public void setConfidential(String confidential) {
        Confidential = confidential;
    }

    private String Subject;
        private String RelatedTo;
        private String Text;

        private Date  dateofloss;

    public Date getDateofloss() {
        return dateofloss;
    }

    public void setDateofloss(Date dateofloss) {
        this.dateofloss = dateofloss;
    }

    private String timeofloss;

    public NewNoteModel() {
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getSecurityType() {
        return SecurityType;
    }

    public void setSecurityType(String securitytype) {
        SecurityType = securitytype;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getRelatedTo() {
        return RelatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        RelatedTo = relatedTo;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }



    public String getTimeofloss() {
        return timeofloss;
    }

    public void setTimeofloss(String timeofloss) {
        this.timeofloss = timeofloss;
    }


}
