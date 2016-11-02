package grupo1.controller;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.xml.bind.*;

import org.apache.axis2.AxisFault;

import grupo1.dao.*;
import grupo1.dto.xsd.*;
import grupo1.pojo.*;

public class AdminController {
	private static final String USER_XML = "./files/user-jaxb.xml";
	private static final String CATEGORY_XML = "./files/category-jaxb.xml";
	private static final String ADVERTISEMENT_XML = "./files/advertisement-jaxb.xml";
	
	private AdvertisementEndpointStub stub;
	
	public AdminController() throws AxisFault {
		stub = new AdvertisementEndpointStub();
	}
	
	public DefaultTableModel searchAds(String query) throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {
		GetAdsByQueryOnName req = new GetAdsByQueryOnName();
		req.setQuery(query);
		GetAdsByQueryOnNameResponse res = stub.getAdsByQueryOnName(req);
		Advertisement[] ads = (Advertisement[])res.get_return();
		
		Object[][] adsInTable = null;
		if (ads != null) {
			// There are objects in database
			adsInTable = new Object[ads.length][5];
			
			for (int i = 0; i < ads.length; i++) {
				adsInTable[i][0] = ads[i].getId();
				adsInTable[i][1] = ads[i].getName();
				adsInTable[i][2] = ads[i].getDescription();
				adsInTable[i][3] = ads[i].getAuthor().getName();
				adsInTable[i][4] = ads[i].getPrice();
			}
		} else {
			// Empty table
			adsInTable = new Object[][] {
        		{0, "None", "None", "None", 0}
        	};
		}
		
		return new DefaultTableModel(adsInTable, new String[] {
        		"ID", "Title", "Description", "Username", "Price"
        	});
	}
	
	public DefaultTableModel getAllAdsInTable() throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {
		GetAds req = new GetAds();
		GetAdsResponse res = stub.getAds(req);
		Advertisement[] ads = (Advertisement[])res.get_return();
		
		Object[][] adsInTable = null;
		if (ads != null) {
			// There are objects in database
			adsInTable = new Object[ads.length][5];
			
			for (int i = 0; i < ads.length; i++) {
				adsInTable[i][0] = ads[i].getId();
				adsInTable[i][1] = ads[i].getName();
				adsInTable[i][2] = ads[i].getDescription();
				adsInTable[i][3] = ads[i].getAuthor().getName();
				adsInTable[i][4] = ads[i].getPrice();
			}
		} else {
			// Empty table
			adsInTable = new Object[][] {
        		{0, "None", "None", "None", 0}
        	};
		}
		
		return new DefaultTableModel(adsInTable, new String[] {
        		"ID", "Title", "Description", "Username", "Price"
        	});
	}
	
	public DefaultTableModel getAllCategoriesInTable() throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {
		GetCategories req = new GetCategories();
		GetCategoriesResponse res = stub.getCategories(req);
		Category[] categories = (Category[])res.get_return();
		
		Object[][] categoriesInTable = null;
		if (categories != null) {
			// There are objects in database
			categoriesInTable = new Object[categories.length][3];
			
			for (int i = 0; i < categories.length; i++) {
				categoriesInTable[i][0] = categories[i].getId();
				categoriesInTable[i][1] = categories[i].getName();
				categoriesInTable[i][2] = categories[i].getDescription();
			}
		} else {
			// Empty table
			categoriesInTable = new Object[][] {
        		{0, "None", "None"}
        	};
		}
		
		return new DefaultTableModel(categoriesInTable, new String[] {
				"ID", "Name", "Description"
        	});
	}
	
	public DefaultTableModel getAllUsersInTable() throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {
		GetUsers req = new GetUsers();
		GetUsersResponse res = stub.getUsers(req);
		User[] ads = (User[])res.get_return();
		
		Object[][] usersInTable = null;
		if (ads != null) {
			// There are objects in database
			usersInTable = new Object[ads.length][5];
			
			for (int i = 0; i < ads.length; i++) {
				usersInTable[i][0] = ads[i].getId();
				usersInTable[i][1] = ads[i].getName();
				usersInTable[i][2] = ads[i].getEmail();
				usersInTable[i][3] = ads[i].getPassword();
				usersInTable[i][4] = ads[i].getSignupDate().toString();
			}
		} else {
			// Empty table
			usersInTable = new Object[][] {
				{0, "none", "none", "none", "none"}
        	};
		}
		
		return new DefaultTableModel(usersInTable, new String[] {
				"ID", "Name", "Email", "Password", "Registration date"
        	});
	}
	
	public void backupData() throws JAXBException, IOException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {
		JAXBContext categoriesContext = JAXBContext.newInstance(Categories.class);
		JAXBContext usersContext = JAXBContext.newInstance(Users.class);
		JAXBContext advertisementsContext = JAXBContext.newInstance(Advertisements.class);
		
		Marshaller categoriesMarshaller = categoriesContext.createMarshaller();
		Marshaller usersMarshaller = usersContext.createMarshaller();
		Marshaller advertisementsMarshaller = advertisementsContext.createMarshaller();
		
		categoriesMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		usersMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		advertisementsMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Writer w = null;
		
		GetCategories categoriesReq = new GetCategories();
		GetCategoriesResponse categoriesRes = stub.getCategories(categoriesReq);
		Category[] categories = (Category[])categoriesRes.get_return();
		
		GetUsers usersReq = new GetUsers();
		GetUsersResponse usersRes = stub.getUsers(usersReq);
		User[] users = (User[])usersRes.get_return();
		
		GetAds adsReq = new GetAds();
		GetAdsResponse adsRes = stub.getAds(adsReq);
		Advertisement[] ads = (Advertisement[])adsRes.get_return();
		
		// Categories
		ArrayList<CategoryPOJO> categoryPOJOS = new ArrayList<CategoryPOJO>();
		for (Category category : categories) {
			CategoryPOJO catPojo = new CategoryPOJO(category);
			categoryPOJOS.add(catPojo);
		}
		Categories categoriesCollection = new Categories();
		categoriesCollection.setCategories(categoryPOJOS);
		
		// Users
		ArrayList<UserPOJO> userPOJOS = new ArrayList<UserPOJO>();
		for (User user : users) {
			UserPOJO userPOJO = new UserPOJO(user);
			userPOJOS.add(userPOJO);
		}
		Users usersCollection = new Users();
		usersCollection.setUsers(userPOJOS);
		
		// Ads
		ArrayList<AdvertisementPOJO> advertisementPOJOS = new ArrayList<AdvertisementPOJO>();
		for (Advertisement ad : ads) {
			AdvertisementPOJO adPojo = new AdvertisementPOJO(ad);
			advertisementPOJOS.add(adPojo);
		}
		Advertisements advertisementCollection = new Advertisements();
		advertisementCollection.setAdvertisements(advertisementPOJOS);
		
		// Write to disk
		try {
			// Categories
			w = new FileWriter(CATEGORY_XML);
			categoriesMarshaller.marshal(categoriesCollection, w);
			
			// Users
			w = new FileWriter(USER_XML);
			usersMarshaller.marshal(usersCollection, w);

			// Advertisements
			w = new FileWriter(ADVERTISEMENT_XML);
			advertisementsMarshaller.marshal(advertisementCollection, w);
		} finally {
			try {
				w.close();
			} catch (Exception e) {
			}
			
		}
	}
	
	public void restoreData() throws JAXBException, IOException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {
		JAXBContext categoriesContext = JAXBContext.newInstance(Categories.class);
		JAXBContext usersContext = JAXBContext.newInstance(Users.class);
		JAXBContext advertisementsContext = JAXBContext.newInstance(Advertisements.class);
		
		Unmarshaller categoriesUnmarshaller = categoriesContext.createUnmarshaller();
		Unmarshaller usersUnmarshaller = usersContext.createUnmarshaller();
		Unmarshaller advertisementsUnmarshaller = advertisementsContext.createUnmarshaller();
		
		DeleteSchema deleteSchemaReq = new DeleteSchema();
		stub.deleteSchema(deleteSchemaReq);
		
		Users users = (Users) usersUnmarshaller.unmarshal(new FileInputStream(USER_XML));
		
		for (UserPOJO u : users.getUsers()) {
			User user = new User();
			user.setId(u.getId());
			user.setName(u.getName());
			user.setEmail(u.getEmail());
			user.setPassword(u.getPassword());
			user.setSignupDate(u.getSignupDate());
			
			InsertUser insertUserReq = new InsertUser();
			insertUserReq.setU(user);
			stub.insertUser(insertUserReq);
			
			System.out.println("User " + user.getEmail() + " restored successfully.");
		}
		
		Categories categories = (Categories) categoriesUnmarshaller.unmarshal(new FileInputStream(CATEGORY_XML));
		
		for (CategoryPOJO c : categories.getCategories()) {
			Category category = new Category();
			
			category.setId(c.getId());
			category.setName(c.getName());
			category.setDescription(c.getDescription());
			
			InsertCategory insertCategoryReq = new InsertCategory();
			insertCategoryReq.setC(category);
			stub.insertCategory(insertCategoryReq);
			
			System.out.println("Category " + category.getName() + " restored successfully.");
		}
		
		Advertisements ads = (Advertisements) advertisementsUnmarshaller.unmarshal(new FileInputStream(ADVERTISEMENT_XML));
		
		for (AdvertisementPOJO a : ads.getAdvertisements()) {
			Advertisement ad = new Advertisement();
			ad.setId(a.getId());
			ad.setName(a.getName());
			ad.setDescription(a.getDescription());
			ad.setPrice(a.getPrice());
			
			User author = new User();
			author.setId(a.getAuthor().getId());
			author.setName(a.getAuthor().getName());
			author.setPassword(a.getAuthor().getPassword());
			author.setSignupDate(a.getAuthor().getSignupDate());
			author.setEmail(a.getAuthor().getEmail());
			
			ad.setAuthor(author);
			
			Category category = new Category();
			category.setId(a.getCategory().getId());
			category.setName(a.getCategory().getName());
			category.setDescription(a.getCategory().getDescription());
			
			ad.setCategory(category);
			
			InsertAd insertAdReq = new InsertAd();
			insertAdReq.setA(ad);
			stub.insertAd(insertAdReq);
			
			System.out.println("Ad " + ad.getName() + " restored successfully.");
		}
	}
	
	public static void main(String[] args) {
		AdminController controller;
		try {
			controller = new AdminController();
			//controller.backupData();
			controller.restoreData();
		} catch (JAXBException | IOException | AdvertisementEndpointClassNotFoundExceptionException | AdvertisementEndpointSQLExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteUser(int id) {
		
	}

	public void deleteCategory(int id) {
		
	}
}
