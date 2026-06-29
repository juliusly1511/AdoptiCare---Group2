
package menu;

import java.util.Scanner;
import vetchoices.*;


public class Veterinarian {
    
    static Scanner input = new Scanner(System.in);
    
    public static void veterinarianMenu() {
        
        System.out.println("\nWelcome Veterinarian!");
        
        int choice;
        
        do {
            System.out.println("\n===== VETERINARIAN MENU =====");
            
            System.out.println("1. View Pets");
            System.out.println("2. Search Pet");
            System.out.println("3. Add Vaccination");
            System.out.println("4. Update Vaccination");
            System.out.println("5. View Vaccinated Pets");
            System.out.println("6. View Vaccination Schedule");
            System.out.println("7. Logout");
            
            System.out.print("Choose: ");
            choice = input.nextInt();
            
            input.nextLine();
            
            switch (choice) {
                
                case 1:
                    ViewPets.viewPets();
                    break;
                    
                case 2:
                    SearchPet.searchPet();
                    break;
                    
                case 3:
                    AddPet.addPet();
                    break;
                    
                case 4:
                    UpdateVaccination.updateVaccination();
                    break;
                    
                case 5:
                    ViewVaccinatedPets.viewVaccinatedPets();
                    break;
                    
                case 6:
                    ViewVaccinationSchedule.viewVaccinationSchedule();
                    break;
                    
                case 7:
                    System.out.println("Logging out...");
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
            }
            
        } while (choice != 7);
    }
}
