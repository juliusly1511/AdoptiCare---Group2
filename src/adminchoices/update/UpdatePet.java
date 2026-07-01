package adminchoices.update;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePet {

    public static void updatePet(Scanner input) {
        try {
            System.out.print("Enter Pet ID: ");
            int petId = Integer.parseInt(input.nextLine().trim());

            System.out.print("New Name: ");
            String name = input.nextLine().trim();

            System.out.print("New Breed: ");
            String breed = input.nextLine().trim();

            System.out.print("New Age: ");
            int age = Integer.parseInt(input.nextLine().trim());

            String sql = "UPDATE pets SET pet_name = ?, breed = ?, age = ? WHERE pet_id = ?";

            try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, name);
                pst.setString(2, breed);
                pst.setInt(3, age);
                pst.setInt(4, petId);

                int rows = pst.executeUpdate();

                if (rows > 0) {
                    System.out.println("Pet updated successfully.");
                } else {
                    System.out.println("Pet not found.");
                }
            }

        } catch (NumberFormatException ex) {
            System.out.println("Please enter valid numeric values.");
        } catch (SQLException ex) {
            System.out.println("Unable to update pet: " + ex.getMessage());
        }
    }
}
