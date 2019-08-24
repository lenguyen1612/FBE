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
import pageObjects.OpenAccountCASA as OpenAccountCASA
import report.ExcelFiles as ExcelFiles
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


OpenAccountCASA openAccountCASA = new OpenAccountCASA()
KeywordUtil log = new KeywordUtil()

WebUI.delay(2)
log.logInfo("----- Open Account page -----")
openAccountCASA.inputOpenAccountMenuSearch()

log.logInfo("----- Create Customer Account -----")
log.logInfo("----- Input Customer ID -----")
openAccountCASA.inputCustomer(s01_customer)

log.logInfo("----- Click Joint Account -----")
openAccountCASA.clickJointAccount(s01_jointAccount)

log.logInfo("----- Input Sub Product -----")
openAccountCASA.inputSubProduct(s01_subProduct)

log.logInfo("----- Input Currency -----")
openAccountCASA.inputCurrency(s01_currency)

log.logInfo("----- Click Product -----")
openAccountCASA.clickProduct(s01_productID)

log.logInfo("----- Click Next to Account Mandate Details-----")
openAccountCASA.clickNextbutton()

log.logInfo("----- Click Next to Create Customer Account-----")
openAccountCASA.isCustomerIDDisplayed()
openAccountCASA.clickNextbutton()

log.logInfo("----- Click Limit Indicator -----")
openAccountCASA.inputLimitIndicator(s01_limitIndicator)

log.logInfo("----- input Passbook required field UDF -----")
openAccountCASA.inputPassbook(s01_passbook)

log.logInfo("----- Click Next -----")
openAccountCASA.clickNextbutton()

//Ask to Approve
log.logInfo("----- Click Ask To Approve -----")
openAccountCASA.clickAskToApprove()