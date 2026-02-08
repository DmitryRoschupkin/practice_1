package practice_1.database;

import practice_1.models.Owner;
import practice_1.models.Pet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static practice_1.database.OwnerDAO.getOwnerById;

public class PetDAO {
    public void insertPet(Pet pet) {
        String sql = "INSERT INTO pet(name, species, age, owner_id) VALUES (?, ?, ?, ?)";
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecies().toLowerCase());
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
    public ArrayList<Pet> selectAllPets() {
        ArrayList<Pet> pets_list_dao = new ArrayList<>();
        String sql = "SELECT p.*, o.name as owner_name, o.phone as owner_phone " +
                "FROM pet p JOIN owner o ON p.owner_id = o.owner_id";
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            System.out.println("====ALL PETS====");

            while(rs.next()){
                Owner owner = new Owner(
                        rs.getInt("owner_id"),
                        rs.getString("owner_name"),
                        rs.getString("owner_phone")
                );
                Pet pet = new Pet(
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getInt("age"),
                        owner
                );
                pet.setPetId(rs.getInt("pet_id"));
                pets_list_dao.add(pet);
            }
        } catch (SQLException e) {
            System.out.println("Error while selecting pet");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(conn);
        }
        return pets_list_dao;
    }
    public List<Pet> searchPetsByName(String name) {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet WHERE name ILIKE ? ORDER BY name";
        Connection conn = DatabaseConnection.getConnection();
        if(conn == null) return pets;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+name+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                int owner_id = rs.getInt("owner_id");
                Owner owner = getOwnerById(owner_id);
                Pet pet = new Pet(rs.getString("name"), rs.getString("species"), rs.getInt("age"), owner);
                if (pet != null){
                    pets.add(pet);
                }
            }
            rs.close();
            statement.close();
        }catch(SQLException e){
            System.out.println("Error while searching pets by name");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(conn);
        }
        return pets;
    }
    public List<Pet> searchPetsBySpecies(String species) {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet WHERE species ILIKE ? ORDER BY pet_id";
        Connection conn = DatabaseConnection.getConnection();
        if(conn == null) return pets;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+species+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                int owner_id = rs.getInt("owner_id");
                Owner owner = getOwnerById(owner_id);
                Pet pet = new Pet(rs.getString("name"), rs.getString("species"), rs.getInt("age"), owner);
                if (pet != null){
                    pets.add(pet);
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error while searching pets by species");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(conn);
        }
        return pets;
    }
}
