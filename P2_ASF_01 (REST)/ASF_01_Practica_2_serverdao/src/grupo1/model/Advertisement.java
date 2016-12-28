package grupo1.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Advertisement {
	private int id;
	private String name;
	private String description;
	private Float price;
	private int categoryId;
	private int authorId;
	
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	@Override
	public String toString() {
		return "Advertisement [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + categoryId + ", author=" + authorId + "]";
	}
	
}
