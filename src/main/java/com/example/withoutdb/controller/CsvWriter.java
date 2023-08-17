package com.example.withoutdb.controller;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CsvWriter {

    public static void writeCsv(ResultSet resultSet, OutputStream outputStream) throws IOException, SQLException {
        try (CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(outputStream))) {
            int columnCount = resultSet.getMetaData().getColumnCount();
            String[] header = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                header[i - 1] = resultSet.getMetaData().getColumnName(i);
            }
            csvWriter.writeNext(header);

            while (resultSet.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getString(i);
                }
                csvWriter.writeNext(rowData);
            }
        }
    }
}

