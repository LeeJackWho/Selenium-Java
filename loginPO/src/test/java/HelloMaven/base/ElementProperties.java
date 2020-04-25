package HelloMaven.base;
 
import org.openqa.selenium.By;
 
import HelloMaven.HelloMaven.ProUtil;
 
public class ElementProperties {
	public By bystr(String element){
		ProUtil property = new ProUtil("element.properities");
		String location = property.GetProperies(element);
		System.out.println("the file value get from properties file is: " + location);
		String way = location.split(">")[0];
		String value = location.split(">")[1];
		System.out.println("value1 is " + way + ", and value2 is:" + value);
		
		if(way.equals("id")) {
			return By.id(value);
		}else if(way.equals("name")){
			return By.name(value);
		}else if(way.equals("className")) {
			return By.className(value);
		}else if(way.equals("xpath")) {
			return By.xpath(value);
		}else
			{return null;}
		
	}
}
