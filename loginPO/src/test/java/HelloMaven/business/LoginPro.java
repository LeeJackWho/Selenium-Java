package HelloMaven.business;
 
import HelloMaven.Handle.LoginHandle;
import HelloMaven.base.DriverBase;
 
public class LoginPro {
	public LoginHandle loginHandler;  //用handler来具体操作页面
	public LoginPro(DriverBase driver) {
		loginHandler = new LoginHandle(driver); //划重点
	}
	
	public void Login(String username, String password) {
		if (loginHandler.IsLoginPage()) {
		loginHandler.InputUsername(username);
		loginHandler.InputPassword(password);
		loginHandler.clickLogin();
		loginHandler.loginpage.getUserName();
		}else {
			System.out.println("current page is not Login Page, or not loaded");
		}
	}
 
}

