package grupo1.dto;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="User")
@XmlType(propOrder = {"ads", "name", "password", "signupDate"})
public class User {
	private ArrayList<Advertisement> ads;
	private String name;
	private String password;
	private Date signupDate;
	
	public User(ArrayList<Advertisement> ads, String name, String password, Date signupDate) {
		super();
		this.ads = ads;
		this.name = name;
		this.password = password;
		this.signupDate = signupDate;
	}
	public ArrayList<Advertisement> getAds() {
		return ads;
	}
	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "adList")
	// XmlElement sets the name of the entities
	@XmlElement(name = "Advertisement")
	public void setAds(ArrayList<Advertisement> ads) {
		this.ads = ads;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}
	@Override
	public String toString() {
		return "Usuario [ads=" + ads + ", name=" + name + ", password=" + password + ", signupDate=" + signupDate + "]";
	}
}
