package adminchoices;

import database.DBConnect;
import java.sql.*;
import java.util.Scanner;

public class UpdatePet {

    public static void updatePet() {
        
        Scanner input = new Scanner(System.in);
        
        try {
            
            System.out.println("Enter Pet ID: ");
            int petId = input.nextInt();
            
            input.nextLine();
            
            System.out.println("New Name: ");
            String name = input.nextLine();
            
            System.out.println("New Breed: ");
            String breed = input.nextLine();
            
            System.out.println("New Age: ");
            int age = input.nextInt();
            
            input.nextLine();
            
            Connection con = DBConnect.getConnection();
            
            String sql = 
                    "UPDATE pets"
                    + "SET pet_name = ?,"
                    + "breed = ?"
                    + "age = ?"
                    + "WHERE pet_id = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, name);
            pst.setString(2, breed);
            pst.setInt(3, age);
            pst.setInt(4, petId);
            
            int rows = pst.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Pet updated.");
            } else {
                System.out.println("Pet not found.");
            }
            
            con.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
