package practice_1.database;

import practice_1.models.Pet;
import java.sql.*;

public class PetDAO {
    public void insertPet(Pet pet) {
        String sql = "INSERT INTO pets(name, species, age, owner_id) VALUES (?, ?, ?, ?)";
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecies());
            statement.setInt(3, pet.getAge());
            statement.setInt(4, pet.getOwner().getOwnerId());

            int rowInserted = statement.executeUpdate();

            if(rowInserted > 0){
                System.out.println("Pet has been inserted");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error while inserting pet");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(conn);
        }
    }
    public void selectAllPets(Pet pet) {
        String sql = "SELECT * FROM pet";
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("====ALL PETS====");

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String species = resultSet.getString("species");
                int age = resultSet.getInt("age");
                int ownerId = resultSet.getInt("owner_id");
                String owner_name = pet.getOwner().getName();

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Species: " + species);
                System.out.println("Age: " + age);
                System.out.println("Owner: " + owner_name);
                System.out.println(owner_name+"'s ID: " + ownerId);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error while selecting pet");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(conn);
        }
    }
}
