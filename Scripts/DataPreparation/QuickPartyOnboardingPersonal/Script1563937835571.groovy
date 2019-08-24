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

import pageObjects.QuickPartyPersonal as QuickPartyPersonal
import report.ExcelFiles as ExcelFiles
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
//import commons.AbtractTest as AbtractTest


KeywordUtil log = new KeywordUtil()
QuickPartyPersonal quickPartyPersonal = new QuickPartyPersonal()

WebUI.delay(3)
steps = "01"
log.logInfo("--- " + steps + " Open Quick Party Onboarding in Menu Search ---")
quickPartyPersonal.inputQuickPartyOnboardingMenuSearch()

log.logInfo("/---------------Party Onboarding---------------/")
log.logInfo("--- " + steps + " Input Local Global ---")
quickPartyPersonal.inputLocalGlobal(s05_localglobal)
log.logInfo("--- " + steps + " Input Party Type ---")
quickPartyPersonal.inputPartyType(s05_partytype)
log.logInfo("--- " + steps + " Input Party Sub Type ---")
quickPartyPersonal.inputPartySubType(s05_partysubtype)
log.logInfo("--- " + steps + " Input Party Category ---")
quickPartyPersonal.inputPartyCategory(s05_partycategory)
log.logInfo("--- " + steps + " Check Line of Business ---")
quickPartyPersonal.clickLineofBusiness(s05_lineofbusiness, findTestObject('PartyOnboarding/PartyOnboarding/div_Core Banking'))
log.logInfo("--- " + steps + " Click Next to Party Check List  ---")
quickPartyPersonal.clickNextbutton()
WebUI.delay(1)
/*
log.logInfo("/---------------Pre-Existence Check---------------/")
steps = "03"
log.logInfo("--- " + steps + " Input data on Party Pre-Existence Check  ---")
quickPartyPersonal.setTextFirstName(s08_firstname)
log.logInfo("--- " + steps + " Input Last Name ---")
quickPartyPersonal.setTextLastName(s08_lastname)
log.logInfo("--- " + steps + " Input Date Of Birth  ---")
quickPartyPersonal.setTextDateBirth(s08_dateofbirth)
log.logInfo("--- " + steps + " Click Next button ---")
quickPartyPersonal.clickNextbutton()

log.logInfo("/---------------Quick Party Onboarding---------------/")
steps = "04"
log.logInfo("--- " + steps + " Input Nation Identifer Type ---")
quickPartyPersonal.inputNationalIdentifierType(s09_nationIdentifierType)
log.logInfo("--- " + steps + " Input Nation Identifer Type ---")
quickPartyPersonal.inputNationality(s09_nationality)
log.logInfo("--- " + steps + " Input Nation Identifer ---")
quickPartyPersonal.inputNationalIdentifier(s09_nationIdentifier)
log.logInfo("--- " + steps + " Input Title ---")
quickPartyPersonal.inputTitle(s09_title)
log.logInfo("--- " + steps + " Input Civil Status ---")
quickPartyPersonal.inputCivilStatus(s09_civilStatus)
log.logInfo("--- " + steps + " Input Employment Status ---")
quickPartyPersonal.inputEmploymentStatus(s09_employmentStatus)
log.logInfo("--- " + steps + " Input Tax Residence Country ---")
quickPartyPersonal.inputTaxResidenceCountry(s09_taxResidenceCountry)
log.logInfo("--- " + steps + " Input Mother's Maiden Name ---")
quickPartyPersonal.inputMotherMaidenName(s09_motherMaidenName)
log.logInfo("--- " + steps + " Input Tax ID Number ---")
quickPartyPersonal.inputTaxIDNumber(s09_taxIDNumber)
log.logInfo("--- " + steps + " Input Gender ---")
quickPartyPersonal.inputGender(s09_gender)
log.logInfo("--- " + steps + " Input Grandfather's Name ---")
quickPartyPersonal.inputGrandfatherName(s09_grandfatherName)
log.logInfo("--- " + steps + " Input Country of Residence ---")
quickPartyPersonal.inputCountryofResidence(s09_countryOfResidence)
log.logInfo("--- " + steps + " Input Religion ---")
quickPartyPersonal.inputReligion(s09_religion)
log.logInfo("--- " + steps + " Input Short Name ---")
quickPartyPersonal.inputShortName(s09_shortName)

log.logInfo("/---------------Quick Party Onboarding - Address---------------/")
log.logInfo("--- " + steps + " Input Address Type ---")
quickPartyPersonal.inputAddressType(s09_addressType)
log.logInfo("--- " + steps + " Input Country/ Region ---")
quickPartyPersonal.inputCountryRegion(s09_countryRegion)
log.logInfo("--- " + steps + " Input Post Code ---")
quickPartyPersonal.inputPostCode(s09_postCode)

log.logInfo("/---------------Quick Party Onboarding - Email---------------/")
log.logInfo("--- " + steps + " Input Contact Type ---")
quickPartyPersonal.inputContactType(s09_contactType)
log.logInfo("--- " + steps + " Input Email ---")
quickPartyPersonal.inputEmail(s09_email)
log.logInfo("--- " + steps + " Input Confirm Email ---")
quickPartyPersonal.inputConfirmEmail(s09_confirmEmail)

log.logInfo("/---------------Quick Party Onboarding - Mobile---------------/")
log.logInfo("--- " + steps + " Input Contact Type Mobile---")
quickPartyPersonal.inputContactTypeMobile(s09_contactTypeMobile)
log.logInfo("--- " + steps + " Input Country Code---")
quickPartyPersonal.inputCountryCode(s09_countryCode)
log.logInfo("--- " + steps + " Input Number---")
quickPartyPersonal.inputNumber(s09_number)

log.logInfo("/---------------Quick Party Onboarding - Document Status---------------/")
log.logInfo("--- " + steps + " Input Document Collection Status---")
quickPartyPersonal.inputDocumentStatus(s09_documentStatus)

log.logInfo("--- " + steps + " Click Next button ---")
quickPartyPersonal.clickNextbutton()
log.logInfo("--- " + steps + " Click Process on Warning box ---")
quickPartyPersonal.clickProcessInWarningBox()
*/