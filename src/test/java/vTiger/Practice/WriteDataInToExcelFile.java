package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInToExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step1: open the docu in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Batch.xlsx");
		
		//step2: creaye the workbook 
		Workbook wb=WorkbookFactory.create(fis);
		
		//step3: get the control of sheet
		Sheet sh =wb.getSheet("ContactTC_ID");
		
		//step4: Create a row
		Row rw = sh.createRow(10);
		
		//step5: Create a cell
		Cell c= rw.createCell(7);	
		
		//step6:Set the value into the cell
		c.setCellValue("Batman");
		
		//step7:open the file in writable format 
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Batch.xlsx");
		
		//step8: write the data into workbook
		wb.write(fos);
		
		//step9: close the workbook
		wb.close();
		System.out.println("Data added and Workbook closed");
		
		

	}

}
