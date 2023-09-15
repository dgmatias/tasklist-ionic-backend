package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;

public class TaskDao {

	public boolean addDB(Task task) {
		
		boolean result = true;
		
		Connection cnx = Dao.getConnection();
		
		String sql = "INSERT INTO tasks (name) VALUES (?)";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(sql);
			ps.setString(1, task.getName());
			int i = ps.executeUpdate();			
			
			result = i > 0 ? true : false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Dao.closeConnection();
		return result;
		
	}
		
	//Método list irá fazer uma query de todo o banco de dados.
	
	@SuppressWarnings("finally")
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
	
	//Método que irá executar o comando DELETE no banco de dados
	
	public boolean deleteDB(Integer id) {
		
		boolean result = true;
		
		Connection cnx = Dao.getConnection();
		
		String sql = "DELETE FROM tasks WHERE id = ?";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			result = i > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Dao.closeConnection();
		return result;
		
	}
	
	//Método que irá executar o comando alter table no banco de dados;
	
	public boolean alterDB(Task task) {
		
		boolean result = true;
		
		Connection cnx = Dao.getConnection();
		
		String sql = "UPDATE tasks SET name = ?, status = ? WHERE id = ?";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(sql);
			ps.setString(1, task.getName());
			ps.setBoolean(2, task.getStatus());
			ps.setInt(3, task.getId());
			int i = ps.executeUpdate();
			
			result = i > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Dao.closeConnection();
		return result;
		
	}
	
	//Método que irá executar uma query com base em um id
	
	@SuppressWarnings("finally")
	public List<Task> searchByIdDB(Integer id) {
		
		Connection cnx = Dao.getConnection();
		
		List<Task> list = new ArrayList<Task>();
		
		Task task = new Task();
		
		String sql = "SELECT * FROM tasks where id = ?";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setStatus(rs.getBoolean("status"));
				
				list.add(task);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dao.closeConnection();
			return list;
		}
		
		
	}
	
}
