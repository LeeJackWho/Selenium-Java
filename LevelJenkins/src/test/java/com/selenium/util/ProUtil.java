package com.selenium.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 读取外部文件工具类
 * */
public class ProUtil {
	private Properties prop;
	private String filePaht;
	//构造方法，从外部传进一个filePath
	public ProUtil(String filePath) {
		this.filePaht = filePath;
		this.prop = readProperties();
	}
	//封装方法读取配置文件
	private Properties readProperties() {
		//实例化类对象
				Properties properties = new Properties();
				try {
					//FileInputStream读取文件
					InputStream inputStream = new FileInputStream(filePaht);
					//使用BufferedInputStream方法放到缓存
					BufferedInputStream in = new BufferedInputStream(inputStream);
					//使用prop进行load进来使用
					properties.load(in);
				} catch (IOException e) {
					e.printStackTrace();
				}
				//返回load的文件
				return properties;
	}
//	public String getPro(String key) throws Exception {
		//实例化类对象
		//Properties prop = new Properties();
		//FileInputStream读取文件并使用BufferedInputStream方法放到缓存
		//InputStream in = new BufferedInputStream(new FileInputStream(filePaht));
		//使用prop进行load进来使用
		//prop.load(in);
		//读取
//		String keyname = prop.getProperty(key);
//		return keyname;
//	}
	//封装获取文本
	public String getPro(String key) {
		if(prop.containsKey(key)) {
			String keyname = prop.getProperty(key);
			return keyname;
		}else {
			System.out.println("你获取的key值不对");
			return "";
		}
	}
//	public static void main(String[] args[]) throws Exception {
//		ProUtil pro = new ProUtil();
//		pro.getPro();
//	}
	
}
