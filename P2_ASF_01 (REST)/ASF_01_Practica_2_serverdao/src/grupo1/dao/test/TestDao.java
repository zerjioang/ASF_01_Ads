package grupo1.dao.test;

import java.sql.*;
import java.util.ArrayList;

import grupo1.dao.GestorBD;
import grupo1.model.*;

public class TestDao {
	private GestorBD gbd;
	public TestDao() {
		this.gbd = GestorBD.getInstance();
	}
	
	public void testUsers(){
        try {
			User u = new User();
			u.setEmail("aitor.brazaola@opendeusto.es");
			u.setName("Aitor");
			u.setPassword("123456");
						
			int userId = gbd.insertUser(u);
			u = gbd.getUser(userId);
			System.out.println("User created:" + u.toString());
            
			System.out.println("Let's delete the recently added user");
			gbd.deleteUser(u);
			System.out.println("Deleted successfully. Let's insert it again");
			
			userId = gbd.insertUser(u);
			u = gbd.getUser(userId);
			System.out.println("User created:" + u.toString());
			
        } catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public void testCategories(){
        try {
			
			Category c = new Category();
			c.setName("Technology");
			c.setDescription("Electronic devices and gadgets");
			int catId = gbd.insertCategory(c);
			c = gbd.getCategory(catId);
			System.out.println("Category created:" + c.toString());
			
			System.out.println("Let's delete recently added category");
			gbd.deleteCategory(c);
			System.out.println("Deleted successfully. Let's insert it again");
			
			catId = gbd.insertCategory(c);
			c = gbd.getCategory(catId);
			System.out.println("Category created:" + c.toString());
			
			System.out.println("Now, give me a list of all categories created");
			System.out.println(gbd.getCategories());
			
        } catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public void testAdvertisements() {
		try {
			ArrayList<Category> categories = gbd.getCategories();
			ArrayList<User> users = gbd.getUsers();
			
			Advertisement ad = new Advertisement();
			ad.setName("SEAT Ibiza SC");
			ad.setDescription("Muy bienc uidado, edicion 25 aniversario, llantas de 17 pulgadas");
			ad.setCategoryId(categories.get(0).getId());
			ad.setAuthorId(users.get(0).getId());
			ad.setPrice((float) 6900);
			
			int adId = gbd.insertAd(ad);
			gbd.deleteAd(ad);
			adId = gbd.insertAd(ad);
			
			ad.setName("SEAT Alhambra");
			ad.setDescription("Coche familiar");
			ad.setId(adId);
			gbd.updateAdvertisement(ad);
			
			System.out.println(gbd.getAds());
			
			System.out.println("Lets search Inca");
			ArrayList<Advertisement> adsQueried = gbd.getAdsByQueryOnName("Inca");
			for (Advertisement advertisement : adsQueried) {
				System.out.println(advertisement.toString());
			}
			System.out.println("End");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    
    public static void main(String[] args) {
        TestDao test = new TestDao();
        
        test.testUsers();
        test.testCategories();
        test.testAdvertisements();
        
        System.out.println("Done!");
    }
}
