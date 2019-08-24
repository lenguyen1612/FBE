package pageObjects
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import org.openqa.selenium.Keys
import commons.AbtractPage as AbtractPage
import commons.AbtractTest as AbtractTest
//import interfaces.PartyOnboardingUI
import report.ExcelFiles as ExcelFiles
import java.text.SimpleDateFormat
import java.util.Date

public class QuickPartyPersonal {
	private static int longTimeout =30;
	private static FailureHandling failureHandling = FailureHandling.OPTIONAL
	//private static WebDriver driver = DriverFactory.getWebDriver()
	//PartyOnboardingUI partyOnboardingUI = new PartyOnboardingUI()
	AbtractTest abtractTest = new AbtractTest()
	AbtractPage abtractPage = new AbtractPage()
	ExcelFiles excelFiles = new ExcelFiles()

	private void inputQuickPartyOnboardingMenuSearch(){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Menu_Search'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Menu_Search'), 'Quick Party Onboarding' + Keys.chord(Keys.ENTER))
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}

	/**
	 * Input Local/Global
	 * using same function with Party Onboarding
	 * */
	private void inputLocalGlobal(String localGlobal){
		abtractPage.clearText(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'))
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'))
		abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'), localGlobal)
	}

	/**
	 * Input Party Type
	 * using same function with Party Onboarding
	 * */
	private void inputPartyType(String partyType){
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'))
		abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'), partyType + Keys.chord(Keys.TAB))
	}

	/**
	 * Input Party Sub-Type
	 * using same function with Party Onboarding
	 * */
	private void inputPartySubType(String partySubType){
		WebUI.delay(1)
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'))
		abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Sub-Type'), partySubType )
	}

	/**
	 * Input Party Category
	 * using same function with Party Onboarding
	 * */
	private void inputPartyCategory(String partyCategory){
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Party Category'))
		abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Category'), partyCategory )
	}

	/**
	 * click Line of Business
	 * using same function with Party Onboarding
	 * */
	private void clickLineofBusiness(String lineofbusiness, TestObject corebanking){
		try{
			String val = lineofbusiness.trim()
			String [] listsPersonal = [
				"Corporate Channels",
				"Digital Channels"
			]
			String [] listsEnterprise = ["Corporate Channels"]
			TestObject elementChannels

			abtractPage.waitForElementVisibled(corebanking)
			abtractPage.checkTheCheckbox(corebanking)

			switch (val){
				case "All":
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/chk_SelectAllLineOfBusiness'))
					abtractPage.checkTheCheckbox(findTestObject('PartyOnboarding/PartyOnboarding/chk_SelectAllLineOfBusiness'))
				case "Digital Channels":
					for(String personal : listsPersonal){
						//elementChannels = partyOnboardingUI.chk_CorporatePersonal(personal)
						elementChannels = findTestObject('PartyOnboarding/PartyOnboarding/LineofBusiness_List',['description':personal])
						abtractPage.waitForElementVisibled(elementChannels)
						abtractPage.checkTheCheckbox(elementChannels)
					}
				case "Core Banking":
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/chk_SelectAllLineOfBusiness'))
					abtractPage.uncheckTheCheckbox(findTestObject('PartyOnboarding/PartyOnboarding/chk_SelectAllLineOfBusiness'))
					abtractPage.waitForElementVisibled(corebanking)
					abtractPage.checkTheCheckbox(corebanking)
				case "Corporate Channels":
					for(String enterprise : listsEnterprise){
						//elementChannels = partyOnboardingUI.chk_CorporatePersonal(enterprise)
						elementChannels = findTestObject('PartyOnboarding/PartyOnboarding/LineofBusiness_List',['description':enterprise])
						abtractPage.waitForElementVisibled(elementChannels)
						abtractPage.checkTheCheckbox(elementChannels)
					}
			}
		}
		catch (Exception e){
			println(e)
		}
	}

	private void clickNextbutton(){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
			abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * Input First Name
	 * using same function with Party Onboarding
	 * */
	private void setTextFirstName(String fristName){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/First Name'))
			abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/First Name'))
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/First Name 01'))
			abtractPage.sendKeyToElementByJavascript(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/First Name 01'), fristName)
		}
		catch (Exception e){
			println(e)
		}

	}

	/**
	 * Input Last Name
	 * using same function with Party Onboarding
	 * */
	private void setTextLastName(String lastName){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/Last Name'))
			abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/Last Name'))
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/Last Name 01'))
			abtractPage.sendKeyToElementByJavascript(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/Last Name 01'), lastName)
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Date of birth
	 * using same function with Party Onboarding
	 * */
	private void setTextDateBirth(String dateBirth){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/Date of Birth'))
			abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/Date of Birth'))
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/Date of Birth 01'))
			abtractPage.sendKeyToElementByJavascript(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/Date of Birth 01'), dateBirth)
		}
		catch (Exception e){
			println(e)
		}
	}

	private void clickProcessInWarningBox(){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/btn_Warnings_Proceed_NotCapture'))
			abtractPage.clickToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/btn_Warnings_Proceed_NotCapture'))
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * Input National Identifier Type
	 * using same function with Party Onboarding
	 * */
	private void inputNationalIdentifierType(String nationalIdentifireType){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_NationalIdentifierType'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_NationalIdentifierType'), nationalIdentifireType + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input National Identifier
	 * using same function with Party Onboarding
	 * */
	private void inputNationalIdentifier(String nationalIdentifire){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_NationalIdentifier'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_NationalIdentifier'), nationalIdentifire + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Title
	 * using same function with Party Onboarding
	 * */
	private void inputTitle(String title){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Title'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Title'), title + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Employment Status
	 * using same function with Party Onboarding
	 * */
	private void inputEmploymentStatus(String employmentStatus){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_EmploymentStatus'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_EmploymentStatus'), employmentStatus + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Tax Residence Country
	 * */
	private void inputTaxResidenceCountry(String taxResidenceCountry){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Tax Residence Country_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Tax Residence Country_txt'), taxResidenceCountry + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Gender
	 * using same function with Party Onboarding
	 * */
	private void inputGender(String gender){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Gender'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Gender'), gender + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Civil Status
	 * using same function with Party Onboarding
	 * */
	private void inputCivilStatus(String civilStatus){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_CivilStatus'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_CivilStatus'), civilStatus + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Mother's Maiden Name
	 * using same function with Party Onboarding
	 * */
	private void inputMotherMaidenName(String motherMaidenName){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_MothersMaidenName'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_MothersMaidenName'), motherMaidenName + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Short Name
	 * using same function with Party Onboarding
	 * */
	private void inputShortName(String shortName){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_ShortName'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_ShortName'), shortName + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Address Type
	 * */
	private void inputAddressType(String addressType){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Address Type_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Address Type_txt'), addressType + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Country/ Region
	 * */
	private void inputCountryRegion(String countryRegion){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Country Region_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Country Region_txt'), countryRegion + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Post Code
	 * */
	private void inputPostCode(String postCode){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Post Code_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Post Code_txt'), postCode + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Contact Type
	 * */
	private void inputContactType(String contactType){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Contact Type_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Contact Type_txt'), contactType + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Email
	 * */
	private void inputEmail(String email){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Email_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Email_txt'), email + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Confirm Email
	 * */
	private void inputConfirmEmail(String confirmEmail){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Confirm Email_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Confirm Email_txt'), confirmEmail + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Contact Type Mobile
	 * */
	private void inputContactTypeMobile(String contactTypeMobile){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Contact Type For Mobile_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Contact Type For Mobile_txt'), contactTypeMobile + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Country Code - Mobile Number
	 * */
	private void inputCountryCode(String countryCode){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Mobile Number_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Mobile Number_txt'), countryCode + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Number
	 * */
	private void inputNumber(String number){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Number'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Number'), number + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}


	/**
	 * Input Document Collection Status
	 * */
	private void inputDocumentStatus(String documentStatus){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Document Collection Status_ddl'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Document Collection Status_ddl'), documentStatus + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Grandfather's Name
	 * */
	private void inputGrandfatherName(String grandfatherName){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_GrandfathersName'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_GrandfathersName'), grandfatherName + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Country of Residence
	 * */
	private void inputCountryofResidence(String countryResidence){
		try{
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding/Personal/Country of Residence_txt'))
			abtractPage.clearText(findTestObject('QuickPartyOnboarding/Personal/Country of Residence_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding/Personal/Country of Residence_txt'), countryResidence + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Nationality
	 * */
	private void inputNationality(String nationality){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Nationality'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Nationality'), nationality + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Resident Status
	 * */
	private void inputResidentStatus(String residentStatus){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_ResidentStatus'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_ResidentStatus'), residentStatus)
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Resident Status
	 * */
	private void inputTaxIDNumber(String taxIDNumber){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_TaxIDNumber'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/txt_TaxIDNumber'), taxIDNumber + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}
	/**
	 * Input Religion
	 * */
	private void inputReligion(String religion){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Religion'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/ddl_Religion'), religion + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}
}