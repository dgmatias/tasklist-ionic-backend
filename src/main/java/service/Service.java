package service;

import java.util.List;

import dao.TaskDao;
import model.Task;

public class Service {
	
	TaskDao taskDao = new TaskDao();
	
	public List<Task> listTask() {
		return taskDao.listDB();
	}
	
	public List<Task> searchByTaskId(Integer id) {
		return taskDao.searchByIdDB(id);
	}
	
	public boolean addTask(Task task) {
		return taskDao.addDB(task);
	}
	
	public boolean deleteTask(Integer id) {
		return taskDao.deleteDB(id);
	}
	
	public boolean alterTask(Task task) {
		return taskDao.alterDB(task);
	}
}
