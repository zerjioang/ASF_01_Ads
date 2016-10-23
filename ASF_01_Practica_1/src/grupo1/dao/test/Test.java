package grupo1.dao.test;

import java.sql.*;

import grupo1.dao.GestorBD;
import grupo1.dto.*;

public class Test {
	private GestorBD gbd;
	public Test() {
		this.gbd = new GestorBD();
	}
	
	public void testUsers(){
        try {
			gbd.conectar();
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
			
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public void testCategories(){
        try {
			gbd.conectar();
			
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
			
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
        Test test = new Test();
        
        test.testUsers();
        test.testCategories();
        
        System.out.println("Done!");
    }
}
