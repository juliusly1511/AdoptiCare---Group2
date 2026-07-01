package adminchoices.create;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddPet {

    public static void addPet(Scanner input) {
        try {
            System.out.print("Pet Name: ");
            String name = input.nextLine().trim();

            System.out.print("Species: ");
            String species = input.nextLine().trim();

            System.out.print("Breed: ");
            String breed = input.nextLine().trim();

            System.out.print("Age: ");
            int age = Integer.parseInt(input.nextLine().trim());

            System.out.print("Health Condition: ");
            String healthCondition = input.nextLine().trim();

            String sql = "INSERT INTO pets (pet_name, species, breed, age, health_condition, vaccination_status, adoption_status, archived) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, name);
                pst.setString(2, species);
                pst.setString(3, breed);
                pst.setInt(4, age);
                pst.setString(5, healthCondition);
                pst.setString(6, "Pending");
                pst.setString(7, "Available");
                pst.setBoolean(8, false);

                int rows = pst.executeUpdate();
                if (rows > 0) {
                    System.out.println("Pet added successfully!");
                } else {
                    System.out.println("The pet could not be added.");
                }
            }

        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid age.");
        } catch (SQLException ex) {
            System.out.println("Unable to add pet: " + ex.getMessage());
        }
    }
}
