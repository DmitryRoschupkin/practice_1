package practice_1;
import practice_1.database.DatabaseConnection;
import practice_1.menu.MenuManager;
import practice_1.models.*;

import java.sql.Connection;

class Main{
	public static void main(String[] args){
//		Connection conn = DatabaseConnection.getConnection();
//		if(conn != null){
//			System.out.println("Connection test passed");
//			DatabaseConnection.closeConnection(conn);
//		}else System.out.println("Connection test failed");
		MenuManager m = new MenuManager();
		m.run();
	}
}