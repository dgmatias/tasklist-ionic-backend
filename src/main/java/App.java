import java.util.List;

import dao.TaskDao;
import model.Task;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		

		
		TaskDao taskDao = new TaskDao();
		
		Task task = new Task();
		
		task.setName("almoçar");
		taskDao.add(task);
		
		List<Task> list = taskDao.listDB();
		list.forEach(result -> System.out.println(result.getName()));
	}

}
