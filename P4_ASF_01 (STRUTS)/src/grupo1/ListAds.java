package grupo1;
import com.opensymphony.xwork2.ActionSupport;

public class ListAds extends ActionSupport {
	public static final String MESSAGE = "Here you can see the full list of ads.";
	
	public String execute() throws Exception {
		setMessage(MESSAGE);
        return SUCCESS;
	}
	
	private String message;
	 
    public void setMessage(String message){
        this.message = message;
    }
 
    public String getMessage() {
        return message;
    }
}
