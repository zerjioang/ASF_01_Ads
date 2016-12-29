package grupo1;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import grupo1.dao.GestorBD;
import grupo1.dto.*;

/**
 * <p> Validate a user login. </p>
 */
public class Login  extends ActionSupport {


    public String execute() throws Exception {
        System.out.println("Validating login");
		if (getUsername() == null || getPassword() == null) {
			addActionError("Compulsory to specify both email and password!");
			return INPUT;
		}
		
		GestorBD gbd = new GestorBD();
		ArrayList<User> users = gbd.getUsers();
		
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(getUsername())) {
				// The user exists
				if(user.getPassword().equalsIgnoreCase(getPassword())) {
					// Password correct
					return SUCCESS;
				} else {
					addActionError("Invalid password");
		            return ERROR;
				}
			}
		}
		
		addActionError("The user does not exis.");
        return ERROR;
	}


    // ---- Username property ----

    /**
     * <p>Field to store User username.</p>
     * <p/>
     */
    private String username = null;


    /**
     * <p>Provide User username.</p>
     *
     * @return Returns the User username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * <p>Store new User username</p>
     *
     * @param value The username to set.
     */
    public void setUsername(String value) {
        username = value;
    }

    // ---- Username property ----

    /**
     * <p>Field to store User password.</p>
     * <p/>
     */
    private String password = null;


    /**
     * <p>Provide User password.</p>
     *
     * @return Returns the User password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>Store new User password</p>
     *
     * @param value The password to set.
     */
    public void setPassword(String value) {
        password = value;
    }

}

