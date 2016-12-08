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

		// Get XML for application
		try{
			Category c = service.path("rest").path("categories").path("31").accept(MediaType.APPLICATION_XML).get(Category.class);
			System.out.println(c);
		}catch(UniformInterfaceException e){ // if code != 20x exception is thrown
			ClientResponse r = e.getResponse();
			System.out.println("categories.GET('application/xml').status: " + r.getStatus());
			System.out.println("categories.GET('application/xml').entity: " + r.getEntity(String.class));
		}

//		// POST
//		Todo todo = new Todo("3", "Finish MDISS" );
//		todo.setDescription("Finish MDISS");
//		// TYPE is the type of content consumes by the service/method
//		// ACCEPT is the type of content returned by the service/method
//		// PUT is the type of operation invoked. The first param is the content returned and the second one the values received.
//		ClientResponse cr1 = service.path("rest").path("todos").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, todo);
//		if (cr1.getStatus() == 201){ // Return code should be 201 == created resource
//			System.out.println("todos.POST('application/xml').status: " + cr1.getStatus());
//			System.out.println("todos.POST('application/xml').location: " + cr1.getLocation());
//			
//		}else{ // Or code 409 == resource already exists 
//			System.out.println("todos.POST('application/xml').status: " + cr1.getStatus());
//			System.out.println("todos.POST('application/xml').entity: " + cr1.getEntity(String.class));
//		}
//		
//		// POST (with error)
//		try{
//			Todo todo2 = new Todo("3", "Finish MDISS" );
//			service.path("rest").path("todos").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).post(todo2);
//		}catch(UniformInterfaceException e){
//			ClientResponse r = e.getResponse();
//			System.out.println("todos.POST('application/xml').status: " + r.getStatus());
//			System.out.println("todos.POST('application/xml').entity: " + r.getEntity(String.class));
//		}
//
//		// PUT
//		Todo todo3 = new Todo("3", "Finish MDISS in 12 months" );
//		ClientResponse cr3 = service.path("rest").path("todos").path(todo3.getId()).type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).put(ClientResponse.class, todo3);
//		if (cr3.getStatus() == 201){
//			System.out.println("todos.{id}.PUT('application/xml').status: " + cr3.getStatus());
//			System.out.println("todos.{id}.PUT('application/xml').location: " + cr3.getLocation());
//		}else if (cr3.getStatus() == 204){
//				System.out.println("todos.{id}.PUT('application/xml').status: " + cr3.getStatus());
//		}else{
//			System.out.println("todos.{id}.PUT('application/xml').status: " + cr3.getStatus());
//			System.out.println("todos.{id}.PUT('application/xml').entity: " + cr3.getEntity(String.class));
//		}
//
//		// Get JSON for application		
//		ClientResponse cr4 = service.path("rest").path("todos").accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
//		if (cr4.getStatus() == 200){
//			System.out.println("todos.GET('application/json').status: " + cr4.getStatus());
//			System.out.println("todos.GET('application/json').results (con una LIST): ");
//			List<Todo> lista = cr4.getEntity(new GenericType<List<Todo>>(){}); 
//			for(int i=0;i<lista.size();i++) System.out.println(lista.get(i).getId() + "\t" + lista.get(i).getSummary());			
//		}else{
//			System.out.println("todos.GET('application/json').status: " + cr4.getStatus());
//			System.out.println("todos.GET('application/json').entity: " + cr4.getEntity(String.class));
//		}
//		
//		// DELETE
//		try{
//			service.path("rest").path("todos").path("3").delete();
//			System.out.println("Todo 3 deleted");
//		}catch(UniformInterfaceException e){
//			ClientResponse r = e.getResponse();
//			System.out.println("todos.{id}.DEL.status: " + r.getStatus());
//			System.out.println("todos.{id}.DEL.entity: " + r.getEntity(String.class));
//		}		
//	
//		try{
//			// Get JSON for application
//			System.out.println("todos.GET('application/json').results (directamente imprimiendo): ");
//			System.out.println(service.path("rest").path("todos").accept(MediaType.APPLICATION_JSON).get(String.class));
//			// Get the summary of Todo with id 1
//			System.out.println(service.path("rest").path("todos").path("1").path("summary").queryParam("param", "nada").accept(MediaType.TEXT_PLAIN).get(String.class));		
//		}catch(UniformInterfaceException e){
//			ClientResponse r = e.getResponse();
//			System.out.println("todos.GET.status: " + r.getStatus());
//			System.out.println("todos.GET.entity: " + r.getEntity(String.class));
//		}	
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/ASF_01_P2").build();
	}
}
