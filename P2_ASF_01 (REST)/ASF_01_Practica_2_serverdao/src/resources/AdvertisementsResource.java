package resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import grupo1.model.*;
import grupo1.dao.GestorBD;

@Path("/advertisements")
public class AdvertisementsResource {
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Advertisement> getAdvertisements() {
		ArrayList<Advertisement> advertisements = null;
		try {
			advertisements = GestorBD.getInstance().getAds();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return advertisements;
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Advertisement getAdvertisement(@PathParam("id") int id) {
		try {
			return GestorBD.getInstance().getAd(id);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	
	@POST
    @Path("/create")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response addAdvertisement(Advertisement a) {
		try {
			GestorBD.getInstance().insertAd(a);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			return Response.serverError().build();
		}
	}
	
	@PUT
    @Path("/update/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateAdvertisement(@PathParam("id") int id, Advertisement a) {
		try {
			GestorBD.getInstance().updateAdvertisement(a);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			return Response.serverError().build();
		}
	}
	
	@DELETE
    @Path("/delete/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response deleteAdvertisement(@PathParam("id") int id) {
		Advertisement advertisementToRemove;
		try {
			advertisementToRemove = GestorBD.getInstance().getAd(id);
			GestorBD.getInstance().deleteAd(advertisementToRemove);
			return Response.ok().build();
		} catch (ClassNotFoundException | SQLException e) {
			return Response.serverError().build();
		}
	}
}
