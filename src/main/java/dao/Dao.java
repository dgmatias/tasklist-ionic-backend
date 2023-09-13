 package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

  public class Dao {
	
	public static Connection getConnection() {
		
		Connection cnx = null;
		
		String driverName = "com.mysql.cj.jdbc.Driver"; //url do driver
		
			try {
				Class.forName(driverName); //O método forName carrega um Driver(class) semelhante a uma injeção de dependência.
				
				String serverName = "localhost:3306";
				String dataBase = "taskListDB";
				String user = "root";
				String password = "";
				
				String url = "jdbc:mysql://" + serverName + "/" + dataBase; 
				
				cnx = DriverManager.getConnection(url, user, password);
				
				if(cnx != null) {
					System.out.println("Conexão concluida com sucesso"); 
				} else {
					System.out.println("Ocorreu algum erro na conexão"); 
				}

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return cnx;
		
	}
	
	public static boolean closeConnection( ) {
		try {
			Dao.getConnection().close();
			System.out.println("Conexão fechada");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
