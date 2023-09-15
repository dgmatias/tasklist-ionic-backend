package resource;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import model.Task;
import service.Service;

@Path("task")
public class TaskResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getTasks() {
		
		Service service = new Service();
		List<Task> list = service.listTask();
		
		Response response = Response.ok().entity(list).build();
		
		return response;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listById")
	//http://localhost:8080/tasklist/rest/task/listById?id=
	public Response getTaskById(@QueryParam("id") Integer id) {
		
		Service service = new Service();
		List<Task> list = service.searchByTaskId(id);
		
		Response response = Response.ok().entity(list).build();
	
		return response;
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("add")
	public Response setTask(@QueryParam("name") String name) {
		
		Service service = new Service();
		Task task = new Task();
		
		task.setName(name);
		boolean result = service.addTask(task);
		
		Response response;
		
		if(result) {
			
			response = Response.status(Response.Status.CREATED).entity("{\"message\": \"Tarefa adicionada com sucesso\"}").build();
			
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("{\"error\": \"Erro ao adicionar a tarefa\"}")
	                .build();

		}

		return response;
		
	}
	
	
}
