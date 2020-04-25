package utility;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//操作对象库的的工具类
public class OrpUtil {
	
	/**
	 * @param a(对应的的Key值)
	 * @return(返回对应的values)
	 */
	public static String  readValue(String a){
		Properties pro=new Properties();
		String popath=Contants.ObjectReUrl;
		String value=null;
		try {
			InputStream in =new BufferedInputStream(new FileInputStream(popath));
//			InputStream in=getClass().getResourceAsStream("/info.properties");
			pro.load(in);
			value=pro.getProperty(a);
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
