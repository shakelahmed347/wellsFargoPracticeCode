package com.qa.wellsFargo.Utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class WellsFargoUtils {
	
	public static WebDriver driver =null;
	public static Properties  prop =null;
	public static FileInputStream file =null;
	public static XSSFWorkbook workbook =null;
	public static XSSFSheet sheet =null;
	
	public static int implicitywait =20 ;
	public static int explicitywait = 20;
	
	public static String propertiesFilePath = "C:\\Eclipse_New\\com.qa.wellsFargoPractice\\src\\main\\java\\com\\qa\\dataUtils\\confiq\\confiq.properties";
	public static  String excelFilePath = "C:\\Eclipse_New\\com.qa.wellsFargoPractice\\ExcelFolder\\testData.xlsx";
}
