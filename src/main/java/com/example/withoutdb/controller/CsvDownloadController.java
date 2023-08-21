package com.example.withoutdb.controller;

import com.example.withoutdb.service.DBConn;
import com.opencsv.CSVWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

@RestController
public class CsvDownloadController {

    @GetMapping("/download-csv")
    public void downloadCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=nxt_master.csv");

        try (Connection connection = DBConn.getMyConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM nxt_master")) {

            PrintWriter writer = response.getWriter();
            CSVWriter csvWriter = new CSVWriter(writer);

            // Get metadata for column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            String[] headers = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                headers[i - 1] = metaData.getColumnName(i);
            }
            csvWriter.writeNext(headers);

            // Write data
            while (resultSet.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getString(i);
                }
                csvWriter.writeNext(rowData);
            }

            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
