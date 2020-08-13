package flipkartExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	String data[] = new String[3];

	public String[] readExcel() throws Exception
	{
		//Read data from excel sheet
		File filepath = new File("C:\\Users\\user\\Desktop\\Codes\\TestData\\flipkartTest.xlsx");

		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);

		Row row = sh.getRow(1);

		for(int i=0;i<2;i++)
		{
			String input = row.getCell(i).getStringCellValue();
			data[i]=input;
			wb.close();
		}

		//Return the value from excel sheet
		return data;

	}

}
