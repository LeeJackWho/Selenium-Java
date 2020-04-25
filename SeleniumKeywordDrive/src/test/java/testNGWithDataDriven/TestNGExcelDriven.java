package testNGWithDataDriven;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class TestNGExcelDriven {
    public WebDriver driver;
    String baseUrl = "http://www.sogou.com";
    @DataProvider(name="testData")
    public static Object[][] words() throws IOException{
        return getTestData("E:\\�������\\��ҵ���\\eclipse-jee-2019-03-R-win32-x86_64\\eclipse\\eclipse-workspace\\SeleniumKeywordDrive\\src\\test\\java\\data", "testData.xlsx", "Sheet1");
    }
    @Test(dataProvider = "testData")
    public void testSearchExcel(String searchWord1, String searchWord2, String searchWord3, String searchResult){
        driver.get(baseUrl + "/");
        driver.findElement(By.id("query")).sendKeys(searchWord1+" "+searchWord2+" "+searchWord3);
        driver.findElement(By.id("stb")).click();
        Assert.assertTrue(driver.getPageSource().contains(searchResult));
    }
    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
    }
    @AfterMethod
    private void afterMethod(){
        driver.quit();
    }
    public static Object[][] getTestData(String filePath, String fileName, String sheetName) throws IOException{
        File file = new File(filePath + "\\" + fileName);
        //����FileInputStream�������ڶ�ȡExcel�ļ�
        FileInputStream inputStream = new FileInputStream(file);
        //����Workbook����
        Workbook workbook = null;
        //��ȡ�ļ�����������չ�����ж���.xlsx�ļ�����.xls�ļ�
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        //�����.xlsx,����XSSFWorkbook�������ʵ�����������.xls��ʹ��HSSFWorkbook�������ʵ����
        if (fileExtensionName.equals(".xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        }
        else if (fileExtensionName.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        //ͨ��sheetName��������Sheet����
        Sheet sheet = workbook.getSheet(sheetName);
        //��ȡExcel�����ļ�Sheet1�����ݵ�������getLastRowNum������ȡ���ݵ����һ���к�
        //getFirstRowNum������ȡ���ݵĵ�һ���кţ����֮��������ݵ�����
        //Excel�к��ж��Ǵ�0��ʼ
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        //������Ϊrecords��list�������洢��Excel�����ļ���ȡ������
        List<Object[]> records = new ArrayList<Object[]>();
        //ʹ������forѭ������Excel�����ļ���ȥ��һ������������
        //����i��1��ʼ�������Ǵ�0��ʼ
        for (int i = 1; i<rowCount+1; i++){
            Row row = sheet.getRow(i);
            //����һ�����飬�����洢Excel�����ļ�ÿ���е����ݣ�����Ĵ�С��getLastCellNum�취�����ж�̬������ʵ�ֲ������ݸ����������С��һ��
            String fields[] = new String[row.getLastCellNum()];
            for (int j = 0; j<row.getLastCellNum();j++){
                //����getCell��getStringCellValue������ȡExcel�ļ��еĵ�Ԫ������
                fields[j] = row.getCell(j).getStringCellValue();
            }
            //��fields�����ݶ��ִ洢��records��list��
            records.add(fields);
        }
        //���庯������ֵ����Object[][]
        //���洢�������ݵ�listת��Ϊһ��Object�Ķ�ά����
        Object[][] results = new Object[records.size()][];
        //���ö�ά����ÿ�е�ֵ��ÿ����һ��Object����
        for (int i = 0; i<records.size(); i++){
            results[i] = records.get(i);
        }
        return results;
    }
}