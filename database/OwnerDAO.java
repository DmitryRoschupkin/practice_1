package practice_1.database;

import practice_1.models.Owner;
import practice_1.models.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Owner> selectAllOwners() {
        ArrayList<Owner> owners_list_dao = new ArrayList<>();
        String sql = "SELECT * FROM owner ORDER BY owner_id ASC";
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            System.out.println("====ALL OWNERS====");
            while (rs.next()) {
//                int  id = rs.getInt("owner_id");
//                String name = rs.getString("name");
//                String phone = rs.getString("phone");
                Owner o = new Owner(
                        rs.getInt("owner_id"),
                        rs.getString("name"),
                        rs.getString("phone")
                        //rs.getInt("loyalty_points")
                );

                owners_list_dao.add(o);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error while selecting data");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return owners_list_dao;
    }
    public boolean updateOwner(Owner owner) {
        String sql = "UPDATE owner SET name = ?, phone = ?, loyalty_points = ? WHERE owner_id = ?";
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return false;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, owner.getName());
            statement.setString(2, owner.getPhone());
            statement.setInt(3, owner.getLoyaltyPoints());
            statement.setInt(4, owner.getOwnerId());
            int rowUpdated = statement.executeUpdate();
            statement.close();
            if (rowUpdated > 0) {
                System.out.println("Owner successfully updated into table");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error while updating owner into table");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return false;
    }
    public boolean deleteOwner(Owner owner) {
        String sql = "DELETE FROM owner WHERE owner_id = ?";
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return false;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, owner.getOwnerId());
            int rowDeleted = statement.executeUpdate();
            statement.close();
            if (rowDeleted > 0) {
                System.out.println("Owner successfully deleted from table");
                return true;
            }else{
                System.out.println("Owner not deleted from table");
            }

        }catch (SQLException e){
            System.out.println("Error while deleting owner into table");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(conn);
        }
        return false;
    }

    public List<Owner> searchOwnerByName(String name){
        List<Owner> owners = new ArrayList<>();
        String sql = "SELECT * FROM owner WHERE name ILIKE ? ORDER BY name";
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return owners;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+name+"%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Owner o =  new Owner(rs.getInt("owner_id"),rs.getString("name"),rs.getString("phone"));
                if(owners!=null){
                    owners.add(o);
                }
            }
            rs.close();
            statement.close();
            System.out.println("Found "+owners.size()+" owners in table");
        }catch(SQLException e){
            System.out.println("Error while searching owner into table");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(conn);
        }
        return owners;
    }

    public List<Owner> searchOwnerByLoyaltyPointsRange(int minLoyaltyPoints, int maxLoyaltyPoints){
        List<Owner> owners = new ArrayList<>();
        String sql = "SELECT * FROM owner WHERE loyalty_points BETWEEN ? AND ? ORDER BY loyalty_points DESC";
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return owners;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, minLoyaltyPoints);
            statement.setInt(2, maxLoyaltyPoints);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Owner o = new Owner(rs.getInt("owner_id"),rs.getString("name"),rs.getString("phone"));
                if(o!=null){
                    owners.add(o);
                }
            }
            rs.close();
            statement.close();
            System.out.println("Found "+owners.size()+" owners in table");
        } catch (SQLException e) {
            System.out.println("Error while searching owner into table");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return owners;
    }

    public List<Owner> searchOwnerByMinLoyaltyPoints(int thisLoyaltyPoints) {
        List<Owner> owners = new ArrayList<>();
        String sql = "SELECT * FROM owner WHERE loyalty_points >= ? ORDER BY loyalty_points DESC";
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return owners;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, thisLoyaltyPoints);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Owner o = new Owner(rs.getInt("owner_id"),rs.getString("name"),rs.getString("phone"));
                if(o!=null){
                    owners.add(o);
                }
            }
            rs.close();
            statement.close();
            System.out.println("Found "+owners.size()+" owners in table");
        } catch (SQLException e) {
            System.out.println("Error while searching owner into table");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return owners;
    }

    //method for PetDAO where I need to use object Owner as an argument
    public static Owner getOwnerById(int ownerId){
        String sql = "SELECT * FROM owner WHERE owner_id = ?";
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return null;
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, ownerId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Owner owner = new Owner(rs.getInt("owner_id"),rs.getString("name"),rs.getString("phone"));
                if(owner!=null){
                    return owner;
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error while searching owner into table");
            e.printStackTrace();
        }finally {
            DatabaseConnection.closeConnection(conn);
        }
        return null;
    }

    public static List<Pet> getPetsByOwnerId(int ownerId){
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet WHERE owner_id = ?";
        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, ownerId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Owner owner = getOwnerById(rs.getInt("owner_id"));
                Pet p = new Pet(rs.getString("name"), rs.getString("species"), rs.getInt("age"), owner);
                if(owner!=null){
                    pets.add(p);
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error while searching owner into table");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return pets;
    }

}
