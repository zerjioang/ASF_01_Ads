package grupo1.controller;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException;
import grupo1.dao.AdvertisementEndpointSQLExceptionException;
import grupo1.dao.AdvertisementEndpointStub;
import grupo1.dao.DeleteUser;
import grupo1.dao.GetUser;
import grupo1.dao.GetUserResponse;
import grupo1.dao.UpdateUser;
import grupo1.dto.xsd.User;
import grupo1.pojo.UserPOJO;

public class UsersEditController {
	private AdvertisementEndpointStub stub;
	public UsersEditController() throws AxisFault {
		stub = new AdvertisementEndpointStub();
	}
	
	public UserPOJO getUser(int id) throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {
		UserPOJO userPojo = null;
		
		GetUser req = new GetUser();
		req.setId(id);
		GetUserResponse res = stub.getUser(req);
		User u = (User)res.get_return();
		userPojo = new UserPOJO(u);
		
		return userPojo;
	}
	
	public void updateUser(UserPOJO updatedVersion) throws RemoteException, AdvertisementEndpointClassNotFoundExceptionException, AdvertisementEndpointSQLExceptionException {		
		GetUser req = new GetUser();
		req.setId(updatedVersion.getId());
		GetUserResponse res = stub.getUser(req);
		User u = (User)res.get_return();
		
		u.setName(updatedVersion.getName());
		u.setEmail(updatedVersion.getEmail());
		u.setPassword(updatedVersion.getPassword());
		
		UpdateUser updateReq = new UpdateUser();
		updateReq.setU(u);
		stub.updateUser(updateReq);
	}

	public void deleteUser(UserPOJO userPOJO) {
		try {
			DeleteUser delete = new DeleteUser();
			stub.deleteUser(delete);
		} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException
				| AdvertisementEndpointSQLExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
