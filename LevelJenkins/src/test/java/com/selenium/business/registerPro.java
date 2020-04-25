package com.selenium.business;

import com.selenium.base.DriverBase;
import com.selenium.handle.registerPageHandle;

public class registerPro {
	public registerPageHandle rph;
	public registerPro(DriverBase driver) {
		rph = new registerPageHandle(driver);
	}
	
	//ע������
	public void register(String registerusername,String registerfullname,String registeremail,String registerpassword) {
		if(rph.assertRegisterPage()) {
			rph.sendKeysUser(registerusername);
			rph.sendKeysFullname(registerfullname);
			rph.sendKeysEmail(registeremail);
			rph.sendKeysPassword(registerpassword);
			rph.clickRegisterButton();
		}else {
			System.out.println("ҳ�治���ڻ�״̬����ȷ");
		}
	}
}
