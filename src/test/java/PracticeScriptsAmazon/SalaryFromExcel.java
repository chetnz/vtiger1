package PracticeScriptsAmazon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class SalaryFromExcel {
	@Test
	public void salFromExcelTest() throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\nchet\\eclipse-workspace\\SDET_mvnProj\\src\\main\\resources\\Salary.xlsx");
		Workbook w = WorkbookFactory.create(fis);
		int lastrow = w.getSheet("Sheet1").getLastRowNum();
		
		for(int i=1; i<lastrow; i++)
		{
			 double sal = w.getSheet("Sheet1").getRow(i).getCell(2).getNumericCellValue();
			if(sal>50000)
			{
				System.out.println(w.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue());
			}
		}
	}
	

}
