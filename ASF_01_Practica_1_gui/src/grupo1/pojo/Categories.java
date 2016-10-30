package grupo1.pojo;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class Categories {
	@XmlElement(name = "category")
    protected List<CategoryPOJO> category = null;

	public List<CategoryPOJO> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryPOJO> category) {
		this.category = category;
	}
}
