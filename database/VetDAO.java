package practice_1.database;
import practice_1.models.Veterinarian;

import  java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public boolean updateVet(Veterinarian v){
        String sql = "UPDATE v SET name = ?, specialization = ?, experience = ?, phone = ? WHERE vet_id = ?";
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, v.getName());
            statement.setString(2, v.getSpecialization().toLowerCase());
            statement.setInt(3, v.getExperience());
            statement.setString(4, v.getPhone());
            statement.setInt(5, v.getVetId());
            int rowUpdated = statement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Vet updated successfully");
                return true;
            }
        }catch(SQLException e){
            System.out.println("Error while updating Vet into database");
            e.printStackTrace();
        }finally{
            DatabaseConnection.closeConnection(conn);
        }
        return false;
    }
    public boolean deleteVet(Veterinarian v){
        String sql = "DELETE FROM vet WHERE vet_id = ?";
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, v.getVetId());
            int rowDeleted = statement.executeUpdate();
            if(rowDeleted > 0){
                System.out.println("Vet deleted successfully");
                return true;
            }else{
                System.out.println("Vet not found");
            }
        }catch(SQLException e){
            System.out.println("Error while deleting Vet into database");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(conn);
        }
        return false;
    }
    public List<Veterinarian> searchVetByName(String name){
        List<Veterinarian> vets = new ArrayList<>();
        String sql = "SELECT * FROM vet WHERE name ILIKE ? ORDER BY name";
        Connection conn = DatabaseConnection.getConnection();
        if(conn == null) return vets;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+name+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Veterinarian vet = new Veterinarian(rs.getInt("vet_id"), rs.getString("name"), rs.getString("specialization"), rs.getInt("experience"), rs.getString("phone") );
                if(vet != null){
                    vets.add(vet);
                }
            }
            rs.close();
            statement.close();
        }catch(SQLException e){
            System.out.println("Error while getting Vets from database");
            e.printStackTrace();
        }finally{
            DatabaseConnection.closeConnection(conn);
        }
        return vets;
    }
    public List<Veterinarian> selectAllVetsByExp(int minExp, int  maxExp){
        List<Veterinarian> vets = new ArrayList<>();
        String sql = "SELECT * FROM vet WHERE experience BETWEEN ? AND ?";
        Connection conn = DatabaseConnection.getConnection();
        if(conn == null) return vets;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, minExp);
            statement.setInt(2, maxExp);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Veterinarian vet = new Veterinarian(rs.getInt("vet_id"), rs.getString("name"), rs.getString("specialization"), rs.getInt("experience"), rs.getString("phone") );
                if(vet !=  null){
                    vets.add(vet);
                }
            }
            rs.close();
            statement.close();
            System.out.println("Found " + vets.size() + " Vets in database");
        }catch(SQLException e){
            System.out.println("Error while getting Vets from database");
            e.printStackTrace();
        }finally{
            DatabaseConnection.closeConnection(conn);
        }
        return vets;
    }
    public List<Veterinarian> selectAllVetsByMinExp(int exp){
        List<Veterinarian> vets = new ArrayList<>();
        String sql = "SELECT * FROM vet WHERE experience >= ?";
        Connection conn = DatabaseConnection.getConnection();
        if(conn == null) return vets;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, exp);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Veterinarian v = new  Veterinarian(rs.getInt("vet_id"), rs.getString("name"), rs.getString("specialization"), rs.getInt("experience"), rs.getString("phone"));
                if(v !=  null){
                    vets.add(v);
                }
            }
            rs.close();
            statement.close();
            System.out.println("Found " + vets.size() + " Vets in database");
        }catch (SQLException e){
            System.out.println("Error while getting Vets from database");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(conn);
        }
        return vets;
    }
}
