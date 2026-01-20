package practice_1.database;

import practice_1.models.Owner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerDAO {
    public void insertOwner(Owner owner) {
        String sql = "INSERT INTO owner (name, phone, loyalty_points) VALUES (?, ?, ?)";
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, owner.getName());
            statement.setString(2, owner.getPhone());
            statement.setInt(3, owner.getLoyaltyPoints());

            int rowInserted = statement.executeUpdate();

            if (rowInserted > 0) {
                System.out.println("Owner successfully inserted into table");
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error while inserting owner into table");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }

    public void selectAllOwners(Owner owner) {
        String sql = "SELECT * FROM owner";
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            System.out.println("====ALL OWNERS====");
            while (rs.next()) {
                int  id = rs.getInt("owner_id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Phone: " + phone);

                System.out.println();
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error while selecting data");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }
}
