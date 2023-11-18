package com.cg.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class utilities {
	
	public static final int Implicit_Wait_Time= 10;
	public static final int Page_Wait_Time=5;
	
	public static String  generateEmailWithTimeStamp() {
		Date date = new Date();
		String timestamp= date.toString().replace(" ", "_").replace(":", "_");
		return "satradhruv1809"+timestamp+"@gmail.com";
		

}
	
	public static Object[][] getdatafromExcel(String sheetName) {
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\cg\\testdata\\tutorialsninjadata.xlsx");
		XSSFWorkbook workbook = null ;
		try {
		FileInputStream fisExcel = new FileInputStream(excelFile);
		
		workbook = new XSSFWorkbook(fisExcel);
		}catch(Throwable e ) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		 int rows = sheet.getLastRowNum();
		 int cols= sheet.getRow(0).getLastCellNum();
		 
		 Object [][] data = new Object[rows][cols];
		 for(int i = 0; i<rows; i++) {
			 XSSFRow row= sheet.getRow(i+1);
			 for(int j = 0; j<cols; j++) {
				 XSSFCell cell = row.getCell(j);
				 
				 //4.27
				 org.apache.poi.ss.usermodel.CellType cellType = cell.getCellType();
				 
				 switch(cellType) {
				 case STRING:
					 data[i][j]= cell.getStringCellValue();
					 break;
				 case NUMERIC:
					data[i][j]= Integer.toString((int)cell.getNumericCellValue());
					 // data[i][j]= Integer.toString(int)cell.getNumericCellValue();
					 break;
				 case BOOLEAN:
					 data[i][j] = cell.getBooleanCellValue();
					 break;
					 
					 
					 
					 
				 }
				 
			 }
		 }
		
		return data;
	}
	

}
