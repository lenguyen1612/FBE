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
import org.openqa.selenium.Keys as Keys

WebUI.waitForPageLoad(10)

WebUI.setText(findTestObject('Object Repository/CashDepositSameCurrency/input__uxpMenuSearch'), 'Party Onboarding' + Keys.chord(
        Keys.ENTER))

WebUI.sendKeys(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'), local_global + 
    Keys.chord(Keys.TAB), FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.click(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(3)

WebUI.sendKeys(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'), (party_type + Keys.chord(
        Keys.ARROW_DOWN)) + Keys.chord(Keys.ENTER), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

WebUI.sendKeys(findTestObject('PartyOnboarding/PartyOnboarding/Party Sub-Type'), (party_sub_type + 
    Keys.chord(Keys.ARROW_DOWN)) + Keys.chord(Keys.ENTER), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

WebUI.sendKeys(findTestObject('PartyOnboarding/PartyOnboarding/Party Category'), party_category, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/PartyOnboarding/div_Digital Channels'), digital_channels, 
    FailureHandling.CONTINUE_ON_FAILURE)

//User can be only unticked Digital Channels/Corporate  Channels
if (WebUI.verifyElementChecked(findTestObject('PartyOnboarding/PartyOnboarding/div_Digital Channels'), 
    3, FailureHandling.OPTIONAL)) {
} else {
    WebUI.click(findTestObject('PartyOnboarding/PartyOnboarding/div_Digital Channels'), FailureHandling.STOP_ON_FAILURE)
}

//click Next to finish the first step
WebUI.click(findTestObject('Object Repository/CashDepositSameCurrency/btn_Next'), FailureHandling.CONTINUE_ON_FAILURE)

//wait to load next step
WebUI.waitForElementPresent(findTestObject('PartyOnboarding/PartyOnboarding/CheckListID'), 5, 
    FailureHandling.STOP_ON_FAILURE)

//Click next again
WebUI.click(findTestObject('Object Repository/CashDepositSameCurrency/btn_Next'), FailureHandling.CONTINUE_ON_FAILURE)

//Call Pre-Existence Check
WebUI.callTestCase(findTestCase('PartyOnboarding/Pre-Existence Check/Pre-Existence Check'), [('firstname') : pre_firstname
        , ('lastname') : pre_lastname, ('dateofbirth') : pre_dateofbirth, ('email_contactnumber') : pre_email, ('national_unique') : pre_national
        , ('taxid') : pre_taxId, ('postcode') : pre_postcode], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('PartyOnboarding/PersonalParty/PersonalParty'), [('chk_TaxPayer') : person_chk_TaxPayer, ('civilStatus') : person_civilStatus
        , ('countryofbirth') : person_countryofbirth, ('countryofresidence') : person_countryofresidence, ('fathersname') : person_fathersname
        , ('gender') : person_gender, ('grandfathersname') : person_grandfathersname, ('lastname') : person_lastname, ('middlename') : person_middlename
        , ('mothersmaidenname') : person_mothersmaidenname, ('nationalindentifiertype') : person_nationalindentifiertype
        , ('nationality') : person_nationality, ('numberofdependents') : person_numberofdependents, ('previousothernames') : 'No'
        , ('religion') : person_religion, ('residentstatus') : person_residentstatus, ('shortname') : person_shortname, ('spousepartnername') : person_spousepartnername
        , ('stateofresidence') : person_stateofresidence, ('suffix') : person_suffix, ('taxexemptionstatus') : person_taxexemptionstatus
        , ('taxidnumber') : person_taxidnumber, ('taxresidencecountry') : person_taxresidencecountry, ('title') : person_title
        , ('townofbirth') : person_townofbirth, ('withholdingtaxliable') : person_withholdingtaxliable, ('other_firstname') : person_other_firstname
        , ('other_lastname') : person_other_lastname, ('other_middle') : person_other_middle, ('other_nametype') : person_other_nametype
        , ('other_title') : person_other_title, ('nationalidentifier') : person_nationalidentifier, ('employmentstatus') : person_employmentstatus
        , ('dateofbirth') : person_dateofbirth, ('taxplayer') : person_taxplayer], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('PartyOnboarding/PartyAddress/PartyAddress'), [('addresstype') : add_addresstype, ('addressstatus') : add_addressstatus
        , ('location') : add_location, ('postcode') : add_postcode, ('validfrom') : add_validfrom, ('validto') : add_validto
        , ('stateorprovince') : add_stateorprovince, ('townorcity') : add_townorcity, ('userforcommunicatrion') : add_userforcommunicatrion
        , ('addressline1') : add_addressline1, ('addressline2') : add_addressline1, ('addressline3') : add_addressline1, ('addressline4') : add_addressline1
        , ('addressline5') : add_addressline1], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('PartyOnboarding/PartyContact/PartyContact'), [('email') : contact_email, ('confirmemail') : contact_confirmemail
        , ('contactmethod') : contact_contactmethod, ('contactnumber_code') : contact_contactnumber_code, ('contactnumber_areacode') : contact_contactnumber_areacode
        , ('contacttypelocation') : contact_contacttypelocation, ('contactnumber_number') : contact_contactnumber_number
        , ('preferenceorder') : contact_preferenceorder, ('validfrom') : contact_validfrom, ('validto') : contact_validto
        , ('userforcontact') : contact_userforcontact], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('PartyOnboarding/PartyDocument/RequireDocuments'), [('documenttype') : doc_documenttype, ('documentverified') : doc_documentverified
        , ('imageId') : doc_imageId, ('referencenumber') : doc_referencenumber, ('issuingauthority') : doc_issuingauthority
        , ('documentcategory') : doc_documentcategory, ('issuingcountry') : doc_issuingcountry, ('validfrom') : doc_validfrom
        , ('validto') : doc_validto, ('kyc_expiry') : doc_kyc_expiry], FailureHandling.STOP_ON_FAILURE)

String PartyID = WebUI.getAttribute(findTestObject('PartyOnboarding/Confirmation/PartyID'), 
    'value', FailureHandling.STOP_ON_FAILURE)

println('partyid: ' + PartyID)

CustomKeywords.'commons.process_files.writeExcelfiles'('Import_PartyOnBoarding.xlsx','Personal', 'PartyID', no, 'Completed')

WebUI.click(findTestObject('Object Repository/CashDepositSameCurrency/btn_Next'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('RequiredAproval'), [:], FailureHandling.STOP_ON_FAILURE)

