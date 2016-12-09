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
			System.out.println("=== CATEGORIES ===");
			listCategories(service);
			
			// Insert new cat
			Category newCat = new Category();
			newCat.setName("Wearables");
			newCat.setDescription("Health based devices");
			service.path("rest").path("categories").path("create").accept(MediaType.APPLICATION_XML).post(newCat);
			
			listCategories(service);
			
			// Delete category
			//service.path("rest").path("categories").path("delete").path("74").accept(MediaType.APPLICATION_XML).delete();
			
			listCategories(service);
			
			Category c = service.path("rest").path("categories").path("31").get(Category.class);
			System.out.println("Category recovered: " + c.toString());
			
			c.setDescription("New description via REST");
			
			service.path("rest").path("categories").path("update").path(String.valueOf(c.getId())).put(c);
			
			listCategories(service);
			
			// Users --------------
			System.out.println("=== USERS ===");
			listUsers(service);
			
			// Insert new user
			User newUser = new User();
			newUser.setName("REST User");
			newUser.setEmail("rest@isbetter.com");
			newUser.setPassword("s3cret");
			service.path("rest").path("users").path("create").accept(MediaType.APPLICATION_XML).post(newUser);
			
			listUsers(service);
			
			// Delete user
			//service.path("rest").path("users").path("delete").path("48").accept(MediaType.APPLICATION_XML).delete();
			
			listUsers(service);
			
			User u = service.path("rest").path("users").path("49").get(User.class);
			System.out.println("User recovered: " + u.toString());
			
			u.setName("New name via REST");
			
			service.path("rest").path("users").path("update").path(String.valueOf(u.getId())).put(u);
			
			listUsers(service);
			
			// Advertisements --------------
			System.out.println("=== ADS ===");
			listAds(service);
			
			// Insert new user
			Advertisement newAd = new Advertisement();
			newAd.setAuthor(u);
			newAd.setCategory(c);
			newAd.setDescription("Ad created via rest");
			newAd.setName("Rest advertisement");
			service.path("rest").path("advertisements").path("create").accept(MediaType.APPLICATION_XML).post(newAd);
			
			listAds(service);
			
			// Delete ad
			//service.path("rest").path("advertisements").path("delete").path("34").accept(MediaType.APPLICATION_XML).delete();
			
			listAds(service);
			
			Advertisement a = service.path("rest").path("advertisements").path("35").get(Advertisement.class);
			System.out.println("Ad recovered: " + a.toString());
			
			a.setName("New name via REST");
			
			service.path("rest").path("advertisements").path("update").path(String.valueOf(a.getId())).put(a);
			
			listAds(service);
		}catch(UniformInterfaceException e){ // if code != 20x exception is thrown
			ClientResponse r = e.getResponse();
			System.out.println("users.GET('application/xml').status: " + r.getStatus());
			System.out.println("users.GET('application/xml').entity: " + r.getEntity(String.class));
		}
	}
	
	public static void listCategories(WebResource service) {
		Category[] categories;
		categories = service.path("rest")
				.path("categories")
				.accept(MediaType.APPLICATION_XML)
				.get(Category[].class);
		System.out.println("categories.GET('application/xml').results (con un ARRAY): ");
		for(int i=0;i<categories.length;i++) System.out.println(categories[i].toString());
	}
	
	public static void listUsers(WebResource service) {
		User[] users;
		users = service.path("rest")
				.path("users")
				.accept(MediaType.APPLICATION_XML)
				.get(User[].class);
		System.out.println("users.GET('application/xml').results (con un ARRAY): ");
		for(int i=0;i<users.length;i++) System.out.println(users[i].toString());
	}
	
	public static void listAds(WebResource service) {
		Advertisement[] ads;
		ads = service.path("rest")
				.path("advertisements")
				.accept(MediaType.APPLICATION_XML)
				.get(Advertisement[].class);
		System.out.println("advertisements.GET('application/xml').results (con un ARRAY): ");
		for(int i=0;i<ads.length;i++) System.out.println(ads[i].toString());
	}
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/ASF_01_P2").build();
	}
}
