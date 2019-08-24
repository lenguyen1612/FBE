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

import pageObjects.QuickPartyEnterprise as QuickPartyEnterprise
import report.ExcelFiles as ExcelFiles
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
//import commons.AbtractTest as AbtractTest


KeywordUtil log = new KeywordUtil()
QuickPartyEnterprise quickPartyEnterprise = new QuickPartyEnterprise()

WebUI.delay(3)
log.logInfo("--- " + " Open Quick Party Onboarding in Menu Search ---")
quickPartyEnterprise.inputQuickPartyOnboardingMenuSearch()

log.logInfo("/---------------Party Onboarding---------------/")
log.logInfo("--- " + " Input Local Global ---")
quickPartyEnterprise.inputLocalGlobal(s01_localglobal)
log.logInfo("--- " + " Input Party Type ---")
quickPartyEnterprise.inputPartyType(s01_partytype)
log.logInfo("--- " + " Input Party Sub Type ---")
quickPartyEnterprise.inputPartySubType(s01_partysubtype)
log.logInfo("--- " + " Input Party Category ---")
quickPartyEnterprise.inputPartyCategory(s01_partycategory)
log.logInfo("--- " + " Check Line of Business ---")
quickPartyEnterprise.clickLineofBusiness(s01_lineofbusiness, findTestObject('PartyOnboarding/PartyOnboarding/div_Core Banking'))
log.logInfo("--- " + " Click Next to Party Check List  ---")
quickPartyEnterprise.clickNextbutton()
WebUI.delay(1)

log.logInfo("/---------------Pre-Existence Check---------------/")
quickPartyEnterprise.setTextForFields("Enterprise name", s02_enterpriseName)
quickPartyEnterprise.setTextForFields("Registered number", s02_registeredNumber)
quickPartyEnterprise.setTextForFields("Goods & services tax registered number", s02_goodsResisterNumber)
quickPartyEnterprise.setTextForFields("Email/ Contact Number", s02_contact)
quickPartyEnterprise.clickNextbutton()

log.logInfo("/---------------Quick Party Onboarding---------------/")
log.logInfo("--- " + " Input Registered Number ---")
quickPartyEnterprise.inputRegisteredNumber(s03_registeredNumber)
log.logInfo("--- " + " Input Short Name ---")
quickPartyEnterprise.inputShortName(s03_shortName)

log.logInfo("/---------------Quick Party Onboarding - Address---------------/")
log.logInfo("--- " + " Input Address Type ---")
quickPartyEnterprise.inputAddressType(s03_addressType)
log.logInfo("--- " + " Input Country/ Region ---")
quickPartyEnterprise.inputCountryRegion(s03_countryRegion)
log.logInfo("--- " + " Input Post Code ---")
quickPartyEnterprise.inputPostCode(s03_postCode)

log.logInfo("/---------------Quick Party Onboarding - Email---------------/")
log.logInfo("--- " + " Input Contact Type ---")
quickPartyEnterprise.inputContactType(s03_contactType)
log.logInfo("--- " + " Input Email ---")
quickPartyEnterprise.inputEmail(s03_email)
log.logInfo("--- " + " Input Confirm Email ---")
quickPartyEnterprise.inputConfirmEmail(s03_confirmEmail)

log.logInfo("/---------------Quick Party Onboarding - Mobile---------------/")
log.logInfo("--- " + " Input Contact Type Mobile---")
quickPartyEnterprise.inputContactTypeMobile(s03_contactTypeMobile)
log.logInfo("--- " + " Input Country Code---")
quickPartyEnterprise.inputCountryCode(s03_countryCode)
log.logInfo("--- " + " Input Number---")
quickPartyEnterprise.inputNumber(s03_number)

log.logInfo("/---------------Quick Party Onboarding - Document Status---------------/")
log.logInfo("--- " + " Input Document Collection Status---")
quickPartyEnterprise.inputDocumentStatus(s03_documentStatus)

log.logInfo("--- " + " Click Next button ---")
quickPartyEnterprise.clickNextbutton()
log.logInfo("--- " + " Click Process on Warning box ---")
quickPartyEnterprise.clickAskForApprove()
