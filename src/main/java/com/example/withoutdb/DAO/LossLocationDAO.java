package com.example.withoutdb.DAO;


import com.example.withoutdb.service.DBConn;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LossLocationDAO {

        private DBConn dbConn = new DBConn();
        public LossLocationDAO() {
        }
        public Map<String, List<String>> getLossLocationDD() {
            Map<String, List<String>> typesMap = new HashMap<>();
            List<String> countries = new ArrayList<>();
            List<String> states = new ArrayList<>();

            try {
                Connection con = DBConn.getMyConnection();
                System.out.println("Connection reached prepareStatement loss location");
                PreparedStatement ps = con.prepareStatement("SELECT Name FROM countries");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String country = rs.getString("Name");
                    countries.add(country);
                }
                rs.close();


                PreparedStatement ps1 = con.prepareStatement("SELECT State FROM state");
                ResultSet rs1 = ps1.executeQuery();

                while (rs1.next()) {
                    String state = rs1.getString("State");
                    states.add(state);
                }
                rs1.close();

                typesMap.put("countries", countries);
                typesMap.put("states", states);
                System.out.println("loss location : - "+typesMap);

            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return typesMap;
        }
    }




