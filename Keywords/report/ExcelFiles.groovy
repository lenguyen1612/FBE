package report
import java.text.DateFormat
import java.text.SimpleDateFormat

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import commons.AbtractPage as AbtractPage

import com.kms.katalon.core.util.KeywordUtil

public class ExcelFiles {

	AbtractPage abtractPage = new AbtractPage()
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
	Date date = new Date()
	/**
	 * write data into the files	
	 * by: My Le 
	 * date: 06 May, 2019
	 * @param filename: the file can be write
	 * @param sheetname: the sheet name
	 * @param colname: the value cell at first row which define the column to write
	 * @param rownm: the row number need to write
	 * @param log: the log
	 * */
	private void writeExcelfiles(String filename, String sheetname, String colname, String rownm, String log) {
		String userDir = System.getProperty("user.dir");
		String filePath = userDir +  "\\PreData\\"+ filename;
		try {
			FileInputStream file = new FileInputStream (new File(filePath))
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			XSSFRow row = sheet.getRow(0);

			int number_row = Integer.parseInt(rownm);
			int number_col = 0;

			//get column number
			for (int i = 0; i< row.getLastCellNum(); i++) {
				if(row.getCell(i).getStringCellValue().trim().equals(colname)) {
					number_col = i;
					break;
				}
			}

			Cell searchText = sheet.getRow(number_row).createCell(number_col);

			searchText.setCellValue(log);
			file.close();
			FileOutputStream outFile =new FileOutputStream(new File(filePath));
			workbook.write(outFile);
			outFile.close();
		}
		catch (Exception e)
		{
			KeywordUtil.logInfo(e.getMessage())
		}
	}

	/**
	 * Write the data into the exists excel file based on file name, sheet name, column name, row name
	 * */
	private void writeExcelfilesColNameRowName(String filename, String sheetname, String colname, String rowname, String log) {
		String userDir = System.getProperty("user.dir");
		String filePath = userDir +  "\\PreData\\"+ filename;
		try {
			FileInputStream file = new FileInputStream (new File(filePath))
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			XSSFRow row = sheet.getRow(0);

			//int number_row = Integer.parseInt(rownm);
			int number_row = 0;
			int number_col = 0;

			//get column number
			for (int i = 0; i< row.getLastCellNum(); i++) {
				if(row.getCell(i).getStringCellValue().trim().equals(colname)) {
					number_col = i;
					break;
				}
			}

			//get row number
			int lastrow = sheet.getLastRowNum()
			KeywordUtil.logInfo("lastrow: " +lastrow )
			for(int ii = 0; ii< lastrow; ii++){
				if (sheet.getRow(ii).getCell(5).getStringCellValue().trim().equals(rowname)){
					number_row = ii
					break
				}
			}
			KeywordUtil.logInfo("number_row: " +number_row  + " ----- numver_col: " + number_col)
			Cell searchText = sheet.getRow(number_row).createCell(number_col);

			searchText.setCellValue(log);
			file.close();
			FileOutputStream outFile =new FileOutputStream(new File(filePath));
			workbook.write(outFile);
			outFile.close();
		}
		catch (Exception e)
		{
			println(e)
		}
	}


	/**
	 * Write multiple data follow columns in the excel file
	 * will be started from PreData folder
	 * */
	private void writeExcelfilesMulitpleCol(String filename, String sheetname, String colname,  String values) {
		String userDir = System.getProperty("user.dir");
		String filePath = userDir +  "\\PreData\\"+ filename;
		String[] ar_colname = abtractPage.splitString(colname)
		String[] ar_values = abtractPage.splitString(values)
		try {
			FileInputStream file = new FileInputStream (new File(filePath))
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			XSSFRow row = sheet.getRow(0);

			//int number_row = Integer.parseInt(rownm);
			int number_row = sheet.getLastRowNum();
			int number_col = 0;

			println "ar_colname.size(): " + ar_colname.size() + " ar_values.size(): " + ar_values.size() + " number_row: " + number_row
			//check same values
			if (ar_colname.size() == ar_values.size()){
				XSSFRow newRow = sheet.createRow(number_row+1)
				for(int k = 0; k < ar_colname.size() ; k++){
					for (int i = 0; i< row.getLastCellNum(); i++) {
						if(row.getCell(i).getStringCellValue().trim().equals(ar_colname[k].trim())) {
							number_col = i;
							Cell insertCell = newRow.createCell(i).setCellValue(ar_values[k])
						}

					}
				}
				file.close();
				FileOutputStream outFile =new FileOutputStream(new File(filePath));
				workbook.write(outFile);
				outFile.close();
			}
			else{
				println "Please check the items on the list"
			}

		}
		catch (Exception e)
		{
			println(e)
		}
	}

	private String linkString(String values){
		String finalString = ""
		return finalString += values +"\n"
	}

	private void writeResultsToExcelFile(String filename, String sheetname, String issueID, String results) {
		String userDir = System.getProperty("user.dir")
		String filePath = userDir +  "\\Reports\\Results\\"+ filename

		try {
			FileInputStream file = new FileInputStream (new File(filePath))
			XSSFWorkbook workbook = new XSSFWorkbook(file)
			XSSFSheet sheet = workbook.getSheet(sheetname)

			int number_row = sheet.getPhysicalNumberOfRows()
			//number_row += 1
			println "number_row: " +number_row
			XSSFRow row = sheet.createRow(number_row)

			//			Cell cellissueID = sheet.createRow(number_row).createCell(0).setCellValue(issueID)
			//			Cell cellresults = sheet.createRow(number_row).createCell(1).setCellValue(results)
			//			Cell celldate = sheet.createRow(number_row).createCell(2).setCellValue(dateFormat.format(date))
			//			Cell cellcomment = sheet.createRow(number_row).createCell(3).setCellValue("comment")
			row.createCell(0).setCellValue(issueID)
			row.createCell(1).setCellValue(results)
			row.createCell(2).setCellValue(dateFormat.format(date))
			row.createCell(3).setCellValue("comment")

			file.close()
			FileOutputStream outFile =new FileOutputStream(new File(filePath))
			workbook.write(outFile)
			outFile.close()
		}
		catch (Exception e)
		{
			println(e)
		}
	}

	private void writeRecordPartyID(String filename, String sheetname,String col, String results) {
		String userDir = System.getProperty("user.dir")
		String filePath = userDir +  "\\PreData\\"+ filename

		try {
			FileInputStream file = new FileInputStream (new File(filePath))
			XSSFWorkbook workbook = new XSSFWorkbook(file)
			XSSFSheet sheet = workbook.getSheet(sheetname)

			int number_row = sheet.getPhysicalNumberOfRows()
			int number_col = Integer.parseInt(col)
			//number_row += 1
			println "number_row: " +number_row
			XSSFRow row = sheet.createRow(number_row)

			row.createCell(number_col).setCellValue(results)
			//			row.createCell(1).setCellValue(results)
			//			row.createCell(2).setCellValue(dateFormat.format(date))
			//			row.createCell(3).setCellValue("comment")

			file.close()
			FileOutputStream outFile =new FileOutputStream(new File(filePath))
			workbook.write(outFile)
			outFile.close()
		}
		catch (Exception e)
		{
			println(e)
		}
	}

}