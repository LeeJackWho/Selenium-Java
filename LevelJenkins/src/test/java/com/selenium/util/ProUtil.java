package com.selenium.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * ��ȡ�ⲿ�ļ�������
 * */
public class ProUtil {
	private Properties prop;
	private String filePaht;
	//���췽�������ⲿ����һ��filePath
	public ProUtil(String filePath) {
		this.filePaht = filePath;
		this.prop = readProperties();
	}
	//��װ������ȡ�����ļ�
	private Properties readProperties() {
		//ʵ���������
				Properties properties = new Properties();
				try {
					//FileInputStream��ȡ�ļ�
					InputStream inputStream = new FileInputStream(filePaht);
					//ʹ��BufferedInputStream�����ŵ�����
					BufferedInputStream in = new BufferedInputStream(inputStream);
					//ʹ��prop����load����ʹ��
					properties.load(in);
				} catch (IOException e) {
					e.printStackTrace();
				}
				//����load���ļ�
				return properties;
	}
//	public String getPro(String key) throws Exception {
		//ʵ���������
		//Properties prop = new Properties();
		//FileInputStream��ȡ�ļ���ʹ��BufferedInputStream�����ŵ�����
		//InputStream in = new BufferedInputStream(new FileInputStream(filePaht));
		//ʹ��prop����load����ʹ��
		//prop.load(in);
		//��ȡ
//		String keyname = prop.getProperty(key);
//		return keyname;
//	}
	//��װ��ȡ�ı�
	public String getPro(String key) {
		if(prop.containsKey(key)) {
			String keyname = prop.getProperty(key);
			return keyname;
		}else {
			System.out.println("���ȡ��keyֵ����");
			return "";
		}
	}
//	public static void main(String[] args[]) throws Exception {
//		ProUtil pro = new ProUtil();
//		pro.getPro();
//	}
	
}
