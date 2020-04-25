package com.mianshui.util;


import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;;

//������ʵ�ֲ���ָ����excel�ļ��е�ָ��sheetҳ����ȡָ���ĵ�Ԫ�����ݡ���ȡsheet�����һ�е��кŵĹ���
public class ExcelUtil {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
//    �趨Ҫ������excel���ļ�·����sheet����
//    �ڶ���дexcel�ļ�ʱ�������ȵ��ô˷������趨Ҫ������excel�ļ�·����Ҫ������sheet����
    public static void setExcelFile(String Path,String SheetName){
        
        FileInputStream ExcelFile;
        
        
        try {
            //ʵ����excel�ļ���FileInputStream ����
            ExcelFile = new FileInputStream(Path);
            
            //ʵ����excel�ļ���  XSSFWorkbook ����
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            
            //ʵ���� XSSFCell ����,ָ��excel�ļ��е�sheet���ƣ���������sheet���С��к͵�Ԫ��Ĳ���
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //��ȡexcel�ļ���ָ���ĵ�Ԫ��ĺ������˺���ֻ֧����չ��Ϊ .xlsx ��excel�ļ�
            public static String getCellData (int RowNum, int ColNum) throws Exception {
                
            try {
                //ͨ����������ָ���ĵ�Ԫ����кź��кţ���ȡָ���ĵ�Ԫ�����  
                Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                //�����Ԫ�������Ϊ�ַ������ͣ���ʹ��getStringCellValue��������ȡ��Ԫ������
                //�����Ԫ�������Ϊ�������ͣ�   ��ʹ��getNumericCellValue��������ȡ��Ԫ������
                
                String CellData = Cell.getCellType() == XSSFCell.CELL_TYPE_STRING ? Cell.getStringCellValue() + "" : String.valueOf(Math.round(Cell.getNumericCellValue()));
                
                
                return CellData;
                
            }catch (Exception e){
                e.printStackTrace();
                //��ȡ�����쳣���򷵻ؿ��ַ���
                return "����";
            }
        }
            //��ȡexcel�ļ������һ�е��к�
            public static int getLastRowNum(){
                //��������sheet�����һ�е��к�
                return ExcelWSheet.getLastRowNum();
            }
    
}