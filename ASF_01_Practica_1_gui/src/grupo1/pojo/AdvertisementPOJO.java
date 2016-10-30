package grupo1.pojo;

import javax.xml.bind.annotation.*;

import grupo1.dto.xsd.Advertisement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Advertisement")
@XmlType(name = "Advertisement",propOrder = {"id", "name", "description", "price", "category", "author"})
public class AdvertisementPOJO {
	private int id;
	private String name;
	private String description;
	private Float price;
	private CategoryPOJO category;
	private UserPOJO author;
	
	public AdvertisementPOJO() {}
	public AdvertisementPOJO(Advertisement a) {
		super();
		this.id = a.getId();
		this.name = a.getName();
		this.description = a.getDescription();
		this.price = a.getPrice();
		this.author = new UserPOJO(a.getAuthor());
		this.category = new CategoryPOJO(a.getCategory());
	}
	public AdvertisementPOJO(int id, String name, String description, Float price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public CategoryPOJO getCategory() {
		return category;
	}
	public void setCategory(CategoryPOJO category) {
		this.category = category;
	}
	public UserPOJO getAuthor() {
		return author;
	}
	public void setAuthor(UserPOJO author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Advertisement [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", author=" + author + "]";
	}

}
