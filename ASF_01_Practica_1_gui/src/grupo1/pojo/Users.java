package grupo1.pojo;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Users", propOrder = {
    "user"
})
@XmlRootElement(name = "Users")
public class Users {
	@XmlElement(name = "User", required = true)
    protected List<UserPOJO> user;

	public List<UserPOJO> getUser() {
		return user;
	}

	public void setUser(List<UserPOJO> user) {
		this.user = user;
	}
}
