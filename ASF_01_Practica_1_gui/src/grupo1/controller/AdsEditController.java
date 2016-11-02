package grupo1.controller;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException;
import grupo1.dao.AdvertisementEndpointSQLExceptionException;
import grupo1.dao.AdvertisementEndpointStub;
import grupo1.dao.DeleteAd;
import grupo1.dao.GetAd;
import grupo1.dao.GetAdResponse;
import grupo1.dao.GetCategory;
import grupo1.dao.GetCategoryResponse;
import grupo1.dao.GetUser;
import grupo1.dao.GetUserResponse;
import grupo1.dao.InsertAd;
import grupo1.dao.InsertAdResponse;
import grupo1.dao.UpdateAdvertisement;
import grupo1.dto.xsd.Advertisement;
import grupo1.dto.xsd.Category;
import grupo1.dto.xsd.User;
import grupo1.pojo.AdvertisementPOJO;

public class AdsEditController {
	private AdvertisementEndpointStub stub;
	
	public AdsEditController() throws AxisFault {
		stub = new AdvertisementEndpointStub();
	}
	
	public AdvertisementPOJO getAd(int id) throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {
		AdvertisementPOJO adPojo = null;
		
		GetAd req = new GetAd();
		req.setId(id);
		GetAdResponse res = stub.getAd(req);
		Advertisement ad = (Advertisement)res.get_return();
		adPojo = new AdvertisementPOJO(ad);
		
		return adPojo;
	}
	
	public void updateAd(AdvertisementPOJO updatedVersion) throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {		
		GetAd req = new GetAd();
		req.setId(updatedVersion.getId());
		GetAdResponse res = stub.getAd(req);
		Advertisement ad = (Advertisement)res.get_return();
		
		ad.setName(updatedVersion.getName());
		ad.setDescription(updatedVersion.getDescription());
		ad.setPrice(updatedVersion.getPrice());
		
		UpdateAdvertisement updateReq = new UpdateAdvertisement();
		updateReq.setA(ad);
		stub.updateAdvertisement(updateReq);
	}

	public void deleteAds(AdvertisementPOJO advertisementPOJO) {
		try {
			DeleteAd delete = new DeleteAd();
			stub.deleteAd(delete);
		} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException
				| AdvertisementEndpointSQLExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertAd(Advertisement ad, int creatorId, int categoryId) throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {
		GetUser userReq = new GetUser();
		userReq.setId(creatorId);
		GetUserResponse userRes = stub.getUser(userReq);
		User u = (User)userRes.get_return();
		
		GetCategory categoryReq = new GetCategory();
		categoryReq.setId(categoryId);
		GetCategoryResponse categoryRes = stub.getCategory(categoryReq);
		Category c = (Category)categoryRes.get_return();
		
		ad.setCategory(c);
		ad.setAuthor(u);
		
		InsertAd insertAdReq = new InsertAd();
		insertAdReq.setA(ad);
		InsertAdResponse insertAdResponse = stub.insertAd(insertAdReq);
		System.out.println("Inserted ad " + Integer.valueOf(insertAdResponse.get_return()));
	}
}
