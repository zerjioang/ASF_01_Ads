package grupo1.pojo;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
	@XmlElement(name = "User")
    protected List<UserPOJO> users;
        
        public Users(){
            this.users = new ArrayList<>();
        }

	public List<UserPOJO> getUsers() {
		return users;
	}

	public void setUsers(List<UserPOJO> users) {
		this.users = users;
	}
}
