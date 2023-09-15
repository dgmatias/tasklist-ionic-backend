package resource;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
	
	
	
}
