package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *its developed using Apache Poi libraries ,which used to handle Microsoft Excel Sheet 
 * @author yajnesh m
 */

public class Excel_Utility {
	/**
	 * it's used to read the data from excel-Workbook based on below
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return String data

	 * @throws Throwable
	 */

	public String getDataFromExcel(String sheetName,int rowNum, int cellNum) throws Throwable {
		FileInputStream fis_1=new FileInputStream(IConstant.excelPath);
		Workbook wb=WorkbookFactory.create(fis_1);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		String data=row.getCell(cellNum).getStringCellValue();
		return data;
	}
	/**
	 * used to get the last used row number on specified Sheet
	 * @param SheetName
	 * @return 
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable{
		FileInputStream fis=new FileInputStream(IConstant.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	/**
	 * used to write data back to Excel based on below parameter
	 * @param sheetName
	 * @param row Num
	 * @param celNum
	 * @param data
	 * @throws Throwble
	 */

	public void setDataExcel(String sheetName,int rowNum,int celNum,String data)throws Throwable{
		FileInputStream fis=new FileInputStream(IConstant.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cel=row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IConstant.excelPath);
		wb.write(fos);
		wb.close();
	}
}











