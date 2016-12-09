package grupo1.dao.test;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import grupo1.model.*;

public class TestRest {
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		try{
			// Categories --------------
			listCategories(service);
			
			// Insert new cat
			Category newCat = new Category();
			newCat.setName("Wearables");
			newCat.setDescription("Health based devices");
			service.path("rest").path("categories").path("create").accept(MediaType.APPLICATION_XML).post(newCat);
			
			listCategories(service);
			
			// Delete recently created
			//service.path("rest").path("categories").path("delete").path("74").accept(MediaType.APPLICATION_XML).delete();
			
			listCategories(service);
			
			Category c = service.path("rest").path("categories").path("31").get(Category.class);
			System.out.println("Category recovered: " + c.getDescription());
			
			c.setDescription("New description via REST");
			
			service.path("rest").path("categories").path("update").path(String.valueOf(c.getId())).put(c);
			
			listCategories(service);
		}catch(UniformInterfaceException e){ // if code != 20x exception is thrown
			ClientResponse r = e.getResponse();
			System.out.println("categories.GET('application/xml').status: " + r.getStatus());
			System.out.println("categories.GET('application/xml').entity: " + r.getEntity(String.class));
		}
	}
	public static void listCategories(WebResource service) {
		Category[] categories;
		categories = service.path("rest")
				.path("categories")
				.accept(MediaType.APPLICATION_XML)
				.get(Category[].class);
		System.out.println("categories.GET('application/xml').results (con un ARRAY): ");
		for(int i=0;i<categories.length;i++) System.out.println(categories[i].getId() + "\t" + categories[i].getDescription());
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/ASF_01_P2").build();
	}
}
