package HelloMaven.testcase;
 
import HelloMaven.base.DriverBase;
 
/**
 * ����driver�����еĲ����඼�̳�caseBase�࣬�õ�driver
 * */
public class caseBase {
	public DriverBase InitialDriver(String browser) { //��ʼ��driver,ѡ��driver
		return new DriverBase(browser);
	}
 
}
