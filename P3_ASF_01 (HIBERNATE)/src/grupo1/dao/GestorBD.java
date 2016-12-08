package grupo1.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.jws.WebService;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import grupo1.dto.*;

@SuppressWarnings("unchecked")
@WebService
public class GestorBD {
	
	private Connection con;
	
    private String dataSource = "//localhost/asf_anuncios";
    private String userName = "gestor_anuncios_p3";
    private String password = "gestor2016";
    
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String PROTOCOL = "jdbc:mysql";
    
    // Hibernate
    private SessionFactory factory;
	private Transaction tx;
	private Session s;
    
    public GestorBD() {
    	factory = new Configuration().configure().buildSessionFactory();
    }
    
    public GestorBD(String dataSource, String userName, String password){
    	this.dataSource = dataSource;
    	this.userName = userName;
    	this.password = password;
    	
    	factory = new Configuration().configure().buildSessionFactory();
    }
    
    // Hibernate
    public void abrirSession() {
		s = factory.openSession();
	}
	
	public void cerrarSession() {
		s.close();
	}

    // Traditional Connection management
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
    	tx = null;
		System.out.println("Insercion de Categoria" + "\n");
		try {
	 		tx = s.beginTransaction();
			s.save(c);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println ("Error insertando categoria" + ex);
		}
		return c.getId();
	}

    public Category getCategory(int id) throws SQLException, ClassNotFoundException{
    	Category c = null;
    	
    	c = (Category)s.load(Category.class, id);
    	
        return c;
    }
    
    public void updateCategory(Category c) throws SQLException, ClassNotFoundException{
    	tx = null;
		System.out.println("Actualizacion de Categoria" + "\n");
		try {
	 		tx = s.beginTransaction();
			s.update(c);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println ("Error actualizando categoria" + ex);
		}
    }
    
    public void deleteCategory(Category c) throws SQLException, ClassNotFoundException{
    	tx = null;
		System.out.println("Borrado de Categoria" + "\n");
		try {
			s.flush();
			
			ArrayList<Advertisement> ads = getAdsByCategory(c);
			
			for (Advertisement advertisement : ads) {
				deleteAd(advertisement);
			}
			
	 		tx = s.beginTransaction();
	 		s.delete(c);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println ("Error borrando categoria" + ex);
		}
	}

	public ArrayList<Category> getCategories() throws SQLException, ClassNotFoundException{
		Query q = null;
		try {
			q = s.createQuery("from grupo1.dto.Category");
		} catch (Exception ex) {
			System.out.println ("Error en Query" + ex.getMessage());
		}
		return (ArrayList<Category>) q.list();		
	}
	
	// Advertisement
	public int insertAd(Advertisement a) throws SQLException, ClassNotFoundException{
		tx = null;
		System.out.println("Insercion de Anuncio" + "\n");
		try {
	 		tx = s.beginTransaction();
			s.save(a);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println ("Error insertando anuncio" + ex);
		}
		return a.getId();
	}

	public Advertisement getAd(int id) throws SQLException, ClassNotFoundException{
		Advertisement a = null;
    	
    	a = (Advertisement)s.load(Advertisement.class, id);
    	
        return a;
    }
	
	public void updateAdvertisement(Advertisement a) throws SQLException, ClassNotFoundException{
		tx = null;
		System.out.println("Actualizacion de Anuncio" + "\n");
		try {
	 		tx = s.beginTransaction();
			s.update(a);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println ("Error actualizando anuncio" + ex);
		}
    }
	
    public void deleteAd(Advertisement a) throws SQLException, ClassNotFoundException{
    	tx = null;
		System.out.println("Borrado de Anuncio" + "\n");
		try {
			s.flush();
	 		tx = s.beginTransaction();
	 		s.delete(a);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println ("Error borrando anuncio" + ex);
		}
    }

    public ArrayList<Advertisement> getAds() throws SQLException, ClassNotFoundException{
    	Query q = null;
		try {
			q = s.createQuery("from grupo1.dto.Advertisement");
		} catch (Exception ex) {
			System.out.println ("Error en Query" + ex.getMessage());
		}
		return (ArrayList<Advertisement>) q.list();	
	}

    // User
	public int insertUser(User u) throws SQLException, ClassNotFoundException{
		tx = null;
		System.out.println("Insercion de Usuario" + "\n");
		try {
	 		tx = s.beginTransaction();
			s.save(u);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println ("Error insertando usuario" + ex);
		}
		return u.getId();
	}
	
	public User getUser(int id) throws SQLException, ClassNotFoundException{
		User u = null;
    	
    	u = (User)s.load(User.class, id);
    	
        return u;
	}
	
	public void updateUser(User u) throws SQLException, ClassNotFoundException{
		tx = null;
		System.out.println("Actualizacion de Usuario" + "\n");
		try {
	 		tx = s.beginTransaction();
			s.update(u);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println ("Error actualizando usuario" + ex);
		}
    }
	
    public void deleteUser(User u) throws SQLException, ClassNotFoundException{
    	tx = null;
		System.out.println("Borrado de Usuario" + "\n");
		try {
			s.flush();
			
			ArrayList<Advertisement> ads = getAdsByUser(u);
			
			for (Advertisement advertisement : ads) {
				deleteAd(advertisement);
			}
			
	 		tx = s.beginTransaction();
			s.delete(u);
			tx.commit();
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println ("Error borrando usuario" + ex);
		}
    }
    
    public ArrayList<User> getUsers() throws SQLException, ClassNotFoundException{
    	Query q = null;
		try {
			q = s.createQuery("from grupo1.dto.User");
		} catch (Exception ex) {
			System.out.println ("Error en Query" + ex.getMessage());
		}
		return (ArrayList<User>) q.list();		
	}
    
    // Mixins
    public void changeCategory(Advertisement a, Category c) throws SQLException, ClassNotFoundException{
    	tx = null;
		System.out.println("Cambiando categoria de " + a.getCategory().getName() + " a " + c.getName() + "\n");
		try {
	 		tx = s.beginTransaction();
	 		
	 		a.setCategory(c);
	 		
			s.update(a);
			tx.commit();
			
			System.out.println("Ahora la categoria es: " + a.getCategory().getName());
		} catch (Exception ex) {
			if (tx!=null) tx.rollback();
			System.out.println ("Error actualizando anuncio" + ex);
		}
    }
    
    public ArrayList<Advertisement> getAdsByCategory(Category c) throws SQLException, ClassNotFoundException{
    	Query q = null;
		System.out.println("Recuperacion de nanuncios por categoria" + "\n");
		try {
			q = s.createQuery("from grupo1.dto.Advertisement as Ad where Ad.category='" + c.getId() + "'");
		} catch (Exception ex) {
			System.out.println ("Error en Query" + ex.getMessage());
		}
		return (ArrayList<Advertisement>) q.list();
    }

    public ArrayList<Advertisement> getAdsByUser(User u) throws SQLException, ClassNotFoundException{
        Query q = null;
		System.out.println("Recuperacion de anuncios por usuario" + "\n");
		try {
			q = s.createQuery("from grupo1.dto.Advertisement as Ad where Ad.author='" + u.getId() +"'");
		} catch (Exception ex) {
			System.out.println ("Error en Query" + ex.getMessage());
		}
		return (ArrayList<Advertisement>) q.list();
    }
    
    public ArrayList<Advertisement> getAdsByQueryOnName(String query)  throws SQLException, ClassNotFoundException{
    	Query q = null;
		System.out.println("Recuperacion de anuncios por nombre" + "\n");
		try {
			q = s.createQuery("from grupo1.dto.Advertisement as Ad where Ad.name like '%" + query +"%'");
		} catch (Exception ex) {
			System.out.println ("Error en Query" + ex.getMessage());
		}
		
		ArrayList<Advertisement> advertisementsFound = new ArrayList<Advertisement>();
		
		if (q != null) {
			advertisementsFound = (ArrayList<Advertisement>) q.list();
		}
		
		return advertisementsFound;
    }
    
    public void deleteSchema() throws ClassNotFoundException, SQLException {
    	conectar();
    	String delete = "delete from ANUNCIO";
    	Statement stmt = con.createStatement();
    	stmt.executeUpdate(delete);
    	stmt.close();
    	
    	delete = "delete from USUARIO";
        stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();
        
        delete = "delete from CATEGORIA";
        stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();
        
        desconectar();
    }
}
