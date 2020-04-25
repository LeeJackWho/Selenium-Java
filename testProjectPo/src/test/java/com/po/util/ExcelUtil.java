package com.po.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 *@Comments   : ���뵼��Excel������ 
 *������ʵ�ֲ���ָ����excel�ļ��е�ָ��sheetҳ��
 *��ȡָ���ĵ�Ԫ�����ݡ���ȡsheet�����һ�е��кŵĹ���
 *
 *
 **/
public class ExcelUtil {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;//excel�ļ�����
    private static XSSFCell ExcelCell;//��Ԫ�����

    //�����Ҫ������excel���ļ�·����sheet����
    //�ڶ�,дexcel�ļ�ʱ�������ȵ��ô˷������趨Ҫ������excel��·����sheet����
    public static void setExcelFile(String Path,String SheetName) {
        FileInputStream ExcelFile;

        try {
            //ʵ����excel�ļ���FileInputStream����
            ExcelFile=new FileInputStream(Path);
            //ʵ����EXCEL�ļ���execlWXSSFWorkbook����
            ExcelWBook =new XSSFWorkbook(ExcelFile);
            //ʵ���� XSSFCell ����,ָ��excel�ļ��е�sheet���ƣ���������sheet���С��к͵�Ԫ��Ĳ���
            ExcelWSheet=ExcelWBook.getSheet(SheetName);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * @param rowNum�� colNum�� 
     **/
    //��ȡexcel�ļ���ָ���ĵ�Ԫ��ĺ������˺���ֻ֧����չ��Ϊ.xlsx��excel�ļ�
    public static String getCellData(int rowNum,int colNum)throws Exception {
        try {
        //ͨ����������֪����Ԫ����к����кţ���ȡָ���ĵ�Ԫ�����
        ExcelCell=ExcelWSheet.getRow(rowNum).getCell(colNum);
        //�����Ԫ�������Ϊ�ַ������ͣ���ʹ��getStringCellValue��������ȡ��Ԫ������
        //�����Ԫ�������Ϊ�������ͣ�   ��ʹ��getNumericCellValue��������ȡ��Ԫ������
        String CellData =ExcelCell.getCellType()==XSSFCell.CELL_TYPE_STRING?ExcelCell.getStringCellValue()+"":String.valueOf(Math.round(ExcelCell.getNumericCellValue()));

        return CellData;
        }
        catch(Exception e){
            e.printStackTrace();
            //��ȡ�����쳣���򷵻ؿ��ַ���
            return "����";
        }
    }

    //��ȡexcel�ļ������һ�е��к�
    public static int getLastRowNum() {
        //��������sheet�����һ���к�
        return ExcelWSheet.getLastRowNum();
    }
}