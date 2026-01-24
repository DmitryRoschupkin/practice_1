package practice_1.database;
import practice_1.models.Veterinarian;

import  java.sql.*;
import java.util.ArrayList;

public class VetDAO {
    public void insertVet(Veterinarian v){
        String sql = "INSERT INTO veterinarian (name, specialization, experience, phone) VALUES (?, ?, ?, ?)";
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, v.getName());
            statement.setString(2, v.getSpecialization().toLowerCase());
            statement.setInt(3, v.getExperience());
            statement.setString(4, v.getPhone());

            int rowInserted = statement.executeUpdate();

            if(rowInserted > 0){
                System.out.println("Vet inserted successfully");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error while inserting Vet into database");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(conn);
        }
    }
    public ArrayList<Veterinarian> selectAllVets(){
        String sql = "SELECT * FROM veterinarian";
        Connection conn = DatabaseConnection.getConnection();
        ArrayList<Veterinarian> vets_list_dao = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            System.out.println("====ALL VETERINARIANS====");
            while(rs.next()){
                Veterinarian vet = new Veterinarian(
                        rs.getInt("vet_id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getInt("experience"),
                        rs.getString("phone")
                );
                vets_list_dao.add(vet);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error while getting Vets from database");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(conn);
        }
        return vets_list_dao;
    }
}
