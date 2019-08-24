import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.context.TestCaseContext as TestCaseContext
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import commons.AbtractPage as AbtractPage
import commons.AbtractTest as AbtractTest
import report.ExcelFiles as ExcelFiles
import pageObjects.PartyOnboarding as PartyOnboarding

KeywordUtil logger = new KeywordUtil()
PartyOnboarding partyOnboarding = new PartyOnboarding()
ExcelFiles excelFiles = new ExcelFiles()
String logReport = ""

WebUI.delay(3)

logger.logInfo("---LOG---PTY001_001 - Step01 - Open Party Onboarding---LOG---")
partyOnboarding.openPartyOnboardingwithMenuSearch()

logger.logInfo("---LOG---PTY001_001 - Step01 - Verify Local/Global---LOG---")
abtractPage.waitForElementPresence(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'))
logReport = excelFiles.linkString("PTY001_001 - Step01 - Verify Local/Global - Results: "+abtractPage.verifyEqualsString(abtractPage.getAttributeValue(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'),"value"), verifyLocalGlobal))

logger.logInfo("---LOG---PTY001_001 - Step01 - Verify Entity---LOG---")
abtractPage.waitForElementPresence(findTestObject('PartyOnboarding/PartyOnboarding/lbl_Entity'))
logReport += excelFiles.linkString("Verify Entity - Results: "+abtractPage.verifyEqualsString(abtractPage.getAttributeValue(findTestObject('PartyOnboarding/PartyOnboarding/lbl_Entity'),"value"), verifyEntity))

logger.logInfo("---LOG---PTY001_001 - Step01 - Verify Assgined Branch---LOG---")
abtractPage.waitForElementPresence(findTestObject('PartyOnboarding/PartyOnboarding/Assigned Branch txt'))
logReport +=  excelFiles.linkString("Verify Assgined Branch - Results: "+abtractPage.verifyEqualsString(abtractPage.getAttributeValue(findTestObject('PartyOnboarding/PartyOnboarding/Assigned Branch txt'),"value"), verifyBranch))

excelFiles.writeExcelfilesColNameRowName("TestCase.xlsx", "TestCase_Sample", "Actual Outcome/ Result", "Step01", logReport)
excelFiles.writeExcelfilesColNameRowName("TestCase.xlsx", "TestCase_Sample", "Results", "Step01", abtractTest.getResults(logReport))

