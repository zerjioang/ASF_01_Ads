package grupo1.pojo;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class Categories {
	@XmlElement(name = "categories")
    protected List<CategoryPOJO> categories = null;

        public Categories(){
            this.categories = new ArrayList<>();
        }
        
	public List<CategoryPOJO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryPOJO> categories) {
		this.categories = categories;
	}
}
