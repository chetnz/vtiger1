package com.vtigerGenericUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readExcelData(String SheetName, int rownum, int cellnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConts.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(fis);
		String excelValue = workbook.getSheet(SheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		return excelValue;
	}

}
