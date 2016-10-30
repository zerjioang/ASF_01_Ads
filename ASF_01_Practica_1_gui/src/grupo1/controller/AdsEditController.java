package grupo1.controller;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException;
import grupo1.dao.AdvertisementEndpointSQLExceptionException;
import grupo1.dao.AdvertisementEndpointStub;
import grupo1.dao.GetAd;
import grupo1.dao.GetAdResponse;
import grupo1.dao.UpdateAdvertisement;
import grupo1.dto.xsd.Advertisement;
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
}
