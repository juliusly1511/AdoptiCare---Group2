package adminchoices;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddPet {

    public static void addPet(Scanner input) {
        try {
            String name = readRequiredInput(input, "Pet Name: ");
            String species = readRequiredInput(input, "Species: ");
            String breed = readRequiredInput(input, "Breed: ");
            int age = readIntInput(input, "Age: ");
            String healthCondition = readRequiredInput(input, "Health Condition: ");

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

        } catch (InputMismatchException ex) {
            System.out.println("Please enter a valid number for age.");
            input.nextLine();
        } catch (SQLException ex) {
            System.out.println("Unable to add pet: " + ex.getMessage());
        }
    }

    private static String readRequiredInput(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = input.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field is required.");
        }
    }

    private static int readIntInput(Scanner input, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}
