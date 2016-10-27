import org.apache.axis2.client.ServiceClient;

import grupo1.dao.AdvertisementEndpointStub;

public class MyTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello moto!");
		
		try{
			AdvertisementEndpointStub stub = new AdvertisementEndpointStub("http://localhost:8080/axis2/services/AdvertisementEndpoint");
			

        } catch(Exception e){
            e.printStackTrace();
            System.err.println("\n\n\n");
        }
	}

}
