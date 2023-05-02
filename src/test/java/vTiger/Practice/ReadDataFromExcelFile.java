package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		//step1: Open the document in java readable format using fileinputstream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Batch.xlsx");
		
		
		//step2: Creatye a workbook using Workbook factory
		Workbook wb=WorkbookFactory.create(fis);
		
		//step3: get the control of sheet
		Sheet sh =wb.getSheet("Organization");
		
		//step4: get the control of row
		Row rw = sh.getRow(4);
		
		//step5: get the controil of cell
		Cell c= rw.getCell(2);
		
		//step6: read the data inside the cell
		String Value = c.getStringCellValue();
		System.out.println(Value);
		
		//step7: close the workbook
		wb.close();
		
		
	}

}
