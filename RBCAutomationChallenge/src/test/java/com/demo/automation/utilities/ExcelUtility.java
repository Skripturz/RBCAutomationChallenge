package com.demo.automation.utilities;

import java.util.ArrayList;

import com.demo.automation.constant.Constant;

public class ExcelUtility {
	
	static XlsxReader reader;
	
	public static ArrayList<Object[]> getData() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			
			reader = new XlsxReader(Constant.DATAFILEPATH);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum <= reader.getRowCount("TestData"); rowNum++) {
			
			String item = reader.getCellData("TestData", "item", rowNum);
			int quantity = (int) Double.parseDouble(reader.getCellData("TestData", "quantity", rowNum));
			String email = reader.getCellData("TestData", "email", rowNum);
			String bfirstname = reader.getCellData("TestData", "billing_firstname", rowNum);
			String blastname = reader.getCellData("TestData", "billing_lastname", rowNum);
			String baddress = reader.getCellData("TestData", "billing_address", rowNum);
			String bcity = reader.getCellData("TestData", "billing_city", rowNum);
			String bstate = reader.getCellData("TestData", "billing_state", rowNum);
			String bcountry = reader.getCellData("TestData", "billing_country", rowNum);
			String bpostalcode = reader.getCellData("TestData", "billing_postalcode", rowNum);
			String bphone = reader.getCellData("TestData", "billing_phone", rowNum);
			String saba = reader.getCellData("TestData", "saba", rowNum);

		
			Object obj[] = {item, quantity, email, bfirstname, blastname, baddress, bcity, bstate, bcountry, bpostalcode, bphone, saba};
			
			myData.add(obj);
		}
		
		return myData;
	}
}
