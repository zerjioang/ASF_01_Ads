package grupo1.rest.restclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestMain {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static final String CONTEXT = "/app";
    private static final String API_PATH = CONTEXT+"/api/public/";
    private static ResteasyClient client;
    
    
    public static void main(String[] args){
        System.out.println("web service main test");
        client = new ResteasyClientBuilder().build();

        //test begin
        
        testUrls();
        aliveTest();
        pingTest();
        verUsuarios();
        deleteUsuarios();
        verUsuarios();
        obtenerUsuario();
    }

    private static void obtenerUsuario() {
        System.out.println("obteniendo usuario (borrado) con id 1");
        ResteasyWebTarget target = client.target("http://"+HOST+":"+PORT+"/app/api/public/read/user/1");
        final Response response = target
                .request()
                .get();

        final String receivedData = response.readEntity(String.class);
        System.out.println("Received data: "+receivedData);
        response.close();
    }

    private static void deleteUsuarios() {
        System.out.println("eliminando usuario con id 1");
        ResteasyWebTarget target = client.target("http://"+HOST+":"+PORT+"/app/api/public/delete/user/1");
        final Response response = target
                .request()
                .get();

        final String receivedData = response.readEntity(String.class);
        System.out.println("Received data: "+receivedData);
        response.close();
    }

    private static void verUsuarios() {
        System.out.println("Ver usuarios actuales");
        ResteasyWebTarget target = client.target("http://"+HOST+":"+PORT+"/app/api/public/list/users");
        final Response response = target
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get();

        final String receivedData = response.readEntity(String.class);
        System.out.println("Received data: "+receivedData);
        response.close();
    }

    public static void testUrls(){
        // Valid URIs
        Response response = client.target("http://"+HOST+":"+PORT+"/app/api/public/list/categories").request().get();
        assertEquals("Status code 01 test", 200, response.getStatus());
        response.close();
        response = client.target("http://"+HOST+":"+PORT+"/app/api/public/ping").request().get();
        assertEquals("Status code 02 test", 200, response.getStatus());
        response.close();
    }
    
    public static void aliveTest() {
        System.out.println("web service endpoint status test");
        ResteasyWebTarget target = client.target("http://"+HOST+":"+PORT+"/app/");
        final Response response = target
                .request()
                .get();
        final String receivedData = response.readEntity(String.class);
        assertEquals("HTML test",
                "<!DOCTYPE html>\r\n" +
                        "<html>\r\n" +
                        "    <head>\r\n" +
                        "        <title>Start Page</title>\r\n" +
                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" +
                        "    </head>\r\n" +
                        "    <body>\r\n" +
                        "        <h1>Grupo 01</h1>\r\n" +
                        "        <h2>API REST WebService</h2>\r\n" +
                        "    </body>\r\n" +
                        "</html>\r\n",
                receivedData);
        response.close();
    }   
    
    public static void pingTest() {
        System.out.println("web service ping test");
        ResteasyWebTarget target = client.target("http://"+HOST+":"+PORT+"/app/api/public/ping");
        final Response response = target
                .request(MediaType.TEXT_PLAIN)
                .get();

        final String receivedData = response.readEntity(String.class);
        System.out.println("Received data: "+receivedData);
        assertEquals("Ping test", "API REST is working", receivedData);
        response.close();
    }

    private static void assertEquals(String item, String a, String b) {
        boolean equal = a.equals(b);
        System.out.println("API check "+item+" = "+(equal?"[SUCCESS]":"[FAILED]"));
    }
    
    private static void assertEquals(String item, int a, int b) {
        boolean equal = a == b;
        System.out.println("API check "+item+" = "+(equal?"[SUCCESS]":"[FAILED]"));
    }
}