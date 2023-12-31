package resource;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Task;
import service.Service;

@Path("tasks")
public class TaskResource {
	
	// http://localhost:8080/tasklist/rest/tasks/task
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("task")
	public Response getTasks() {
		
		Service service = new Service();
		List<Task> list = service.listTask();
		
		Response response = Response.ok().entity(list).build();
		
		return response;
	}
	
	
	// http://localhost:8080/tasklist/rest/tasks/task/id
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("task/{id}")
	public Response getTaskById(@PathParam("id") Integer id) {
		
		Service service = new Service();
		List<Task> list = service.searchByTaskId(id);
		
		Response response = Response.ok().entity(list).build();
	
		return response;
		
	}
	
	// http://localhost:8080/tasklist/rest/tasks/task/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("task")
	public Response setTask(Task task) {
		
		Service service = new Service();
		boolean result = service.addTask(task);

		Response response = null;
		
		if(result) {
			
			response = Response.status(Response.Status.CREATED).entity("Tarefa 			adicionada com sucesso").build();
			
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Erro ao adicionar a tarefa")
	                .build();

		}

		return response;
		
	}
	
	
	// http://localhost:8080/tasklist/rest/tasks/task/id
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("task/{id}")
	public Response delTask(@PathParam("id") Integer id) {
		
		Service service = new Service();
		boolean result = service.deleteTask(id);
		
		Response response = null;
		
		if (result) {
			response = Response.status(Response.Status.OK).entity("A tarefa foi 			deletada com sucesso").build();
		} else {
			response = 				Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("				 				Ocorreu algum erro na hora de deletar a tarefa").build();
		}
		
		return response;
		
	}
	
	// http://localhost:8080/tasklist/rest/tasks/task/
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("task")
	public Response putTask(Task task) {
		
		Service service = new Service();
		boolean result = service.alterTask(task);
		
		Response response = null;
		
		if(result) {
			response = Response.status(Response.Status.OK).entity("A tarefa foi 			alterada com sucesso").build();
		} else {
			response = 			Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ocor							  			reu algum erro na hora de alterar a tarefa").build();
		}
		
		return response;
		
	}
	
}
