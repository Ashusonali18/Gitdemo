package orangehrmExceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {
	@DataProvider
	public String [][] getdata() throws IOException
	{
		
	File excelfile = new File("C:\\Users\\Shree\\eclipse-workspace\\DataDRivenTEst\\src\\test\\resources\\Test.xlsx");
	System.out.println(excelfile.exists());
	FileInputStream fis = new FileInputStream(excelfile);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet  = workbook.getSheet("Sheet1");
	//System.out.println(sheet.getPhysicalNumberOfRows());
	int rowno= sheet.getPhysicalNumberOfRows();
	int clono =sheet.getRow(0).getLastCellNum();
	String data [] [] = new String[rowno-1][clono];
	for (int i=0;i< rowno-1;i++)
	{
		for(int j=0;j< clono;j++)
		{
			DataFormatter df = new DataFormatter();
			
	
	data [i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
	
		// System.out.println(	sheet.getRow(i).getCell(j).getStringCellValue());
			
		}
		System.out.println();
	}
	
	workbook.close();
	fis.close();
//	for(String[] dataarr: data)
//	{
//	
//		System.out.println(Arrays.toString(dataarr));
//	}
	// System.out.println(Arrays.toString(data));
	return data;
	
}
}