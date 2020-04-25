package script;

//²Î¿¼https://my.oschina.net/hellotest/blog/531932
import config.ActionKeyWords;
import utility.ExcelUtils;

public class Login_Script {
    public static ActionKeyWords actionKeyWords;
    public static String Keywords=null;
    public static Method[] method;
    public Login_Script(){
        actionKeyWords= new ActionKeyWords();
        method=actionKeyWords.getClass().getMethods();
    }
    public static void main(String []agrs) throws Exception{
        ExcelUtils.setExcelFile("D:\\data\\TestData.xls", "steps");
        new Login_Script();
        for(int RowNum=1;RowNum<=ExcelUtils.getLastRowNums();RowNum++){
            Keywords=ExcelUtils.getCellDate(RowNum, 3);
            login_action();
        }
    }
    public static void login_action(){
        for(int i=0;i<method.length;i++){
//            System.out.println(method[i].getName()+"     "+actionKeyWords+Keywords);
            if(method[i].getName().trim().equals(Keywords)){
                try {
                    method[i].invoke(actionKeyWords);
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
