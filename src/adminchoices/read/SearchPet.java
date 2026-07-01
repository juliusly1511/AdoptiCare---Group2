package adminchoices.read;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchPet {

    public static void searchPet(Scanner input) {
        try {
            System.out.print("Enter Pet ID: ");
            int id = Integer.parseInt(input.nextLine().trim());

            String sql = "SELECT * FROM pets WHERE pet_id = ?";

            try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, id);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Name: " + rs.getString("pet_name"));
                        System.out.println("Species: " + rs.getString("species"));
                        System.out.println("Breed: " + rs.getString("breed"));
                        System.out.println("Age: " + rs.getInt("age"));
                    } else {
                        System.out.println("Pet not found.");
                    }
                }
            }

        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid pet ID.");
        } catch (SQLException ex) {
            System.out.println("Unable to search pet: " + ex.getMessage());
        }
    }
}
