package grupo1.pojo;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Advertisements")
@XmlAccessorType(XmlAccessType.FIELD)
public class Advertisements {
	@XmlElement(name = "Advertisement")
    protected List<AdvertisementPOJO> advertisements;

	public List<AdvertisementPOJO> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<AdvertisementPOJO> advertisements) {
		this.advertisements = advertisements;
	}
}
