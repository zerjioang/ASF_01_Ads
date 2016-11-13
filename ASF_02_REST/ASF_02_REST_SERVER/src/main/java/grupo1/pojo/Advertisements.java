package grupo1.pojo;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Advertisements")
@XmlAccessorType(XmlAccessType.FIELD)
public class Advertisements {
	@XmlElement(name = "Advertisement")
    protected List<AdvertisementPOJO> advertisements;
        
        public Advertisements(){
            this.advertisements = new ArrayList<>();
        }

	public List<AdvertisementPOJO> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<AdvertisementPOJO> advertisements) {
		this.advertisements = advertisements;
	}
}
