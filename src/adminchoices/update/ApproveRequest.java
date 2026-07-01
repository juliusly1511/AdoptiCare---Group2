package adminchoices.update;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ApproveRequest {

    public static void approveRequest(Scanner input) {
        try {
            System.out.print("Enter Request ID: ");
            int requestId = Integer.parseInt(input.nextLine().trim());

            String sql = "UPDATE adoption_requests SET status = ? WHERE request_id = ?";

            try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, "Approved");
                pst.setInt(2, requestId);

                int rows = pst.executeUpdate();
                if (rows > 0) {
                    System.out.println("Adoption request approved.");
                } else {
                    System.out.println("Request not found.");
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid request ID.");
        } catch (SQLException ex) {
            System.out.println("Unable to approve request: " + ex.getMessage());
        }
    }
}
