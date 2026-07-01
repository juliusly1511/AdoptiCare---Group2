package adminchoices.delete;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePet {

    public static void deletePet(Scanner input) {
        try {
            System.out.print("Enter Pet ID: ");
            int petId = Integer.parseInt(input.nextLine().trim());

            String sql = "DELETE FROM pets WHERE pet_id = ?";

            try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, petId);

                int rows = pst.executeUpdate();

                if (rows > 0) {
                    System.out.println("Pet deleted successfully.");
                } else {
                    System.out.println("Pet not found.");
                }
            }

        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid pet ID.");
        } catch (SQLException ex) {
            System.out.println("Unable to delete pet: " + ex.getMessage());
        }
    }
}
