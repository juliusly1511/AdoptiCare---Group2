package adopticare;

import java.sql.*;
import java.util.Scanner;

public class AdoptiCareMain {
    
    public static String login() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Username: ");
        String username = input.nextLine();
        
        System.out.println("Password: ");
        String password = input.nextLine();
        
        try {
            Connection con = Database.getConnection();
            
            String sql = "SELECT role FROM users" + 
                         "WHERE username = ? and password = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, username);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return rs.getString("role");
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public static void adminMenu(){
    }
    
    public static void veterinarianMenu(){
    }
    
    public static void customerMenu(){
    }
    
    public static void addPet(){
    }
    
    public static void viewPets(){
    }
    
    public static void updatePet(){
    }
    
    public static void deletePet(){
    }
    
    public static void searchPet(){
    }
    
    public static void archivePet(){
    }
    
    public static void viewArchivedPets(){
    }
    
    public static void updateVaccination(){
    }
    
    public static void viewVaccinatedPets(){
    }
    
    public static void viewVaccinationSchedule(){
    }
    
    public static void viewAvailablePets() {
    }
    
    public static void viewPetDetails() {
    }
    
    public static void submitAdoptionRequest() {
    }
}
