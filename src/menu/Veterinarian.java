
package menu;

import java.util.Scanner;
import vetchoices.create.AddVaccination;
import vetchoices.read.SearchPet;
import vetchoices.read.ViewPets;
import vetchoices.read.ViewVaccinatedPets;
import vetchoices.read.ViewVaccinationSchedule;
import vetchoices.update.UpdateVaccinationStatus;


public class Veterinarian {
    
    private static final Scanner input = new Scanner(System.in);
    
    public static void veterinarianMenu() {
        
        System.out.println("\nWelcome Veterinarian!");
        
        int choice;
        
        do {
            System.out.println("\n===== VETERINARIAN MENU =====");
            
            System.out.println("1. Add Vaccination");
            System.out.println("2. Search Pet");
            System.out.println("3. View Pets");
            System.out.println("4. View Vaccinated Pets");
            System.out.println("5. View Vaccination Schedule");
            System.out.println("6. Update Health Condition");
            System.out.println("7. Update Vaccination Status");
            System.out.println("8. Update Vaccination Schedule");
            System.out.println("9. Logout");
            
            choice = readChoice();
            
            switch (choice) {
                case 1:
                    AddVaccination.addVaccination();
                    break;
                case 2:
                    SearchPet.searchPet();
                    break;
                case 3:
                    ViewPets.viewPets();
                    break;
                case 4:
                    ViewVaccinatedPets.viewVaccinatedPets();
                    break;
                case 5:
                    ViewVaccinationSchedule.viewVaccinationSchedule();
                    break;
                case 6:
                    UpdateVaccinationStatus.updateVaccination();
                    break;
                case 7:
                    System.out.println("Logging out...");
                    break;
                case 8:
                    System.out.println("Vaccination schedule update feature is not available yet.");
                    break;
                case 9:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);
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
                return 9;
            }
        }
    }
}


