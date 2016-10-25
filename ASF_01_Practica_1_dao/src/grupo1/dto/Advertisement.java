package grupo1.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Advertisement")
@XmlType(propOrder = {"id", "name", "description", "price", "category", "author"})
public class Advertisement {
	private int id;
	private String name;
	private String description;
	private Float price;
	private Category category;
	private User author;
	
	public Advertisement() {}
	public Advertisement(int id, String name, String description, Float price) {
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Advertisement [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", author=" + author + "]";
	}
	
}
