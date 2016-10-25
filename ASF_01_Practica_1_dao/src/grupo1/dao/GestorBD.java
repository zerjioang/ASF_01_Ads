package grupo1.dao;

import java.sql.*;
import java.util.ArrayList;

import grupo1.dto.*;

public class GestorBD {
	
	private Connection con;
	
    private String dataSource = "//localhost/asf_anuncios";
    private String userName = "gestor_anuncios";
    private String password = "gestor2016";
    
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String PROTOCOL = "jdbc:mysql";    

    public GestorBD() {
    	// Default connection
    }
    
    public GestorBD(String dataSource, String userName, String password){
    	this.dataSource = dataSource;
    	this.userName = userName;
    	this.password = password;
    }

    // Connection management
    public void conectar() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);        
        String url = PROTOCOL + ":" + dataSource;
        con = DriverManager.getConnection(url, userName, password);               
    }
    
    public void desconectar() throws SQLException{
        con.close();
    }
    // End connection management

    // Category
    public int insertCategory(Category c) throws SQLException{
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
		return id;
	}

    public Category getCategory(int id) throws SQLException{
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
        return c;
    }
    
    public void updateCategory(Category c) throws SQLException{
    	String update = "update CATEGORIA set name='" + c.getName() + 
				"', description='" + c.getDescription() +
				"' where id=" + c.getId();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(update);
		stmt.close();
    }
    
    public void deleteCategory(Category c) throws SQLException{
		String delete = "delete from CATEGORIA where id=" + c.getId();
	    Statement stmt = con.createStatement();
	    stmt.executeUpdate(delete);
	    stmt.close();
	}

	public ArrayList<Category> getCategories() throws SQLException{
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
	    
	    return categories;
	}
	
	// Advertisement
	public int insertAd(Advertisement a) throws SQLException{
		String insert = "insert into ANUNCIO " +
	            "(name, description, creator, category, price) " +
	            "VALUES ('" + a.getName() +
	            ",'"  + a.getDescription() +
	            ",'"  + a.getAuthor().getId() +
	            ",'"  + a.getCategory().getId() +
	            ",'"  + a.getPrice() + "')";                        
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
		a.setId(id);
		return id;
	}

	public Advertisement getAd(int id) throws SQLException{
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
        	a.setAuthor(this.getUser(rs.getInt("creator")));
        	a.setCategory(this.getCategory(rs.getInt("category")));
        }
        
        rs.close();
        stmt.close();  
        return a;
    }
	
	public void updateAdvertisement(Advertisement a) throws SQLException{
    	String update = "update ANUNCIO set name='" + a.getName() + 
				"', description='" + a.getDescription() +
				"', price=" + a.getPrice() +
				"', category=" + a.getCategory().getId() +
				"', creator=" + a.getAuthor().getId() +
				"' where id=" + a.getId();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(update);
		stmt.close();
    }
	
    public void deleteAd(Advertisement a) throws SQLException{
    	String delete = "delete from ANUNCIO where id=" + a.getId();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();
    }

    public ArrayList<Advertisement> getAds() throws SQLException{
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
	    	ads.add(a);
	    }
	    rs.close();
	    stmt.close();
	    
	    return ads;
	}

    // User
	public int insertUser(User u) throws SQLException{
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
		return id;
	}
	
	public User getUser(int id) throws SQLException{
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
	    return user;
	}
	
	public void updateUser(User u) throws SQLException{
    	String update = "update USUARIO set name='" + u.getName() + 
				"', email='" + u.getEmail() +
				"', password='" + u.getPassword() +
				"' where id=" + u.getId();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(update);
		stmt.close();
    }
	
    public void deleteUser(User u) throws SQLException{
    	String delete = "delete from USUARIO where id=" + u.getId();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();
    }
    
    public ArrayList<User> getUsers() throws SQLException{
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
	    
	    return users;
	}
    
    // Mixins
    public void changeCategory(Advertisement a, Category c) throws SQLException{
    	String update = "update ANUNCIO set category=" + c.getId() + 
				"' where id=" + a.getId();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(update);
		stmt.close();
    }
    
    public ArrayList<Advertisement> getAdsByCategory(Category c) throws SQLException{
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
        
        return ads;
    }

    public ArrayList<Advertisement> getAdsByUser(User u) throws SQLException{
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
        	ads.add(ad);
        }
        rs.close();
        stmt.close();
        
        return ads;
    }
}
