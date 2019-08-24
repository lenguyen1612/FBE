import java.text.DateFormat
import java.text.SimpleDateFormat

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import report.ExcelFiles as ExcelFiles
import java.lang.Integer
import java.lang.String

ExcelFiles excelfiles = new ExcelFiles()
 String colname = "Party Type | Party ID"
 String kkkk = "Personal | A000000001"
 String abccc = colname.size()
int col = Integer.parseInt(abccc)

excelfiles.writeExcelfilesMulitpleCol("Results_Data\\PartyID.xlsx", "PartyID", colname, kkkk )

//String[] original_list = s_variable.split('\\|')
//
//println(original_list.length)
//
//int number = original_list.length //result: 3
//
//String[][] row_results = new String[number][2]
//String [] temp
//
//
//for (int i = 0; i < row_results.length; i++) {//i =3
//    for (int j = 0; j < row_results[i].length; j++) {
//        //j=2 columns
//			temp = original_list[i].split(",")					
//			row_results[i][j] = temp[j]		
//
//    }
//}

//WebUI.openBrowser("www.google.com")
//AbtractPage abtractPage = new AbtractPage()
//JiraHomePage jiraHomePage = new JiraHomePage()
//jiraHomePage.uploadTestResults(s_variable)

//
//String text = "Test Cases/DemoAutomationTesting/UAT Testing/UT-45/UT-48";
//String match = "/";
//String str
//int position = text.indexOf(match)
//
//while(position >0){
//	str = text.substring(position,text.length())
//	println "text in loop: " + str
//	position = text.indexOf(match,position)+1
//	println "position in loop: " + position
//}
//println "text: " + text
//println "position: " + position
//WebUI.getText(null, FailureHandling.STOP_ON_FAILURE)

//String test = abtractPage.replaceArrayIndexOutOfBoundsException(validFrom, 1,"")
//String [] listContactMethod = abtractPage.splitString(contactMethod)
//println "test: " + listContactMethod.length
//
//
//Date date1 = abtractPage.convertStringToDate("12-17-1990")
//String pattern ="yyyy-MM-dd"
//SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern)
////String date2 = simpleDateFormat.format(new Date())
//String date2 = simpleDateFormat.format(date1)
//println "date1 " + date1 + " date2 "+ date2 + " newdate " + new Date()


//String date1 = abtractPage.changeFormatDate("12-17-1990","MM-dd-yyyy","yyyy-MM-dd")
//println "date1: " + date1
//int abc = 123
//GlobalVariable.Testing = abtractPage
////String abc = 
//
//println "MyLe: "  + GlobalVariable.Testing.abTesting()

//float a = 1
//float b = 1.5
//println  a+b

//String abc = "2000000000777773"

//long num = long.parseLong(abc.toString())
//println "long: " + num



//BigDecimal bd = new BigDecimal("30000.1");
//long l = bd.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
//System.out.println(l);