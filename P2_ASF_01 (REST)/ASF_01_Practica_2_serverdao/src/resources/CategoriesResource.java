package resources;

import java.sql.SQLException;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/categories")
public class CategoriesResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@Path("{categoryId}")
	public CategoryResource getCategory(@PathParam("categoryId") int id) {
		CategoryResource cR = null;
		try {
			cR = new CategoryResource(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cR;
	}
}
