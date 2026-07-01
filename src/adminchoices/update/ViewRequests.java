package adminchoices.update;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewRequests {

    public static void viewRequests() {
        String sql = "SELECT request_id, user_id, pet_id, request_date, status FROM adoption_requests ORDER BY request_id";

        try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("Request ID: " + rs.getInt("request_id"));
                System.out.println("User ID: " + rs.getInt("user_id"));
                System.out.println("Pet ID: " + rs.getInt("pet_id"));
                System.out.println("Date: " + rs.getString("request_date"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("-------------------------");
            }

            if (!found) {
                System.out.println("No adoption requests found.");
            }
        } catch (SQLException ex) {
            System.out.println("Unable to load adoption requests: " + ex.getMessage());
        }
    }
}
