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
import commons.AbtractTest as AbtractTest

	PartyOnboarding partyOnboarding = new PartyOnboarding()
	AbtractTest abtractTest = new AbtractTest()
	ExcelFiles excelFiles = new ExcelFiles()
	KeywordUtil log = new KeywordUtil()
	String results = ""
	String steps = ""
	
	WebUI.delay(3)
	steps = "1"
	log.logInfo("---UT-48 Step0" + steps + " Input Party Onboarding into MenuSearch ---")
	partyOnboarding.inputPartyOnboardingMenuSearch()
	
	log.logInfo("---UT-48 Step0" + steps + " Verify Default Values is displayed ---")
	results = steps + "," + partyOnboarding.isDefaultValuesDisplayed(s01_verifyLocalGlobal, s01_verifyEntity, s01_verifyBranch)
	
	steps = "2"
	log.logInfo("---UT-48 Step0" + steps + " Showing the lists of locations Local Public, Global, Local Private ---")
	partyOnboarding.clickLocationDropdownlist()
	results += "|" + steps + "," + partyOnboarding.isShowingCorrectlyTheListOfLocations(s02_listLocalGlobal)
	
	steps = "3"
	log.logInfo("---UT-48 Step0" + steps + " Showing the lists of locations Local Public, Global, Local Private ---")
	results += "|" + steps + "," + partyOnboarding.isDisplayedTheListBranchesCorrectly(s03_branchList)
		
	steps = "4"
	log.logInfo("---UT-48 Step0" + steps + " Varify Required fields ---")
	results += "|" + steps + "," + partyOnboarding.isCheckRequiredFieldsByNextButton()
	
	steps = "5"
	log.logInfo("---UT-48 Step0" + steps + " Input Local Global ---")
	partyOnboarding.inputLocalGlobal(s05_localglobal)
	log.logInfo("---UT-48 Step0" + steps + " Input Party Type ---")
	partyOnboarding.inputPartyType(s05_partytype)
	log.logInfo("---UT-48 Step0" + steps + " Input Party Sub Type ---")
	partyOnboarding.inputPartySubType(s05_partysubtype)
	log.logInfo("---UT-48 Step0" + steps + " Input Party Category ---")
	partyOnboarding.inputPartyCategory(s05_partycategory)
	log.logInfo("---UT-48 Step0" + steps + " Check Line of Business ---")
	partyOnboarding.clickLineofBusiness(s05_lineofbusiness, findTestObject('DemoAutomationTesting_temp/Creating Party Onboarding/PartyOnboarding/div_Core Banking'))
	log.logInfo("---UT-48 Step0" + steps + " Verify all channels under Line of Business checked ---")
	results += "|" + steps + "," + partyOnboarding.isLineOfBusinessItemsTicked()
	
	steps = "6"
	log.logInfo("---UT-48 Step0" + steps + " Verify the Party Check List ---")
	results += "|" + steps + "," + partyOnboarding.isPartyCheckListDisplayed()
	
	steps = "7"
	log.logInfo("---UT-48 Step0" + steps + " Verify the Pre-Existence Check ---")
	results += "|" + steps + "," + partyOnboarding.isPreExistenceCheckDisplayed()
	
	steps = "8"
	log.logInfo("---UT-48 Step0" + steps + " First Name, Last Name and Date Birth dsplayed correctly in Personal Party screen ---")
	log.logInfo("---UT-48 Step0" + steps + " Input First Name ---")
	partyOnboarding.setTextFirstName(s08_firstname)
	log.logInfo("---UT-48 Step0" + steps + " Input Last Name ---")
	partyOnboarding.setTextLastName(s08_lastname)
	log.logInfo("---UT-48 Step0" + steps + " Input Date Of Birth  ---")
	partyOnboarding.setTextDateBirth(s08_dateofbirth)	
	log.logInfo("---UT-48 Step0" + steps + " Click Next button ---")
	partyOnboarding.clickNextbutton()
	results += "|" + steps + "," + partyOnboarding.isFirstNameLastNameDOBDisplayed(s08_firstname,s08_lastname,s08_dateofbirth)
		
	steps = "9"
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party ---")
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Nation Identifer Type ---")
	partyOnboarding.inputNationalIdentifierType(s09_nationIdentifierType)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Nation Identifer ---")
	partyOnboarding.inputNationalIdentifier(s09_nationIdentifier)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Title ---")
	partyOnboarding.inputTitle(s09_title)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Employment Status ---")
	partyOnboarding.inputEmploymentStatus(s09_employmentStatus)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Gender ---")
	partyOnboarding.inputGender(s09_gender)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Civil Status ---")
	partyOnboarding.inputCivilStatus(s09_civilStatus)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Mother's Maiden Name ---")
	partyOnboarding.inputMotherMaidenName(s09_motherMaidenName)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Short Name ---")
	partyOnboarding.inputShortName(s09_shortName)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Grandfather's Name ---")
	partyOnboarding.inputGrandfatherName(s09_grandfatherName)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Nationality ---")
	partyOnboarding.inputNationality(s09_nationality)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Resident Status ---")
	partyOnboarding.inputResidentStatus(s09_residentStatus)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Tax ID Number ---")
	partyOnboarding.inputTaxIDNumber(s09_taxIDNumber)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Input Religion ---")
	partyOnboarding.inputReligion(s09_religion)
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Click Next button ---")
	partyOnboarding.clickNextbutton()
	log.logInfo("---UT-48 Step0" + steps + " Key in data all required fields on Personal Party - Click Process on Warning box ---")
	partyOnboarding.clickProcessInWarningBox()
		
	steps = "10"
	log.logInfo("---UT-48 Step0" + steps + " Input required fields for Party Address ---")
	log.logInfo("---UT-48 Step0" + steps + " Input required fields for Party Address - Input Address Type, User of Communication and Valid From---")
	partyOnboarding.inputRDataForAddressParty(s10_addressType, s10_userForCommunication, s10_validFrom)
	log.logInfo("---UT-48 Step0" + steps + " Input required fields for Party Address - click Next button---")
	partyOnboarding.clickNextbutton()
	log.logInfo("---UT-48 Step0" + steps + " Input required fields for Party Address - verify Party Contacts screen displayed---")
	results += "|" + steps + "," + partyOnboarding.isPartyContactsDisplayed()
	
	steps = "11"
	log.logInfo("---UT-48 Step0" + steps + " Input data for Party Contacts ---")
	partyOnboarding.inputDataForPartyContacts( s11_contactMethod, s11_contactTypeLocation ,s11_contactCountryCode , s11_contactAreaCode , s11_contactNumber , s11_contactEmail, s11_confirmEmail , s11_validFrom )
	log.logInfo("---UT-48 Step0" + steps + " Input data for Party Contacts - click Next ---")
	partyOnboarding.clickNextbutton()
	log.logInfo("---UT-48 Step0" + steps + " Input data for Party Contacts - verify Party Required Documents screen displayed---")
	results += "|" + steps + "," + partyOnboarding.isPartyRequiredDocumentsDisplayed()
	
	steps = "12"
	log.logInfo("---UT-48 Step0" + steps + " Input Party Required Documents ---")
	partyOnboarding.inputDataForPartyRequiredDocuments( s12_documentCategory, s12_kycExpired,s12_documentType, s12_validFrom, s12_validTo, s12_referenceNumber, s12_issuingAuthority, s12_issuingCountry, s12_documentVerified, s12_image)
	log.logInfo("---UT-48 Step0" + steps + " Input Party Required Documents - Click Next button---")
	//results += "|" + steps + "," + 
	
//	steps = "13"
//	log.logInfo("---UT-48 Step0" + steps + " Verify the Pre-Existence Check ---")
//	results += "|" + steps + "," + partyOnboarding.isPreExistenceCheckDisplayed()
	
	excelFiles.writeResultsToExcelFile("ActualResults.xlsx", "Results", abtractTest.getTestCaseID(GlobalVariable.testCaseID), results)
	