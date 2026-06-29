package adminchoices;

import database.DBConnect;
import java.sql.*;
import java.util.Scanner;

public class AddPet {

    static Scanner input = new Scanner(System.in);
    
    public static void addPet() {

        try {
            System.out.print("Pet Name: ");
            String name = input.nextLine();

            System.out.print("Species: ");
            String species = input.nextLine();

            System.out.print("Breed: ");
            String breed = input.nextLine();

            System.out.print("Age: ");
            int age = input.nextInt();
            input.nextLine();

            System.out.print("Health Condition: ");
            String healthCondition = input.nextLine();

            Connection con = DBConnect.getConnection();

            String sql
                    = "INSERT INTO "
                    + "(pet_name, species, breed, age, health_condition)"
                    + " VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, species);
            pst.setString(3, breed);
            pst.setInt(4, age);
            pst.setString(5, healthCondition);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Pet Added Successfully!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
