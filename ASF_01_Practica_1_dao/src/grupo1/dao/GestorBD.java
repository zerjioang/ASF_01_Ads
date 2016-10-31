package grupo1.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.jws.WebService;

import grupo1.dto.*;

@WebService
public class GestorBD {
	
	private Connection con;
	
    private String dataSource = "//localhost/asf_anuncios";
    private String userName = "gestor_anuncios";
    private String password = "gestor2016";
    
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String PROTOCOL = "jdbc:mysql";    
    
    public GestorBD() {
    }
    
    public GestorBD(String dataSource, String userName, String password){
    	this.dataSource = dataSource;
    	this.userName = userName;
    	this.password = password;
    }

    // Connection management
    private void conectar() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);        
        String url = PROTOCOL + ":" + dataSource;
        con = DriverManager.getConnection(url, userName, password);               
    }
    
    private void desconectar() throws SQLException{
        con.close();
    }
    // End connection management

    // Category
    public int insertCategory(Category c) throws SQLException, ClassNotFoundException{
    	conectar();
		String insert = "insert into CATEGORIA " +
	            "(name, description) " +
	            "VALUES ('" + c.getName() +
	            "','"  + c.getDescription() + "')";                        
		Statement stmt = con.createStatement();
		stmt.executeUpdate(insert);
		stmt.close();
		// Get the created row id
		String max = "select MAX(id) as id from CATEGORIA";
		Statement stmt1 = con.createStatement();
		ResultSet rs = stmt1.executeQuery(max);
		int id = 0;
		if (rs.next()){
			id = rs.getInt("id");
		}
		stmt1.close();
		c.setId(id);
		desconectar();
		return id;
	}

    public Category getCategory(int id) throws SQLException, ClassNotFoundException{
    	conectar();
    	Category c = null;
    	String select = "select * from CATEGORIA where id='" + id +"'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()){
        	c = new Category();
        	c.setId(rs.getInt("id"));
        	c.setName(rs.getString("name"));
        	c.setDescription(rs.getString("description"));
        }
        rs.close();
        stmt.close();
        desconectar();
        return c;
    }
    
    public void updateCategory(Category c) throws SQLException, ClassNotFoundException{
    	conectar();
    	String update = "update CATEGORIA set name='" + c.getName() + 
				"', description='" + c.getDescription() +
				"' where id=" + c.getId();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(update);
		stmt.close();
		desconectar();
    }
    
    public void deleteCategory(Category c) throws SQLException, ClassNotFoundException{
    	conectar();
		String delete = "delete from CATEGORIA where id=" + c.getId();
	    Statement stmt = con.createStatement();
	    stmt.executeUpdate(delete);
	    stmt.close();
	    desconectar();
	}

	public ArrayList<Category> getCategories() throws SQLException, ClassNotFoundException{
		conectar();
		ArrayList<Category> categories = new ArrayList<Category>();
	    String select = "select * from CATEGORIA";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(select);
	    
	    while (rs.next()){
	    	Category c = new Category(
	    			rs.getInt("id"),
	    			rs.getString("name"), 
	    			rs.getString("description")
	    			);
	    	categories.add(c);
	    }
	    rs.close();
	    stmt.close();
	    
	    desconectar();
	    return categories;
	}
	
	// Advertisement
	public int insertAd(Advertisement a) throws SQLException, ClassNotFoundException{
		conectar();
		String insert = "insert into ANUNCIO " +
	            "(name, description, creator_id, category_id, price) " +
	            "VALUES ('" + a.getName() +
	            "','"  + a.getDescription() +
	            "',"  + a.getAuthor().getId() +
	            ","  + a.getCategory().getId() +
	            ","  + a.getPrice() + ")";                        
		System.out.println(insert);
		Statement stmt = con.createStatement();
		stmt.executeUpdate(insert);
		stmt.close();
		
		// Get the created row id
		String max = "select MAX(id) as id from ANUNCIO";
		Statement stmt1 = con.createStatement();
		ResultSet rs = stmt1.executeQuery(max);
		int id = 0;
		if (rs.next()){
			id = rs.getInt("id");
		}
		stmt1.close();
		a.setId(id);
		desconectar();
		return id;
	}

	public Advertisement getAd(int id) throws SQLException, ClassNotFoundException{
		conectar();
    	Advertisement a = null;
    	String select = "select * from ANUNCIO where id='" + id +"'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()){
        	a = new Advertisement();
        	a.setId(rs.getInt("id"));
        	a.setName(rs.getString("name"));
        	a.setDescription(rs.getString("description"));
        	a.setPrice(rs.getFloat("price"));
        	a.setAuthor(this.getUser(rs.getInt("creator_id")));
        	a.setCategory(this.getCategory(rs.getInt("category_id")));
        }
        
        rs.close();
        stmt.close();
        desconectar();
        return a;
    }
	
	public void updateAdvertisement(Advertisement a) throws SQLException, ClassNotFoundException{
		conectar();
    	String update = "update ANUNCIO set name='" + a.getName() + 
				"', description='" + a.getDescription() +
				"', price=" + a.getPrice() +
				", category_id=" + a.getCategory().getId() +
				", creator_id=" + a.getAuthor().getId() +
				" where id=" + a.getId();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(update);
		stmt.close();
		desconectar();
    }
	
    public void deleteAd(Advertisement a) throws SQLException, ClassNotFoundException{
    	conectar();
    	String delete = "delete from ANUNCIO where id=" + a.getId();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();
        desconectar();
    }

    public ArrayList<Advertisement> getAds() throws SQLException, ClassNotFoundException{
    	conectar();
		ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
	    String select = "select * from ANUNCIO";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(select);
	    
	    while (rs.next()){
	    	Advertisement a = new Advertisement(
	    			rs.getInt("id"),
	    			rs.getString("name"), 
	    			rs.getString("description"),
	    			rs.getFloat("price")
	    			);
	    	a.setAuthor(getUser(rs.getInt("creator_id")));
	    	a.setCategory(getCategory(rs.getInt("category_id")));
	    	ads.add(a);
	    }
	    rs.close();
	    stmt.close();
	    desconectar();
	    return ads;
	}

    // User
	public int insertUser(User u) throws SQLException, ClassNotFoundException{
		conectar();
		String insert = "insert into USUARIO " +
	            "(email, password, name) " +
	            "VALUES ('" + u.getEmail() +
	            "','" + u.getPassword() +
	            "','"  + u.getName() + "')";                        
		System.out.println(insert);
		Statement stmt = con.createStatement();
		stmt.executeUpdate(insert);
		stmt.close();
		
		// Get the created row id
		String max = "select MAX(id) as id from USUARIO";
		Statement stmt1 = con.createStatement();
		ResultSet rs = stmt1.executeQuery(max);
		int id = 0;
		if (rs.next()){
			id = rs.getInt("id");
		}
		stmt1.close();
		u.setId(id);
		desconectar();
		return id;
	}
	
	public User getUser(int id) throws SQLException, ClassNotFoundException{
		conectar();
		User user = null;
		String select = "select * from USUARIO where id='" + id +"'";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(select);
	    if (rs.next()){
	    	user = new User();
	    	user.setId(rs.getInt("id"));
	    	user.setName(rs.getString("name"));
	    	user.setEmail(rs.getString("email"));
	    	user.setPassword(rs.getString("password"));
	    	user.setSignupDate(rs.getDate("signup_date"));
	    }
	    rs.close();
	    stmt.close();  
	    desconectar();
	    return user;
	}
	
	public void updateUser(User u) throws SQLException, ClassNotFoundException{
		conectar();
    	String update = "update USUARIO set name='" + u.getName() + 
				"', email='" + u.getEmail() +
				"', password='" + u.getPassword() +
				"' where id=" + u.getId();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(update);
		stmt.close();
		desconectar();
    }
	
    public void deleteUser(User u) throws SQLException, ClassNotFoundException{
    	conectar();
    	String delete = "delete from USUARIO where id=" + u.getId();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();
        desconectar();
    }
    
    public ArrayList<User> getUsers() throws SQLException, ClassNotFoundException{
    	conectar();
		ArrayList<User> users = new ArrayList<User>();
	    String select = "select * from USUARIO";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(select);
	    
	    while (rs.next()){
	    	User u = new User(
	    			rs.getInt("id"),
	    			rs.getString("name"),
	    			rs.getString("email"),
	    			rs.getString("password"),
	    			rs.getDate("signup_date")
	    			);
	    	users.add(u);
	    }
	    rs.close();
	    stmt.close();
	    desconectar();
	    return users;
	}
    
    // Mixins
    public void changeCategory(Advertisement a, Category c) throws SQLException, ClassNotFoundException{
    	conectar();
    	String update = "update ANUNCIO set category=" + c.getId() + 
				"' where id=" + a.getId();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(update);
		stmt.close();
		desconectar();
    }
    
    public ArrayList<Advertisement> getAdsByCategory(Category c) throws SQLException, ClassNotFoundException{
    	conectar();
        ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
        String select = "select * from ANUNCIO where category='" + c.getId() +"'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        
        while (rs.next()){
        	Advertisement ad = new Advertisement(
        			rs.getInt("id"),
        			rs.getString("name"), 
        			rs.getString("description"), 
        			rs.getFloat("price")
        			);
        	ads.add(ad);
        }
        rs.close();
        stmt.close();
        desconectar();
        return ads;
    }

    public ArrayList<Advertisement> getAdsByUser(User u) throws SQLException, ClassNotFoundException{
    	conectar();
    	ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
        String select = "select * from ANUNCIO where author='" + u.getId() +"'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        
        while (rs.next()){
        	Advertisement ad = new Advertisement(
        			rs.getInt("id"),
        			rs.getString("name"), 
        			rs.getString("description"), 
        			rs.getFloat("price")
        			);
        	ad.setAuthor(this.getUser(rs.getInt("creator_id")));
        	ad.setCategory(this.getCategory(rs.getInt("category_id")));
        	ads.add(ad);
        }
        rs.close();
        stmt.close();
        desconectar();
        return ads;
    }
    
    public ArrayList<Advertisement> getAdsByQueryOnName(String query)  throws SQLException, ClassNotFoundException{
    	conectar();
    	ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
        String select = "select * from ANUNCIO where name LIKE '%" + query +"%'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        
        while (rs.next()){
        	Advertisement ad = new Advertisement(
        			rs.getInt("id"),
        			rs.getString("name"), 
        			rs.getString("description"), 
        			rs.getFloat("price")
        			);
        	ad.setAuthor(this.getUser(rs.getInt("creator_id")));
        	ad.setCategory(this.getCategory(rs.getInt("category_id")));
        	ads.add(ad);
        }
        rs.close();
        stmt.close();
        desconectar();
        return ads;
    }
}
