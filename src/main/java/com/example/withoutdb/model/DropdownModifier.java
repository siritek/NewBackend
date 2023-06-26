package com.example.withoutdb.model;

import com.example.withoutdb.service.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;

public class DropdownModifier {

    public DropdownModifier() {
    }
    public DropdownModifier(String dropdownItem) {
        this.dropdownItem = dropdownItem;
    }
    private String method;
    private String value;
    private String id;
    private String dropdownItem;

    public String getDropdownItem() {
        return dropdownItem;
    }
    public void setDropdownItem(String dropdownItem) {
        this.dropdownItem = dropdownItem;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //method which will be called when user wants to modify dropdown values
    public void modify() {
        System.out.println("Ready to modify");
        try{
            String method = getMethod();
            String dropdown = getDropdownItem();
            String value = getValue();
            System.out.println("method: " + method);
            System.out.println("value: " + value);
            System.out.println("dropdown value: " + dropdown+"    make sure that this field match the if statement so that it can put it in correct DB");

            if(method.equals("ADD") && value!=null){
                System.out.println("Ready to add value in DB");
                setValue(value);
                addIntoDB(value);
            }
            else if(method.equals("DELETE")&& value!=null){
                System.out.println("Ready to delete value in DB");
                deleteIntoDB(value);
            }
            else {
                System.out.println("error method or value not specified");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void addIntoDB(String value) {
        try {
            Connection con = DBConn.getMyConnection();

            if(Objects.equals(dropdownItem, "adjuster")){
                PreparedStatement ps = con.prepareStatement("INSERT INTO adjuster(Adjuster_Value) VALUES(?)");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeUpdate();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "state")){
                PreparedStatement ps = con.prepareStatement("INSERT INTO state(State) VALUES(?)");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "RelationshiptoInsured")){
                PreparedStatement ps = con.prepareStatement("INSERT INTO relationshiptoinsured(relationshiptoinsured) VALUES(?)");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "Security Type")){
                PreparedStatement ps = con.prepareStatement("INSERT INTO securitytype(securitytype) VALUES(?)");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "Topic")){
                PreparedStatement ps = con.prepareStatement("INSERT INTO topic(topic) VALUES(?)");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "Relatedto")){
                PreparedStatement ps = con.prepareStatement("INSERT INTO relatedto(relatedto) VALUES(?)");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "Status")){
                PreparedStatement ps = con.prepareStatement("INSERT INTO status(status) VALUES(?)");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "AssignedTo")){
                PreparedStatement ps = con.prepareStatement("INSERT INTO assignedto(assignedto) VALUES(?)");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "CreatedBy")){
                PreparedStatement ps = con.prepareStatement("INSERT INTO createdby(createdby) VALUES(?)");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else{
                System.out.println("error method or value not specified");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteIntoDB(String value) {
        try {
            Connection con = DBConn.getMyConnection();

            if(Objects.equals(dropdownItem, "adjuster")){
                PreparedStatement ps = con.prepareStatement("DELETE FROM adjuster WHERE Adjuster_Value = ?");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeUpdate();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "state")){
                PreparedStatement ps = con.prepareStatement("DELETE FROM state WHERE State = ?");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }else if(Objects.equals(dropdownItem, "RelationshiptoInsured")){
                PreparedStatement ps = con.prepareStatement("DELETE FROM relationshiptoinsured WHERE relationshiptoinsured = ?");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "Security Type")){
                PreparedStatement ps = con.prepareStatement("DELETE FROM securitytype WHERE securitytype = ?");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "Topic")){
                PreparedStatement ps = con.prepareStatement("DELETE FROM topic WHERE topic = ?");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "Relatedto")){
                PreparedStatement ps = con.prepareStatement("DELETE FROM relatedto WHERE relatedto = ?");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "Status")){
                PreparedStatement ps = con.prepareStatement("DELETE FROM status WHERE status = ?");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "AssignedTo")){
                PreparedStatement ps = con.prepareStatement("DELETE FROM assignedto WHERE assignedto = ?");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else if(Objects.equals(dropdownItem, "CreatedBy")){
                PreparedStatement ps = con.prepareStatement("DELETE FROM createdby WHERE createdby = ?");
                ps.setString(1, value);
                System.out.println("PS: " + ps);
                ps.executeQuery();
                ps.close();
            }
            else{
                System.out.println("error method or value not specified");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
