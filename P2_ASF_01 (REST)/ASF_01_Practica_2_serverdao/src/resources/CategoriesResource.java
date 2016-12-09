package resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import grupo1.model.*;
import grupo1.dao.GestorBD;

@Path("/categories")
public class CategoriesResource {
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Category> getCategories() {
		ArrayList<Category> categories = null;
		try {
			categories = GestorBD.getInstance().getCategories();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return categories;
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Category getCategory(@PathParam("id") int id) {
		try {
			return GestorBD.getInstance().getCategory(id);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	
	@POST
    @Path("/create")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response addCategory(Category c) {
		try {
			GestorBD.getInstance().insertCategory(c);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			return Response.serverError().build();
		}
	}
	
	@PUT
    @Path("/update/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateCategory(@PathParam("id") int id, Category c) {
		try {
			GestorBD.getInstance().updateCategory(c);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			return Response.serverError().build();
		}
	}
	
	@DELETE
    @Path("/delete/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response deleteCategory(@PathParam("id") int id) {
		Category catToRemove;
		try {
			catToRemove = GestorBD.getInstance().getCategory(id);
			GestorBD.getInstance().deleteCategory(catToRemove);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			return Response.serverError().build();
		}
	}
}
