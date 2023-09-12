package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	
	public static String status;
	
	public static Connection getConnection() {
		
		Connection cnx = null;
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		
			try {
				Class.forName(driverName);
				
				String serverName = "localhost:3306";
				String dataBase = "taskListDB";
				String user = "root";
				String password = "";
				//String url = "jdbc:mysql://" + serverName + "/" + dataBase + "?user=" + user + "&password=" + password;
				String url = "jdbc:mysql://" + serverName + "/" + dataBase;
				
				cnx = DriverManager.getConnection(url, user, password);
				
				//cnx = DriverManager.getConnection(url);
				
				System.out.println(url);
				if(cnx != null) {
					status = "Conexão concluida com sucesso";
				} else {
					status = "Ocorreu algum erro na conexão";
				}

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
		return cnx;
		
	}
	
	public static String getStatus() {
		return status;
	}
	
}
