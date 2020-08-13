package flipkartExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel 
{
	public void getValues1(String firstItemName1, String firstItemPrice1, String secondItemName1,
			String secondItemPrice1,String totalCartValue1) throws IOException
	{
		//Writing data in excel sheet
		XSSFWorkbook wb = new XSSFWorkbook(); 

		XSSFSheet sh1= wb.createSheet("Initial_FlipkartData");

		//Creating first row
		Row row1 = sh1.createRow(0);

		//Creating header cell
		Cell c1 = row1.createCell(0);
		c1.setCellValue("Item Name");

		Cell c2 = row1.createCell(1);
		c2.setCellValue("Item Price");

		Cell c3 = row1.createCell(2);
		c3.setCellValue("Total price");

		/*Inserting values into cells
		 * Creating second row
		 */
		Row row2 = sh1.createRow(1);

		Cell c4 = row2.createCell(0);
		c4.setCellValue(firstItemName1);

		Cell c5 = row2.createCell(1);
		c5.setCellValue(firstItemPrice1);

		Cell c6 = row2.createCell(2);
		c6.setCellValue(totalCartValue1);

		//Creating third row
		Row row3 = sh1.createRow(2);

		Cell c7 = row3.createCell(0);
		c7.setCellValue(secondItemName1);

		Cell c8 = row3.createCell(1);
		c8.setCellValue(secondItemPrice1);

		//To set date-time format for the output file
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File file = new File("C:\\Users\\user\\Desktop\\Codes\\TestData\\Output_flipkartData\\Initial_FlipkartData"+timestamp+".xlsx");
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
	}


	public void getValues2(String firstItemName, String firstItemPrice, String secondItemName, 
			String secondItemPrice, String thirdItemName, String thirdItemPrice, String updatedCartValue) throws IOException
	{

		XSSFWorkbook wb = new XSSFWorkbook(); 
		XSSFSheet sh2= wb.createSheet("Updated_FlipkartData");

		//Creating first row
		Row row4 = sh2.createRow(0);

		//Creating header cell
		Cell c9 = row4.createCell(0);
		c9.setCellValue("Item Name");

		Cell c10 = row4.createCell(1);
		c10.setCellValue("Item Price");

		Cell c11 = row4.createCell(2);
		c11.setCellValue("Updated total price");

		/*Inserting values into cells
		 * Creating second row
		 */
		Row row5 = sh2.createRow(1);

		Cell c12 = row5.createCell(0);
		c12.setCellValue(firstItemName);

		Cell c13 = row5.createCell(1);
		c13.setCellValue(firstItemPrice);

		Cell c14 = row5.createCell(2);
		c14.setCellValue(updatedCartValue);

		//Creating third row
		Row row6 = sh2.createRow(2);

		Cell c15 = row6.createCell(0);
		c15.setCellValue(secondItemName);

		Cell c16 = row6.createCell(1);
		c16.setCellValue(secondItemPrice);

		//Creating fourth row
		Row row7 = sh2.createRow(3);

		Cell c17 = row7.createCell(0);
		c17.setCellValue(thirdItemName);

		Cell c18 = row7.createCell(1);
		c18.setCellValue(thirdItemPrice);

		//To set date-time format for the output file
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File file = new File("C:\\Users\\user\\Desktop\\Codes\\TestData\\Output_flipkartData\\Updated_FlipkartData"+timestamp+".xlsx");
		FileOutputStream fos = new FileOutputStream(file);
		
		wb.write(fos);
		wb.close();

	}

}
