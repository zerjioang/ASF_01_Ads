package grupo1.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Category")
@XmlType(propOrder = {"name", "description", "ads"})
public class Category {
	private String name;
	private String description;
	private ArrayList<Advertisement> ads;
	
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	@Override
	public String toString() {
		return "Categoria [name=" + name + ", description=" + description + "]";
	}
}
