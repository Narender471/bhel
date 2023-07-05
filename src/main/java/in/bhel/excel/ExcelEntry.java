package in.bhel.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.bhel.entity.CableSchedule;

public class ExcelEntry {
	
	public ArrayList<CableSchedule> getDataFromExcel(String excelFilePath) throws IOException {
		ArrayList<CableSchedule> al = new ArrayList<CableSchedule>();
		FileInputStream fis = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		for (int r = 0; r <=rows; r++) {
			XSSFRow row = sheet.getRow(r);
			CableSchedule cs = new CableSchedule();
			cs.setCableFrom(row.getCell(1).getStringCellValue());
			cs.setCableTo(row.getCell(2).getStringCellValue());
			cs.setPurpose(row.getCell(3).getStringCellValue());
			cs.setCableDetails(row.getCell(4).getStringCellValue());
			cs.setCableCode(row.getCell(5).getStringCellValue());
			cs.setRemarks(row.getCell(6).getStringCellValue());
			cs.setLength(Double.valueOf(row.getCell(7).getNumericCellValue()));
			cs.setCableNo(row.getCell(8).getStringCellValue());
			al.add(cs);
			System.out.println();
		}
		
		return al;
		
	}
	
	String excelFilePath = "C:\\Users\\Narender\\Desktop\\cable schedules\\forwebsite.xlsx";
	

}
