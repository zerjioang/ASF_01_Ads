package grupo1.dao.test;

import java.sql.*;

import grupo1.dao.GestorBD;
import grupo1.dto.*;

public class Test {

	public void testUsers(){
		GestorBD gbd = new GestorBD();
        try {
			gbd.conectar();
			User u = new User();
			u.setId(0);
			u.setEmail("aitor.brazaola@opendeusto.es");
			u.setName("Aitor");
			u.setPassword("123456");
						
			int userId = gbd.insertUser(u);
			u = gbd.getUser(userId);
			System.out.println("User created:" + u.toString());
            
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
        
        System.out.println("Done!");
    }
}
