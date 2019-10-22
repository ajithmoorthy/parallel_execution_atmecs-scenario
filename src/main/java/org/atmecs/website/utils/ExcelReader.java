package org.atmecs.website.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * Excel reader class have the method to read the excel file using the apache
 * poi jar file
 */
public class ExcelReader {
	//this method will read the .xlsx file and give it to the data provider
	public String[][] excelDataProviderArray(String path) throws IOException {
		File file = new File(path);
		FileInputStream fileInput = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(fileInput);
		Sheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		rowCount += 1;
		// System.out.println(row1);
		int columnCount = sheet.getRow(0).getLastCellNum();
		String array[][] = new String[rowCount][columnCount];
		int count = 0;
		for (Row row : sheet) {
			int count1 = 0;
			for (Cell cell : row) {
				String data = cell.toString();
				array[count][count1] = data;
				count1++;
			}
			count++;
		}
		return array;
	}
	public String[][] excelDataProviderArray(String path, int sheetIndex) throws IOException {
		File file = new File(path);
		FileInputStream fileInput = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(fileInput);
		Sheet sheet = book.getSheetAt(sheetIndex);
		int rowCount = sheet.getLastRowNum();
		rowCount += 1;
		// System.out.println(row1);
		int columnCount = sheet.getRow(sheetIndex).getLastCellNum();
		String array[][] = new String[rowCount][columnCount];
		int count = 0;
		for (Row row : sheet) {
			int count1 = 0;
			for (Cell cell : row) {
				String Data = cell.toString();
				array[count][count1] = Data;
				count1++;
			}
			count++;
		}
		return array;
	}
}
