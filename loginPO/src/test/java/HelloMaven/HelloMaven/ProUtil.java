package HelloMaven.HelloMaven;
 
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
 
public class ProUtil {
	private Properties prop;
	private String filepath;
	
	public ProUtil(String filepath1){
	    this.filepath = filepath1;
	    this.prop = ReadProperties();
	    System.out.println("the construtor method is called");
	}
	
	private Properties ReadProperties(){
		Properties proper = new Properties();
		try {
			FileInputStream FileStream = new FileInputStream(filepath);
			BufferedInputStream in = new BufferedInputStream(FileStream);
			//System.out.println(in);
			proper.load(new InputStreamReader(in,"UTF-8"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("private method ReadProperties is called");
		//this.prop = proper;
		return proper;
		//String totalvalue = proper.getProperty("username");
		//System.out.println(totalvalue);
		//String value1 = totalvalue.split(">")[0];
		//String value2 = totalvalue.split(">")[1];
		//System.out.println("value1 is " + value1 + ", and value2 is:" + value2);
	}
	
	public String GetProperies(String key){
 
		if(prop.containsKey(key)){
			String filevalue = prop.getProperty(key);
			System.out.println("the key is found, the value is" + filevalue);
			//System.out.println("the key is found");
			return filevalue;
		    
		}else {
			System.out.println("the key is not exists");
			return null;
		}
	}
	// public static void main(String[] args) {
	//	 ProUtil obj = new ProUtil("element.properities");
	//	 obj.ReadProperties("element.properities");
	//	 obj.GetProperies();
	// }
 
}
