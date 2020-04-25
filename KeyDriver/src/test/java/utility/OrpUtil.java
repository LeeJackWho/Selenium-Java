package utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//OrpUtil¿‡
public class OrpUtil {
  public static String  readValue(String a){
      Properties pro=new Properties();
      String popath=Contants.ObjectReUrl;
      String value=null;
      try {
          InputStream in =new BufferedInputStream(new FileInputStream(popath));
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
