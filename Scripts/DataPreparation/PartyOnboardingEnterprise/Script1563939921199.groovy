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

import pageObjects.PartyOnboarding as PartyOnboarding
import report.ExcelFiles as ExcelFiles
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
//import commons.AbtractTest as AbtractTest


KeywordUtil log = new KeywordUtil()
PartyOnboarding partyOnboardingEnterprise = new PartyOnboarding()

WebUI.delay(3)
log.logInfo("--- Open Party Onboarding in Menu Search ---")
partyOnboardingEnterprise.inputPartyOnboardingMenuSearch()

log.logInfo("/---------------Party Onboarding---------------/")
log.logInfo("--- Input Local Global ---")
partyOnboardingEnterprise.inputLocalGlobal(s01_localglobal)
log.logInfo("--- Input Party Type ---")
partyOnboardingEnterprise.inputPartyType(s01_partytype)
log.logInfo("--- Input Party Sub Type ---")
partyOnboardingEnterprise.inputPartySubType(s01_partysubtype)
log.logInfo("--- Input Party Category ---")
partyOnboardingEnterprise.inputPartyCategory(s01_partycategory)
log.logInfo("--- Check Line of Business ---")
partyOnboardingEnterprise.clickLineofBusiness(s01_lineofbusiness, findTestObject('PartyOnboarding/PartyOnboarding/div_Core Banking'))
log.logInfo("--- Click Next to Party Check List  ---")
partyOnboardingEnterprise.clickNextbutton()
WebUI.delay(1)
partyOnboardingEnterprise.clickNextbutton()
log.logInfo("/---------------Pre-Existence Check---------------/")
partyOnboardingEnterprise.inputEnterpriseName(s02_enterpriseName)
partyOnboardingEnterprise.inputRegistration()
partyOnboardingEnterprise.clickNextbutton()

log.logInfo("/--------------- Party Onboarding---------------/")
//Only input required fields

partyOnboardingEnterprise.inputPartyId()
//partyOnboardingEnterprise.inputRegisteredNumber(s03_registeredNumber) alter Pre-Existence Check step, it will be automatically displayed
partyOnboardingEnterprise.inputShortNameEnterprise(s03_shortName)
partyOnboardingEnterprise.clickNextbutton()
partyOnboardingEnterprise.clickProcessInWarningBox()

log.logInfo("/--------------- Party Onboarding - Address---------------/")
partyOnboardingEnterprise.inputRDataForAddressParty(s04_addressType, s04_userForCommunication, s04_validFrom)
partyOnboardingEnterprise.clickNextbutton()
partyOnboardingEnterprise.inputDataForPartyContacts( s05_contactMethod, s05_contactTypeLocation ,s05_contactCountryCode , s05_contactAreaCode , s05_contactNumber , s05_contactEmail, s05_confirmEmail , s05_validFrom )
partyOnboardingEnterprise.clickNextbutton()
partyOnboardingEnterprise.inputDataForPartyRequiredDocuments( s06_documentCategory, s06_kycExpired,s06_documentType, s06_validFrom, s06_validTo, s06_referenceNumber, s06_issuingAuthority, s06_issuingCountry, s06_documentVerified, s06_image, s06_documentCollectionStatus)
partyOnboardingEnterprise.clickNextbutton()
WebUI.delay(1)
log.logInfo("--- " + " Click Next button ---")
partyOnboardingEnterprise.clickNextbutton()
log.logInfo("--- " + " Click Next button ---")
WebUI.delay(1)
partyOnboardingEnterprise.clickNextbutton()
log.logInfo("--- " + " Click Process on Warning box ---")
partyOnboardingEnterprise.clickAskForApprovalbutton()
