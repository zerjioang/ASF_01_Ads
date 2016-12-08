package resources;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import grupo1.dao.GestorBD;
import grupo1.model.*;

public class CategoryResource {
	private int id;
	
	public CategoryResource(int id) throws ClassNotFoundException, SQLException {
		this.id = id;
		
		// Only to check if exists, if not throws an exception
		GestorBD.getInstace().getCategory(id);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Category getCategory(){
		Category c = null;
		
		try {
			c = GestorBD.getInstace().getCategory(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
}
