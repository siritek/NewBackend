package com.example.withoutdb.controller;


import com.example.withoutdb.model.CCClaimPayload;
import com.example.withoutdb.model.Fnol;
import com.example.withoutdb.service.CreateClaimFileGWCC;
import com.example.withoutdb.service.DBConn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

@RestController
@CrossOrigin
public class SendClaimtoGWCCcontroller {

    @PostMapping("/generateClaimFile")
    public String generateClaimFile(@RequestBody CCClaimPayload claimPayload, HttpServletResponse response) throws IOException {
        System.out.println("inside generateClaimFile");
        if (claimPayload == null) {
            System.out.println("claimPayload is null");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "null vaules are not allowed";

        } else {

            String policyNumber = claimPayload.getPolicyNumber();
            String claimNumber = claimPayload.getClaimNumber();
            String jsonPayload = getPaylodforCCintegration(policyNumber, claimNumber);
            System.out.println("claim number is " + claimNumber);
           String basePath = "C:\\TestClaim\\";
            String fileName = CreateClaimFileGWCC.createUniqueClaimFile(basePath);
            CreateClaimFileGWCC.writeJsonToFile(jsonPayload, basePath, fileName);

            return "CC payload generated to the file: " + fileName + " with this payload " + jsonPayload;
        }
    }

    private DBConn dbConn;

    private String getPaylodforCCintegration(String policyNumber, String claimNumber) {
        CCClaimPayload payload;
        Fnol fnoldata;

        try {
            Connection con = DBConn.getMyConnection();

            payload = new CCClaimPayload();
//            WitnessData[] witnessDataArray = payload.getpayload().setWitnessData(new WitnessData[0]);
            /*Injuries[] injuriesArray = payload.getpayload().setInjuries(new Injuries[0]);
            Properties[] propertiesArray = payload.getpayload().setProperties(new Properties[0]);
            AdditionalInsured[] additionalInsuredArray = payload.getPolicyInfoData().setAdditionalInsured(new AdditionalInsured[0]);
            ExcludedParties[] excludedPartiesArray = payload.getPolicyInfoData().setExcludedParties(new ExcludedParties[0]);
*/
            String sqlQuery = "SELECT * FROM NXT_Master WHERE PolicyNumber = ? AND ClaimNumber = ?";
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            ps.setString(1, policyNumber);
            ps.setString(2, claimNumber);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                payload.setBaseClaimNumber(rs.getString("ClaimNumber"));
                payload.setPolicyNumber(rs.getString("PolicyNumber"));
                //payload.setDescription(rs.getString("LossDescription"));
                payload.setLossDate(rs.getString("dateOfLoss"));
                payload.setLossLocation(rs.getString("LossLocation"));
                //payload.setLossTime(rs.getString("TimeofLoss"));
                payload.setReportedBy(rs.getString("ReportedBy"));
                payload.setReportDate(rs.getString("DateReported"));

                payload.setLossDate(rs.getString("DateOfLoss"));
               // payload.setLossTime(rs.getString("TimeofLoss"));

                payload.setName(rs.getString("Name"));
                payload.setAddress(rs.getString("Address"));
                payload.setBasePolicyNumber("5566112234");

                payload.setLossDescription(rs.getString("LossDescription"));

                payload.setPolicyType("MutualRequest_Ext");

                payload.setTypeOfLoss("GL");

                payload.setWeatherInvolved(rs.getString("WeatherInvolved"));

                String randomStringaa = UUID.randomUUID().toString().substring(0, 4);
                payload.setWeatherDescription(randomStringaa);

                payload.setCountry("US");
                payload.setCity(rs.getString("City"));
                payload.setState("AZ");
                payload.setZipcode("60067");
                payload.setLossDate(rs.getString("DateOfLoss"));
               // payload.setTimeOfLoss(rs.getString("TimeOfLoss"));
                //payload.setReportedBy(rs.getString("ReportedBy"));
                payload.setRelationshipToInsured("insured");

                payload.setLossParty("third_party");
payload.setHowReported("Internet");
                //payload.setStatus(rs.getString("ExposureStatus"));
                payload.setCreationDate(rs.getString("CreationDate"));
                payload.setClaimant(rs.getString("Claimant"));
                payload.setClaimantType("insured");

               // payload.setPrimaryPhone(rs.getString("PrimaryPhone"));

               /* String sqlWitnessQuery = "SELECT * FROM witnesses WHERE PolicyNumber = ? AND ClaimNumber = ?";
                PreparedStatement psWitness = con.prepareStatement(sqlWitnessQuery);
                psWitness.setString(1, policyNumber);
                psWitness.setString(2, claimNumber);

                ResultSet rsWitness = psWitness.executeQuery();

                while (rsWitness.next()) {
                    //PolicyNumber, Name, Phone_1, Phone_2, Email, RecordedStatement, ClaimNumber
                    // Fetch values from nxt_witness table and set them in the WitnessData array
                    WitnessData witnessData = new WitnessData();
                    witnessData.setWitnessName(rsWitness.getString("Name"));
                    witnessData.setWitnessPhone1(rsWitness.getString("Phone_1"));
                    witnessData.setWitnessPhone2(rsWitness.getString("Phone_2"));
                    // witnessData.setRecordedStatement(Boolean.parseBoolean(rsWitness.getString("RecordedStatement")));
                    witnessData.setWitnessEmail(rsWitness.getString("Email"));

                    // Add the WitnessData object to the WitnessData array
                    witnessDataArray = Arrays.copyOf(witnessDataArray, witnessDataArray.length + 1);
                    witnessDataArray[witnessDataArray.length - 1] = witnessData;*/



                System.out.println("this if payload inserted " + payload.toString());
            }

        } catch (Exception e) {
            System.out.println("error:-" + e.getMessage());
            e.printStackTrace();
            return "error in getPaylodforCCintegration, please consult with the developer " + e.getMessage();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String payloadJson = gson.toJson(payload);

        JsonObject claimdataJson = new JsonObject();
        claimdataJson.add("ClaimData", gson.fromJson(payloadJson, JsonObject.class));
        System.out.println(claimdataJson.toString());

        return claimdataJson.toString();


    }
}





