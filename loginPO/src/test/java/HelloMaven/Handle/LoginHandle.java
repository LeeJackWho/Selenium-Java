package HelloMaven.Handle;
 
import HelloMaven.base.DriverBase;
import HelloMaven.page.LoginPage;
 
/**
 * ��װloginҳ�������action,ִ��action����Ҫ�ڵ��õĺ�����new LoginHandle�Ķ���
 * */
public class LoginHandle { 
	public DriverBase driver;
	public LoginPage loginpage;
	public LoginHandle(DriverBase driver) {
		this.driver = driver;
		this.loginpage = new LoginPage(driver);  //������ڹ��캯�����棬����ȫ�ֱ������Ǹ�driver��
//ϵͳ�ڵ���LoginHandle��ʱ�����Ȼ��ȡȫ�ֱ��������Է������棬driver��û�д�����	
	}
	
	/**
	 * �����û���
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
