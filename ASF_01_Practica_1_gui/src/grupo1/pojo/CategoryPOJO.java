package grupo1.pojo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Category")
@XmlType(name = "Category", propOrder = {"id", "name", "description"})
public class CategoryPOJO {
	private int id;
	private String name;
	private String description;
	
	public CategoryPOJO(){}
	public CategoryPOJO(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Categoria [name=" + name + ", description=" + description + "]";
	}
}
