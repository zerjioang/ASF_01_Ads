package grupo1.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Advertisement")
@XmlType(propOrder = {"name", "description", "price", "category"})
public class Advertisement {
	private String name;
	private String description;
	private Float price;
	private Category category;
	
	public Advertisement(String name, String description, Float price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Anuncio [name=" + name + ", description=" + description + ", price=" + price + ", category=" + category
				+ "]";
	}
}
