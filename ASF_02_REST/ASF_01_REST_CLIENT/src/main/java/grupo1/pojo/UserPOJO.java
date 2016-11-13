package grupo1.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="User")
@XmlType(name = "User", propOrder = {"id", "name", "email", "password", "signupDate"})
public class UserPOJO {
    private int id;
    private String name;
    private String email;
    private String password;
    private Date signupDate;

    public UserPOJO(){}

    public UserPOJO(int id, String name, String email, String password, Date signupDate) {
            super();
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.signupDate = signupDate;
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
    public String getEmail() {
            return email;
    }
    public void setEmail(String email) {
            this.email = email;
    }
    public String getPassword() {
            return password;
    }
    public void setPassword(String password) {
            this.password = password;
    }
    public Date getSignupDate() {
            return signupDate;
    }
    public void setSignupDate(Date signupDate) {
            this.signupDate = signupDate;
    }
    @Override
    public String toString() {
            return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", signupDate="
                            + signupDate + "]";
    }
}
