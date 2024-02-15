package com.example.withoutdb.controller;

import com.example.withoutdb.model.Fnol;
import com.example.withoutdb.service.DBConn;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8090", "http://192.168.1.106:8090"})
@RequestMapping("/claimcenter")
public class ClaimController {

    private final DBConn dbConn;

    public ClaimController(DBConn dbConn) {
        this.dbConn = dbConn;
    }
    public static class FnolWrapper {
        private List<Fnol> claimloss;
        public FnolWrapper(List<Fnol> claimloss) {
            this.claimloss = claimloss;
        }
        public List<Fnol> getClaimloss() {
            return claimloss;
        }

        public void setClaimloss(List<Fnol> claimloss) {
            this.claimloss = claimloss;
        }
    }
    @GetMapping("/loss/{policy}")
    public Fnol createLoss(@PathVariable("policy") String policy) {
        Fnol claimLoss = new Fnol();
        System.out.println(policy);

        try {
            Connection conn = dbConn.getMyConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT reportedby,description,loss_cause,incident_only,coverage_in_question,how_reported,first_suit_notice,weather_related,catastrophe FROM claim WHERE policynumber = ?");
            statement.setString(1, policy);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                //policynumber,description, loss_cause,incident_only, coverage_in_question, how_reported, first_suit_notice, weather_related, catastrophe
                claimLoss.setReportedBy(rs.getString("reportedby"));
                claimLoss.setDescription(rs.getString("description"));
                claimLoss.setLoss_cause(rs.getString("loss_cause"));
                claimLoss.setIncident_only(rs.getBoolean("incident_only"));
                claimLoss.setCoverage_in_question(rs.getBoolean("coverage_in_question"));
                claimLoss.setHow_reported(rs.getString("how_reported"));
                claimLoss.setFirst_suit_notice(rs.getBoolean("first_suit_notice"));
                claimLoss.setWeather_related(rs.getBoolean("weather_related"));
                // claimLoss.setCatastrophe(rs.getString("catastrophe"));//catastrophe
                // add date dated to send to CC
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Exception in createLoss method: " + e);
        }
        return claimLoss;
    }

}

    /*@GetMapping("/loss/{policy}")
    public ResponseEntity<FnolWrapper> createLoss(@PathVariable("policy") String policy) {
        List<Fnol> claimloss = new ArrayList<>();

        try {
            Connection conn = dbConn.getMyConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT reportedby FROM fnol WHERE policynumber = ?");
            statement.setString(1, policy);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Fnol x = new Fnol();
                x.setReportedby(rs.getString("reportedby"));
                claimloss.add(x);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Exception in createLoss method: " + e);
        }

        FnolWrapper response = new FnolWrapper(claimloss);
        return ResponseEntity.ok(response);
    }
}*/
/*


    @GetMapping("/loss/{policy}")
    public List<Fnol> createLoss(@PathVariable("policy") String policy) {
        List<Fnol> claimloss = new ArrayList<>();

        try {
            Connection conn = dbConn.getMyConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT reportedby FROM fnol WHERE policynumber = ?");
            statement.setString(1, policy);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Fnol x = new Fnol();
                x.setReportedby(rs.getString("reportedby"));
                claimloss.add(x);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Exception in createLoss method: " + e);
        }

        return claimloss;
    }
}  */
/*

    @GetMapping("/loss/{policy}")
    public List<Fnol> createLoss( @PathVariable("policy") String policy) {

        List<Fnol> claimloss = new ArrayList<Fnol>();
        try {
            Connection conn = dbConn.getMyConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT reportedby FROM fnol WHERE policynumber = ?");
            statement.setString(1, policy);
            System.out.println(""+Integer.parseInt(String.valueOf(policy))+" test ");
            conn.close();


        } catch (SQLException e) {
            System.out.println("Exception in getFnol method: " + e);
        }

        // Create a new list with only claimnumber and timeofloss properties
        List<Fnol> result = new ArrayList<>();
        for (Fnol fnol : claimloss) {
            Fnol newFnol = new Fnol();
            newFnol.setReportedby(fnol.getReportedby());
            //  newFnol.setClaimnumber(fnol.getClaimnumber());
            //  newFnol.setTimeofloss(fnol.getTimeofloss());
            result.add(newFnol);
        }

        return result;
    }


}
*/
