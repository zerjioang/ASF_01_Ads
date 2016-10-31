package grupo1.controller;

import java.rmi.RemoteException;

import javax.swing.table.DefaultTableModel;
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
}
