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

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_NationalIdentifierType'), nationalindentifiertype, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_NationalIdentifier'), nationalidentifier, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Title'), title, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Suffix'), suffix, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_EmploymentStatus'), employmentstatus, 
    FailureHandling.STOP_ON_FAILURE)

/*Don't input First Name, Pre-Existence will be done*/
WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Gender'), gender, FailureHandling.STOP_ON_FAILURE)

//Previous Other Names
if (previousothernames == 'Yes') {
    WebUI.click(findTestObject('PartyOnboarding/Personal/PersonalParty/chk_PreviousOtherNames'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('PartyOnboarding/Personal/PersonalParty/Party Previous or Other Names/btn_NewRow'), 
        3, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('PartyOnboarding/Personal/PersonalParty/Party Previous or Other Names/btn_NewRow'), 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/Party Previous or Other Names/txt_FirstName'), 
        other_firstname, FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/Party Previous or Other Names/txt_LastName'), 
        other_lastname, FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/Party Previous or Other Names/txt_MiddleName'), 
        other_middle, FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/Party Previous or Other Names/txt_NameType'), 
        other_nametype, FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/Party Previous or Other Names/ddl_Title'), 
        other_title, FailureHandling.STOP_ON_FAILURE)
}

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_MiddleName'), middlename, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/cld_DateOfBirth'), 
    dateofbirth, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_MothersMaidenName'), mothersmaidenname, 
    FailureHandling.STOP_ON_FAILURE)

/*Don't input Last Name, Pre-Existence will be done*/
WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_CivilStatus'), civilStatus, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_FathersName'), fathersname, FailureHandling.STOP_ON_FAILURE)

/*Check the Short Name displayed or not - this is the configuration issue*/
if (WebUI.verifyElementVisible(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_ShortName'), FailureHandling.OPTIONAL)) {
    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_ShortName'), shortname, FailureHandling.STOP_ON_FAILURE)
}

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Religion'), religion, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_GrandfathersName'), grandfathersname, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Nationality'), nationality, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_ResidentStatus'), residentstatus, 
    FailureHandling.STOP_ON_FAILURE)

if (withholdingtaxliable == 'Yes') {
    WebUI.click(findTestObject('PartyOnboarding/Personal/PersonalParty/chk_WithholdingTaxLiable'), FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.getText(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_CountryOfBirth'), FailureHandling.STOP_ON_FAILURE) == 
' ') {
    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_CountryOfBirth'), countryofbirth, 
        FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.getText(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_TaxResidenceCountry'), FailureHandling.STOP_ON_FAILURE) == 
' ') {
    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_TaxResidenceCountry'), taxresidencecountry, 
        FailureHandling.STOP_ON_FAILURE)
}

if (WebUI.verifyElementVisible(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_TaxExemptionStatus'), 
    FailureHandling.OPTIONAL)) {
    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_TaxExemptionStatus'), taxexemptionstatus, 
        FailureHandling.STOP_ON_FAILURE)
}

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_TownOfBirth'), townofbirth, FailureHandling.STOP_ON_FAILURE)

/*Check what's default Tax Player field*/
WebUI.click(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_SpousePartnerName'), spousepartnername, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_StateOfResidence'), stateofresidence, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)
WebUI.click(findTestObject('PartyOnboarding/btn_Next')
	, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)
WebUI.click(findTestObject('PartyOnboarding/Personal/PersonalParty/btn_Warnings_Proceed_NotCapture'), FailureHandling.STOP_ON_FAILURE)
