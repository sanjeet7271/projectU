package com.projectU.utility.excel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelReader {
	String xlFilePath = "./src/main/resources/testData/stops.xlsx";
	String sheetName = "points";
	ExcelSheetReader ProvideData=new ExcelSheetReader();
	Object[][] data;
	@DataProvider(name = "stops")
	public Object[][] CredentialtoLogin() throws Exception {
		data = ProvideData.testData(xlFilePath, sheetName);
        return data;
	}
	@Test(dataProvider="stops")
	public void stops(String lat, String lng){
		System.out.println(data);
		
	}
}
