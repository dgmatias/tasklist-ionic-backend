import java.util.List;

import dao.TaskDao;
import model.Task;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		TaskDao taskDao = new TaskDao();
		
		Task task = new Task();
		
		//task.setName("ir ao mercado");
		
		//askDao.add(task);
		//taskDao.delete(3);
		//taskDao.alter(task);
		
		
		//List<Task> list = taskDao.listDB();
		List<Task> list = taskDao.searchById(5);
		
		list.forEach(result -> System.out.println(result.toString()));
	}

}
