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
import org.openqa.selenium.Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import commons.AbtractPage as AbtractPage
import commons.AbtractTest as AbtractTest
import pageObjects.PartyOnboarding as PartyOnboarding
import report.ExcelFiles as ExcelFiles
//import interfaces.PartyOnboardingUI as PartyOnboardingUI 

KeywordUtil logger = new KeywordUtil()
AbtractPage abtractPage = new AbtractPage()
AbtractTest abtractTest = new AbtractTest()
PartyOnboarding partyOnboarding = new PartyOnboarding()
ExcelFiles excelFiles = new ExcelFiles()
String logReport = ""

logger.logInfo("PTY001_001 - Step05 - Input data")
abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'), localglobal)
abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'), partytype + Keys.chord(Keys.TAB))
abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Sub-Type'), partysubtype)
abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Category'), partycategory)
partyOnboarding.clickLineofBusiness(lineofbusiness, findTestObject('PartyOnboarding/PartyOnboarding/div_Core Banking'))