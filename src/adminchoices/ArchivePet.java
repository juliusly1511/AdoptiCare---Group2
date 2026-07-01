package adminchoices;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ArchivePet {

    public static void archivePet(Scanner input) {
        try {
            System.out.print("Enter Pet ID: ");
            int petId = Integer.parseInt(input.nextLine().trim());

            String sql = "UPDATE pets SET archived = TRUE WHERE pet_id = ?";

            try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, petId);

                int rows = pst.executeUpdate();

                if (rows > 0) {
                    System.out.println("Pet archived successfully.");
                } else {
                    System.out.println("Pet not found.");
                }
            }

        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid pet ID.");
        } catch (SQLException ex) {
            System.out.println("Unable to archive pet: " + ex.getMessage());
        }
    }
}
