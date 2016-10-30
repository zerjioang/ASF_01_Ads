package grupo1.pojo;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Advertisements", propOrder = {
    "advertisement"
})
@XmlRootElement(name = "Advertisements")
public class Advertisements {
	@XmlElement(name = "Advertisement", required = true)
    protected List<AdvertisementPOJO> advertisement;

	public List<AdvertisementPOJO> getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(List<AdvertisementPOJO> advertisement) {
		this.advertisement = advertisement;
	}
}
