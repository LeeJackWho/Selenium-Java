package HelloMaven.Handle;
 
import HelloMaven.base.DriverBase;
import HelloMaven.page.LoginPage;
 
/**
 * 封装login页面所需的action,执行action就需要在调用的函数里new LoginHandle的对象
 * */
public class LoginHandle { 
	public DriverBase driver;
	public LoginPage loginpage;
	public LoginHandle(DriverBase driver) {
		this.driver = driver;
		this.loginpage = new LoginPage(driver);  //如果放在构造函数外面，就是全局变量的那个driver。
//系统在调用LoginHandle的时候，首先会读取全局变量。所以放在外面，driver还没有传过来	
	}
	
	/**
	 * 输入用户名
	 * */
	public void InputUsername(String username) {
		loginpage.input(loginpage.getUserName(), username);
	}
	public void InputPassword(String password) {
		loginpage.input(loginpage.getPassword(), password);
	}
	public void clickLogin() {
		loginpage.click(loginpage.LoginButton());
	}
	public boolean IsLoginPage() {
		return loginpage.IsDisplayed(loginpage.getUserName());
	}
}
