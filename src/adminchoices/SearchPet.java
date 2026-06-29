package adminchoices;

import database.DBConnect;
import java.sql.*;
import java.util.Scanner;

public class SearchPet {

        public static void searchPet() {
            
            Scanner input = new Scanner(System.in);
            
        try {

            System.out.println("Enter Pet ID: ");
            int id = input.nextInt();
            input.nextLine();

            Connection con = DBConnect.getConnection();

            String sql = "SELECT * FROM pets WHERE pet_id = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Name: " + rs.getString("pet_name"));

                System.out.println("Species: " + rs.getString("species"));

                System.out.println("Breed: " + rs.getString("breed"));

                System.out.println("Age: " + rs.getInt("age"));

            } else {
                System.out.println("Pet not found.");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
