package adopticare;

import static adopticare.AdoptiCareMain.*;


public class Main {

    public static void main(String[] args) {
        
        String role = login();
        
        if (role == null) {
            System.out.println("Invalid Login.");
            return;
        }
        
        switch(role){
            
            case "Administrator":
                adminMenu();
                break;
                
            case "Veterinarian":
                veterinarianMenu();
                break;
                
            case "Customer":
                customerMenu();
                break;
        }
    }
}
