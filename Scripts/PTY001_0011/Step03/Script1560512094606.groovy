import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

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

logger.logInfo("PTY001_001 - Step03 - Click Search button")
abtractPage.clickToElement(findTestObject('PartyOnboarding/PartyOnboarding/Assigned Branch search'))
logger.logInfo("PTY001_001 - Step03 - Wait the Branch List visible")
abtractPage.waitForElementInvisible(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Form_BranchList'))
logger.logInfo("PTY001_001 - Step03 - Wait the Search button visible")
abtractPage.waitForElementInvisible(findTestObject('PartyOnboarding/PartyOnboarding/Verify/btn_SearchBranchList'))
logger.logInfo("PTY001_001 - Step03 - Click Search button")
abtractPage.clickToElement(findTestObject('PartyOnboarding/PartyOnboarding/Verify/btn_SearchBranchList'))
logger.logInfo("PTY001_001 - Step03 - Wait the list visbile")
abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Data_listBranchs'))
logger.logInfo("PTY001_001 - Step03 - Verify Branch List")
logReport = partyOnboarding.verifyDropDownList(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Data_listBranchs'), branchList)
excelFiles.writeExcelfilesColNameRowName("TestCase.xlsx", "TestCase_Sample", "Actual Outcome/ Result", "Step03", logReport)
excelFiles.writeExcelfilesColNameRowName("TestCase.xlsx", "TestCase_Sample", "Results", "Step03", abtractTest.getResults(logReport))
logger.logInfo("PTY001_001 - Step03 - Close Branch List Form")
abtractPage.clickToElement(findTestObject('PartyOnboarding/PartyOnboarding/Verify/btn_CloseBranchListForm'))


