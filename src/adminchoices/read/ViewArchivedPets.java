package adminchoices.read;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewArchivedPets {

    public static void viewArchivedPets() {
        String sql = "SELECT pet_id, pet_name, species, breed, age, health_condition, vaccination_status, adoption_status "
                + "FROM pets WHERE archived = TRUE OR archived = 1 OR archived = '1' OR archived = 'true' OR archived = 'TRUE'";

        try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
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
                System.out.println("No archived pets found.");
            }
        } catch (SQLException ex) {
            System.out.println("Unable to load archived pets: " + ex.getMessage());
        }
    }
}
