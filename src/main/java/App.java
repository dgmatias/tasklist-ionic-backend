import java.util.List;

import dao.TaskDao;
import model.Task;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		TaskDao taskDao = new TaskDao();
		List<Task> list = taskDao.listDB();
		
		list.forEach(task -> System.out.println(task.getName()));
	}

}
