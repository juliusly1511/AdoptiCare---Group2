package adopticare;

import auth.*;
import java.util.Scanner;
import menu.*;

public class AdoptiCareMain {

    static Scanner input = new Scanner(System.in);

    public static void onSystem() {

        int choice;

        do {
            System.out.println("\n===== ADOPTICARE =====");

            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            choice = readChoice();

            switch (choice) {

                case 1 -> handleLogin();
                case 2 -> Register.registerCustomer();
                case 3 -> System.out.println("Thank you for using AdoptiCare!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    private static int readChoice() {
        while (true) {
            try {
                System.out.print("Choose: ");
                String line = input.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            } catch (java.util.NoSuchElementException ex) {
                System.out.println("Input stream closed. Exiting.");
                return 3;
            }
        }
    }

    public static void handleLogin() {

        String role = Login.login();
        if (role == null) {
            System.out.println("Invalid username or password.");
        } else {
            switch (role) {
                case "Administrator" -> Admin.adminMenu();
                case "Veterinarian" -> Veterinarian.veterinarianMenu();
                case "Customer" -> Customer.customerMenu();
                default -> System.out.println("Unknown role: " + role);
            }
        }
    }
}
