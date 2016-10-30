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
	
	public DefaultTableModel getAllAdsInTable() throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {
		GetAds req = new GetAds();
		GetAdsResponse res = stub.getAds(req);
		Advertisement[] ads = (Advertisement[])res.get_return();
		
		Object[][] adsInTable = null;
		if (ads != null) {
			// There are objects in database
			adsInTable = new Object[ads.length][4];
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
}
