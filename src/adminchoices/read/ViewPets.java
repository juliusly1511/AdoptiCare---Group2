package adminchoices.read;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewPets {

    public static void viewPets() {
        String sql = "SELECT * FROM pets WHERE archived = FALSE";

        try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

        try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            System.out.println("\n===== PET LIST =====");
            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("ID: " + rs.getInt("pet_id"));
                System.out.println("Name: " + rs.getString("pet_name"));
                System.out.println("Species: " + rs.getString("species"));
                System.out.println("Breed: " + rs.getString("breed"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Health Condition: " + rs.getString("health_condition"));
                System.out.println("Vaccination Status: " + rs.getString("vaccination_status"));
                System.out.println("Adoption Status: " + rs.getString("adoption_status"));
                System.out.println("-------------------------");
            }

            if (!found) {
                System.out.println("No active pets found.");
            }
        } catch (SQLException ex) {
            System.out.println("Unable to load pets: " + ex.getMessage());
        }
    }
}
