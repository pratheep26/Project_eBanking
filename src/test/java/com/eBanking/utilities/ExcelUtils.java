package com.eBanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public  static CellStyle style;
	static String path=null;

	ExcelUtils(String path)
	{
		ExcelUtils.path=path;
	}


	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
		fi=new FileInputStream(xlfile);
		workBook=new XSSFWorkbook(fi);
		sheet=workBook.getSheet(xlsheet);
		int rowCount=sheet.getLastRowNum();
		workBook.close();
		fi.close();
		return rowCount;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		workBook=new XSSFWorkbook(fi);
		sheet=workBook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workBook.close();
		fi.close();
		return cellCount;
	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		workBook=new XSSFWorkbook(fi);
		sheet=workBook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);

		DataFormatter formatter=new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		} catch (Exception e) {

			data="";
		}
		workBook.close();
		fi.close();
		return data;
	}

	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException
	{
		fi=new FileInputStream(path);
		workBook=new XSSFWorkbook(fi);
		sheet=workBook.getSheet(sheetName);

		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);

		fo=new FileOutputStream(path);
		workBook.write(fo);
		workBook.close();
		fi.close();
		fo.close();
	}
	
	public void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		workBook=new XSSFWorkbook(fi);
		sheet=workBook.getSheet(xlsheet);

		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workBook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		workBook.write(fo);
		workBook.close();
		fi.close();
		fo.close();
	}

}
