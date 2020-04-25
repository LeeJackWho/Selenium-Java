package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    public static HSSFSheet ExcelSheet;
    public static HSSFWorkbook    ExcelBook;
    public static HSSFRow Row;
    public static HSSFCell    Cell;
    public static void setExcelFile(String Path,String    SheetName) throws Exception{
        FileInputStream    ExcelFile=new FileInputStream(Path);
        ExcelBook=new HSSFWorkbook(ExcelFile);
        ExcelSheet=ExcelBook.getSheet(SheetName);        
    }
    public static void setCellData(String Result,  int RowNum, int ColNum,String Path) throws Exception{
          Row  = ExcelSheet.getRow(RowNum);
        Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
        if (Cell == null) {
            Cell = Row.createCell(ColNum);
            Cell.setCellValue(Result);
            } else {
                Cell.setCellValue(Result);
            }
        FileOutputStream fileOut = new FileOutputStream(Path);
        ExcelBook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }
    public static String getCellDate(int RowNum,int CloNum){
        Cell=ExcelSheet.getRow(RowNum).getCell(CloNum);
        String cellData=Cell.getStringCellValue();
        return cellData;
    }
}