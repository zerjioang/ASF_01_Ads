import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

import javax.xml.bind.*;

import grupo1.dao.*;
import grupo1.dto.xsd.*;
import grupo1.pojo.*;

public class MyTests {
	private static final String USER_XML = "./files/user-jaxb.xml";
	private static final String CATEGORY_XML = "./files/category-jaxb.xml";
	private static final String ADVERTISEMENT_XML = "./files/advertisement-jaxb.xml";

	public static void main(String[] args) {
		
		try{
			System.out.println("Hello moto!");
			AdvertisementEndpointStub stub = new AdvertisementEndpointStub();
			
			GetCategories req = new GetCategories();
			GetCategoriesResponse res = stub.getCategories(req);
			Category[] categories = (Category[])res.get_return();
			ArrayList<CategoryPOJO> catPojos = new ArrayList<CategoryPOJO>();
			for (Category category : categories) {
				System.out.println("Category from db: " + category.getName());
				
				CategoryPOJO cat = new CategoryPOJO();
				cat.setId(category.getId());
				cat.setName(category.getName());
				cat.setDescription(category.getDescription());
				
				catPojos.add(cat);
			}
			/*
			// Now let's use JAXB to store the categories
			JAXBContext categoriesContext = JAXBContext.newInstance(Categories.class);
			Marshaller categoriesMarshaller = categoriesContext.createMarshaller();
			categoriesMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Writer w = null;
			try {
				w = new FileWriter(CATEGORY_XML);
				categoriesMarshaller.marshal(catPojos, w);
			} finally {
				try {
					w.close();
				} catch (Exception e) {
				}
				
			}
			// End writing files
			*/
			GetUser userReq = new GetUser();
			userReq.setId(43);
			GetUserResponse userRes = stub.getUser(userReq);
			User u = (User)userRes.get_return();
			System.out.println("User from db: " + u.getName());
			

        } catch(Exception e){
            e.printStackTrace();
            System.err.println("\n\n\n");
        }
	}

}
