package com.qa.wellsFargo.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.wellsFargo.Utils.WellsFargoUtils;

public class Base extends WellsFargoUtils {

	static String propertyValue=null;

	public static String getPro(String k) {
		try {
			file = new FileInputStream(propertiesFilePath);
			prop = new Properties();
			prop.load(file);
			file.close();
			propertyValue = prop.getProperty(k);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return propertyValue;

	}

	public void failed(String testMethodName) {
		
		// get real time in screenShot 
		String date = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile, new File("C:\\Eclipse_New\\com.qa.wellsFargoPractice\\screenShot\\"+ date + testMethodName +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
