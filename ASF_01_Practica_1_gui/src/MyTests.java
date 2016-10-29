import java.io.FileWriter;
import java.io.Writer;

import javax.xml.bind.*;

import grupo1.dao.*;
import grupo1.dto.xsd.*;

public class MyTests {
	private static final String USER_XML = "./files/user-jaxb.xml";

	public static void main(String[] args) {
		
		try{
			System.out.println("Hello moto!");
			AdvertisementEndpointStub stub = new AdvertisementEndpointStub();
			GetCategories req = new GetCategories();
			GetCategoriesResponse res = stub.getCategories(req);
			Category[] categories = (Category[])res.get_return();
			for (Category category : categories) {
				System.out.println("Category from db: " + category.getName());
			}
			
			
			GetUser userReq = new GetUser();
			userReq.setId(4);
			GetUserResponse userRes = stub.getUser(userReq);
			User u = (User)userRes.get_return();
			System.out.println("User from db: " + u.getName());
			
			/*
			// Now let's use JAXB to send a user
			User newUser = new User();
			newUser.setEmail("aitor.brazaola@protonmail.com");
			newUser.setName("Aitortxu");
			newUser.setPassword("mipasswordsecreto");
			
			JAXBContext context = JAXBContext.newInstance(Category.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(newUser, System.out);
			Writer w = null;
			try {
				w = new FileWriter(USER_XML);
				m.marshal(newUser, w);
			} finally {
				try {
					w.close();
				} catch (Exception e) {
				}
				
			}*/

        } catch(Exception e){
            e.printStackTrace();
            System.err.println("\n\n\n");
        }
	}

}
