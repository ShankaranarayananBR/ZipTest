package project.excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

public class Excel_Reader {
	
	public String getRowData(String excelName, String sheetName,
			int rowNum, int celNum) throws EncryptedDocumentException,
			InvalidFormatException, IOException {
		FileInputStream pkg = new FileInputStream(System.getProperty("user.dir")+ "//test-data//TestData.xls");
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(pkg);
		HSSFSheet sheet = workbook.getSheet(sheetName);
		HSSFRow row = sheet.getRow(rowNum);
		HSSFCell cell = row.getCell(celNum);				
		int type;
		Object result = null;
		type = cell.getCellType();		
		switch (type) {		
		case Cell.CELL_TYPE_NUMERIC: // numeric value in Excel
			result = cell.getNumericCellValue();
			break;
		case Cell.CELL_TYPE_FORMULA: // precomputed value based on formula
				result = cell.getStringCellValue();	
			break;
		case Cell.CELL_TYPE_STRING: // String Value in Excel
			result = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_BLANK:
			result = "";
		case Cell.CELL_TYPE_BOOLEAN: // boolean value
			result = cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_ERROR:
		default:
			throw new RuntimeException(
					"There is no support for this type of cell");
		}
		pkg.close();
		return result.toString();
	}

}
