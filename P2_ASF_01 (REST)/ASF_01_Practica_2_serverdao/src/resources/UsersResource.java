package resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import grupo1.model.*;
import grupo1.dao.GestorBD;

@Path("/users")
public class UsersResource {
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<User> getUsers() {
		ArrayList<User> users = null;
		try {
			users = GestorBD.getInstance().getUsers();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public User getUser(@PathParam("id") int id) {
		try {
			return GestorBD.getInstance().getUser(id);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	
	@POST
    @Path("/create")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response addUser(User u) {
		try {
			GestorBD.getInstance().insertUser(u);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			return Response.serverError().build();
		}
	}
	
	@PUT
    @Path("/update/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateUser(@PathParam("id") int id, User u) {
		try {
			GestorBD.getInstance().updateUser(u);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			return Response.serverError().build();
		}
	}
	
	@DELETE
    @Path("/delete/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response deleteUser(@PathParam("id") int id) {
		User userToRemove;
		try {
			userToRemove = GestorBD.getInstance().getUser(id);
			GestorBD.getInstance().deleteUser(userToRemove);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			return Response.serverError().build();
		}
	}
}
