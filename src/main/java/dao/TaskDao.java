package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;

public class TaskDao {

	//Método list irá fazer uma querry de todo o banco de dados.
	
	public List<Task> listDB() {
		
		Connection cnx = Dao.getConnection(); // Criando a conexão
		
		List<Task> taskList = new ArrayList<Task>();
		
		String sql = "Select * from tasks";
		
		Task task;
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				task = new Task();
				
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setStatus(rs.getBoolean("status"));
				
				taskList.add(task);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dao.closeConnection();
			return taskList;
		}
		
	}
	
}