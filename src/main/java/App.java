import java.util.List;

import model.Task;
import service.Service;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Service service = new Service();
		
		Task task = new Task();
		
		//task.setStatus(false);
		//task.setName("compra mamão");
		//task.setId(2);
		
		//service.addTask(task);
		//service.deleteTask(9);
		//service.alterTask(task);
		
		
		List<Task> list = service.listTask();
		//List<Task> list = service.searchByTaskId(8);
		
		list.forEach(result -> System.out.println(result.toString()));
	}

}
