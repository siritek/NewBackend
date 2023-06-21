package com.example.withoutdb.model;



public class SearchNoteModel
{

    private String findText;
    private String relatedTo;
    private String topic;

    public String getFindText() {
        return findText;
    }

    public void setFindText(String findText) {
        this.findText = findText;
    }

    public String getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(String relatedTo) {
        this.relatedTo = relatedTo;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
