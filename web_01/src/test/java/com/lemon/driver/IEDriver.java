package com.lemon.driver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriver {
	
	public static void main(String[] args) throws Exception {
		//���߳���IE����������λ�ã�1.���õ�����������2.�ֶ������������㣩
		System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
		
		//IE��������һ��IE�����˱���ģʽ������Protected Mode settings are not the same for all zones
		//����һ���رձ���ģʽ����IE�����->����->��ȫ->ȫ����ѡ���ñ���ģʽ
		//�����������Ա���ģʽ
		//������������
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//���Ա���ģʽ
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//IE�����������IE�������������
		//����һ���ֶ���������100%
		//��������������������
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		/*��������window��ʧ���⣨��һ�����֣���������Ϣ��unable to find element with id -- kw
		 * ���������
		 * capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://lemon.ke.qq.com/?tuin=788454e9");
		 * */
		
		//����capabilities�ֶ����ô���һ��IE����
		InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
		//ͨ��IE����������ַ
		driver.get("https://lemon.ke.qq.com/?tuin=788454e9");
		//��Ϊ�ó���ȴ�����
		Thread.sleep(3*1000);
		//�ر�����
		driver.quit();
	}

}
