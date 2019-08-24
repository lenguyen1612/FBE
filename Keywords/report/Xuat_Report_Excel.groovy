package report;
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
class Xuat_Report_Excel {
	def  Map<String, Row> idMapping = new HashMap<String, Row>();
	def XSSFWorkbook myWorkBook =null;
	def createIDMapping(String fileName){
		File f = new File(fileName);
		if(f.exists() && f.isFile()){
			FileInputStream fis = new FileInputStream(f);
			myWorkBook = new XSSFWorkbook (fis);

			// Chọn sheet mong muốn import/export kết quả
			XSSFSheet mySheet = myWorkBook.getSheetAt(1);

			Iterator<Row> rowIterator = mySheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Cell cell =row.getCell(0);
				idMapping.put(cell.getStringCellValue(), row);
			}
			fis.close();
		}
	}

	@BeforeTestSuite
	def openFile(TestSuiteContext context){
		// Mở file excel theo đường dẫn
		createIDMapping("D:\\HEL-537978_Thanh Toán Phí Ngoài Tiền Điện EVN Hà Nội\\HEL-259123_Tao_Template_Moi.xlsx");
	}
	@AfterTestSuite
	def writeFile(TestSuiteContext context){
		if(myWorkBook!=null){
			// Export kết quả vào file excel theo đường dẫn
			FileOutputStream os = new FileOutputStream("D:\\HEL-537978_Thanh Toán Phí Ngoài Tiền Điện EVN Hà Nội\\HEL-259123_Tao_Template_Moi.xlsx");
			myWorkBook.write(os);
			os.close();
		}
	}

	// Hàm set giá trị vào cell
	def setCell(Row row,int i,String value){
		Cell cell = row.getCell(i);
		if(cell==null){
			cell = row.createCell(i);
		}
		cell.setCellValue(value);
	}
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 * 
	 */
	@AfterTestCase
	def reportAfterTestCase(TestCaseContext testCaseContext) {
		def map = testCaseContext.getTestCaseVariables();
		if(map.containsKey("testCaseID")){
			if(myWorkBook!=null){
				Row row = idMapping.get(map.get("testCaseID").toString());
				if(row!=null){
					setCell(row, 5, testCaseContext.getTestCaseStatus());
					// Get FT_Code
					if (map.get("FT_Code").toString()!="") {
						setCell(row, 8, map.get("FT_Code").toString());
					}
					setCell(row, 11, testCaseContext.getMessage());
					setCell(row, 12, map.get("Path_Evidents").toString());
				}
			}
		}
	}
}