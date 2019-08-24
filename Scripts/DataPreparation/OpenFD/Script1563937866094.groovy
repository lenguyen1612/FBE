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

import pageObjects.OpenFD as OpenFD
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import commons.AbtractTest 

KeywordUtil log = new KeywordUtil()
OpenFD openFD = new OpenFD()


log.logInfo("--- Open Fixed Deposit - Customer and Currency Details ---")
openFD.inputOpenFDMenuSearch()
openFD.inputCustomerNumber(s01_customerNumber)
openFD.clickJointAccount(s01_jointAccount)
openFD.inputCurrency(s01_currency)
openFD.inputBranch(s01_branch)

log.logInfo("--- Open Fixed Deposit - Product and Mode of Payment ---")
openFD.inputSubProduct(s01_subProduct)
openFD.inputMoOfPayment(s01_modeOfPayment)
openFD.inputMultipleFundingAccounts(s01_modeOfPayment, s01_multipleFundingAccount)
openFD.inputTransferType(s01_modeOfPayment, s01_transferType)
openFD.inputContraAccountNumber(s01_modeOfPayment, s01_contraAccountNumber)
openFD.inputChequeNumber(s01_modeOfPayment, s01_chequeNumber)

log.logInfo("--- Open Fixed Deposit - Tenor Details ---")
openFD.inputTerm(s01_term)
openFD.inputTermFrequency(s01_termFrequency)
openFD.inputFixedDepositAmount(s01_fixedDepositAmount)
openFD.inputForeignCurrency(s01_foreignCurrency) // once choose it, foreign amount automatically will be changed
//openFD.inputExchangeRate(s01_exchangeRate) don't allow to change
//openFD.inputForeignAmount(s01_foreignAmount) no need to input, cannot change

log.logInfo("--- Open Fixed Deposit - Interrst Details ---")
openFD.inputCapitalisationMethod(s01_capitalisationMethod)
openFD.inputPayCapital_InterestToAccount(s01_capitalisationMethod, s01_payCapitalToAccount, s01_payInterestToAccount)
openFD.clickNextButton()

log.logInfo("--- Open Fixed Deposit - click Next to Fixed Deposit Review ---")
openFD.isCustomerIDDisplayed()
openFD.clickNextButton()

log.logInfo("--- Open Fixed Deposit - click Next to complete creation account openning ---")
openFD.isCustomerCodeDisplayed()
openFD.clickNextButton()

log.logInfo("--- Open Fixed Deposit - click Ask for Approval ---")
openFD.clickAskToApprove()



