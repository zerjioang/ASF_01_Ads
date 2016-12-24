package grupo1.dao.test;

import java.sql.*;
import java.util.ArrayList;

import grupo1.dao.GestorBD;
import grupo1.dto.*;

public class Test {
	private GestorBD gbd;
	public Test() {
		this.gbd = new GestorBD();
	}
	
	private void testConnection() {
		gbd.abrirSession();
		gbd.cerrarSession();
	}
	
	public void testUsers(){
        try {
        	gbd.abrirSession();
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
			
			System.out.println("Now let's change the user name by: UpdatedName");
			u.setName("UpdathjhjhjhjedName");
			gbd.updateUser(u);
			
			gbd.cerrarSession();
        } catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public void testCategories(){
        try {
			gbd.abrirSession();
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
			
			System.out.println("Now let's change the cat description by: new desc");
			c.setDescription("new desc");
			gbd.updateCategory(c);
			
			System.out.println("Now, give me a list of all categories created");
			System.out.println(gbd.getCategories());
			gbd.cerrarSession();
			
        } catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public void testAdvertisements() {
		try {
			gbd.abrirSession();
			ArrayList<Category> categories = gbd.getCategories();
			System.out.println("Array categorias: "+categories.get(0).toString());
			ArrayList<User> users = gbd.getUsers();
			
			Advertisement ad = new Advertisement();
			ad.setName("SEAT Ibiza SC");
			ad.setDescription("Muy bienc uidado, edicion 25 aniversario, llantas de 17 pulgadas");
			ad.setCategory(categories.get(0));
			ad.setAuthor(users.get(0));
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
			ArrayList<Advertisement> adsQueried = gbd.getAdsByQueryOnName("Alhambra");
			for (Advertisement advertisement : adsQueried) {
				System.out.println(advertisement.toString());
			}
			
			//gbd.deleteUser(users.get(0));
			//gbd.deleteCategory(categories.get(0));
			
			System.out.println("End");
			gbd.cerrarSession();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    
    public static void main(String[] args) {
        Test test = new Test();
        
        test.testConnection();
        test.testUsers();
        test.testCategories();
        test.testAdvertisements();
        
        System.out.println("Done!");
    }
}
