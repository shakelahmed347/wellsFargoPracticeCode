package com.qa.wellsFargo.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadData {
	
	static Workbook workbook;
	static Sheet sheet;
	
	public static String excelSheetPath ="C:\\Eclipse_New\\com.qa.wellsFargoPractice\\ExcelFolder\\testData.xlsx";
	
	public static Object[][] getDataFromExcel(String sheetName) {
		
		FileInputStream file =null;
		
		try {
			file = new FileInputStream(excelSheetPath);
		} catch (FileNotFoundException e) {
			System.out.println("Printing error :" +e.getMessage());
			e.printStackTrace();
		}
		
		try {
			//creating workbookfactory from help of apache.poi
			
			workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		sheet = workbook.getSheet(sheetName);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i<sheet.getLastRowNum(); i++) {
			for (int j = 0; j< sheet.getRow(0).getLastCellNum(); j++) {
				data [i][j] = sheet.getRow(i+1).getCell(j).toString();
				
				//System.out.println("Printing excel data : " + data[i][j]);
			}
		}
		return data;
	}

}
