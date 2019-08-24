import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import commons.AbtractPage as AbtractPage
import commons.AbtractTest as AbtractTest
import pageObjects.PartyOnboarding as PartyOnboarding
import report.ExcelFiles as ExcelFiles

KeywordUtil logger = new KeywordUtil()
AbtractPage abtractPage = new AbtractPage()
AbtractTest abtractTest = new AbtractTest()
PartyOnboarding partyOnboarding = new PartyOnboarding()
ExcelFiles excelFiles = new ExcelFiles()
String logReport = ""
String valuesbf= ""
String valuesat = ""


logger.logInfo("PTY001_001 - Step04 - Get the value from attribute before DOM change")
valuesbf = abtractPage.getAttributeValue(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Step04/errorMessage_mandatoryFields'), "class")
logger.logInfo("PTY001_001 - Step04 - Click Next button")
abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
logger.logInfo("PTY001_001 - Step04 - Wait the Error message")
abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Step04/errorMessage_mandatoryFields'))
logger.logInfo("PTY001_001 - Step04 - Get the value from attribute after DOM change")
valuesat = abtractPage.getAttributeValue(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Step04/errorMessage_mandatoryFields'), "class")
logReport = "Varify Mandatory fields - Results: " + partyOnboarding.verifyMandatoryFields(valuesbf, valuesat)
excelFiles.writeExcelfilesColNameRowName("TestCase.xlsx", "TestCase_Sample", "Actual Outcome/ Result", "Step04", logReport)
excelFiles.writeExcelfilesColNameRowName("TestCase.xlsx", "TestCase_Sample", "Results", "Step04", abtractTest.getResults(logReport))

