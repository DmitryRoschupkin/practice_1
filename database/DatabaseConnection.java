package practice_1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/vet_clinic_db";
    private static final String USER = "dmitriy_aitu";
    private static final String PASSWORD = "dima2007";
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database.");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
