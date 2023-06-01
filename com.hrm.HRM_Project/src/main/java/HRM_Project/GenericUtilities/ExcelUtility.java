package HRM_Project.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This utility is used to handle Excel spreadsheet
 * @author Admin
 *
 */
public class ExcelUtility {

	/**
	 * This method is used to Write data into an Excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public void insertDataIntoExcel(String sheetName, int rowNo, int cellNo, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(IPathConstants.excelFilePath);
		workbook.write(fileOutputStream);
		workbook.close();
	}
	
	/**
	 * This method is used to fetch data from Excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, int rowNo, int cellNo) throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		DataFormatter dataformatter = new DataFormatter();
		String data = dataformatter.formatCellValue(cell);
		return data;
	}
	
	/**
	 * This method is used to get the count of rows created in the Excel sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getTotalNumberOfRows(String sheetName) throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		return sheet.getLastRowNum();
	}
	
	/**
	 * This method is used to get the count of columns created in the Excel sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getTotalNumberOfRows(String sheetName, int rowNo) throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		return row.getLastCellNum();
	}
	
	public HashMap<String, String> getMultipleData(String sheetName) throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(int i=0; i<=lastRow; i++)
		{
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
}
