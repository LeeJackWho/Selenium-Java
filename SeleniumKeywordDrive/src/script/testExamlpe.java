package script;

import org.testng.annotations.Test;

import config.LoginKeyWords;
import StartEngine.StartEngine_Excel;


public class testExamlpe {
	
	public static Object actionKeyWords;
	
	@Test(groups = {"p0"})
	public static void Login(){
		actionKeyWords=new LoginKeyWords();
		StartEngine_Excel.StartEngine(actionKeyWords);
		
	}
}
