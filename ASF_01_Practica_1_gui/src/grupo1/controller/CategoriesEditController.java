package grupo1.controller;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException;
import grupo1.dao.AdvertisementEndpointSQLExceptionException;
import grupo1.dao.AdvertisementEndpointStub;
import grupo1.dao.DeleteCategory;
import grupo1.dao.GetCategory;
import grupo1.dao.GetCategoryResponse;
import grupo1.dao.UpdateCategory;
import grupo1.dto.xsd.Category;
import grupo1.pojo.CategoryPOJO;

public class CategoriesEditController {
	private AdvertisementEndpointStub stub;
	
	public CategoriesEditController() throws AxisFault {
		stub = new AdvertisementEndpointStub();
	}
	
	public CategoryPOJO getCategory(int id) throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {
		CategoryPOJO catPojo = null;
		
		GetCategory req = new GetCategory();
		req.setId(id);
		GetCategoryResponse res = stub.getCategory(req);
		Category cat = (Category)res.get_return();
		catPojo = new CategoryPOJO(cat);
		
		return catPojo;
	}
	
	public void updateCategory(CategoryPOJO updatedVersion) throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {		
		GetCategory req = new GetCategory();
		req.setId(updatedVersion.getId());
		GetCategoryResponse res = stub.getCategory(req);
		Category cat = (Category)res.get_return();
		
		cat.setName(updatedVersion.getName());
		cat.setDescription(updatedVersion.getDescription());
		
		UpdateCategory updateReq = new UpdateCategory();
		updateReq.setC(cat);
		stub.updateCategory(updateReq);
	}
	
	public void deleteCategory(CategoryPOJO deletedVersion) throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {		
		DeleteCategory req = new DeleteCategory();
		stub.deleteCategory(req);
	}
}
