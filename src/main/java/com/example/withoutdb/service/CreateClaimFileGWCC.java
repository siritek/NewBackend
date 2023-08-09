package com.example.withoutdb.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CreateClaimFileGWCC {

    public static String createUniqueClaimFile(String basePath) throws IOException {

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String randomString = UUID.randomUUID().toString().substring(0, 4);
            String fileName = "NXT-_" + timeStamp + "_" + randomString + ".txt";
            String filePath = basePath + fileName;
            System.out.println("filePath: " + filePath);
            System.out.println("inside CreateClaimFileGWCC");

            return "file_" + timeStamp + "_" + randomString + ".txt";

    }

    public static void writeJsonToFile(String jsonPayload, String basePath, String fileName) throws IOException {
        String filePath = basePath + fileName;
        File file = new File(filePath);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(jsonPayload);
            System.out.println("JSON payload written to the file: " + filePath);
        }
    }

        public static void writeToFile(File file, String content) throws IOException {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(content);
                System.out.println("Content written to the file.");
            }
        }


    }





