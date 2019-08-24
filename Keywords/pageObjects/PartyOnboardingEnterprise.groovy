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
import report.ExcelFiles as ExcelFiles
import java.text.SimpleDateFormat
import java.util.Date

public class PartyOnboardingEnterprise {
	private static int longTimeout =30;
	private static FailureHandling failureHandling = FailureHandling.OPTIONAL
	//private static WebDriver driver = DriverFactory.getWebDriver()
	AbtractTest abtractTest = new AbtractTest()
	AbtractPage abtractPage = new AbtractPage()
	ExcelFiles excelFiles = new ExcelFiles()

	private void inputPartyOnboardingMenuSearch(){
		try{
			abtractPage.inputOpenScreenMenuSearch("Party Onboarding", findTestObject('Object Repository/Menu_Search'))
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
		try{
			abtractPage.clearText(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'))
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'), localGlobal)
		}
		catch(Exception e){
			println(e)
		}

	}

	/**
	 * Input Party Type
	 * using same function with Party Onboarding
	 * */
	private void inputPartyType(String partyType){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'), partyType + Keys.chord(Keys.TAB))
		}
		catch(Exception e){
			println(e)
		}

	}

	/**
	 * Input Party Sub-Type
	 * using same function with Party Onboarding
	 * */
	private void inputPartySubType(String partySubType){
		WebUI.delay(1)
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Sub-Type'), partySubType )
		}
		catch(Exception e){
			println(e)
		}
	}

	/**
	 * Input Party Category
	 * using same function with Party Onboarding
	 * */
	private void inputPartyCategory(String partyCategory){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Party Category'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Category'), partyCategory )
		}
		catch(Exception e){
			println(e)
		}
	}

	/**
	 * click Line of Business
	 * using same function with Party Onboarding
	 * */
	private void clickLineofBusiness(String lineofbusiness, TestObject corebanking){
		try{
			String val = lineofbusiness.trim()
			String [] listsPersonal = ["Corporate Channels", "Digital Channels"]
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
						//elementChannels = quickPartyEnterpriseUI.chk_CorporatePersonal(personal)
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
						//elementChannels = quickPartyEnterpriseUI.chk_CorporatePersonal(enterprise)
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

//	private void setTextForFields(String fieldname, String inputValues){
//		TestObject to, to1
//		try{
//			to = quickPartyEnterpriseUI.Enterprisefields_td(fieldname)
//			to1 = quickPartyEnterpriseUI.Enterprisefields_input(fieldname)
//			abtractPage.waitForElementVisibled(to)
//			abtractPage.clickToElementByJavascript(to)
//			abtractPage.waitForElementVisibled(to1)
//			abtractPage.sendKeyToElementByJavascript(to1, inputValues)
//		}
//		catch (Exception e){
//			println(e)
//		}
//
//	}

	
	//clickAskForApprovalbutton
	private void clickAskForApprove(){
		try{
			if(WebUI.waitForElementPresent(findTestObject('PartyOnboarding/Personal/PersonalParty/btn_Warnings_Proceed_NotCapture'),5,FailureHandling.OPTIONAL))
			{
				abtractPage.clickToElement(findTestObject('PartyOnboarding/Personal/PersonalParty/btn_Warnings_Proceed_NotCapture'))
			}
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyApproval/Supervisor Authorization required'))
			abtractPage.clickToElement(findTestObject('PartyOnboarding/PartyApproval/Supervisor Authorization required'))
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * Input Registered Number
	 * using same function with Party Onboarding
	 * */
	private void inputRegisteredNumber(String nregisteredNumber){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/QuickPartyOnboarding_Personal/Enterprise/Registered Number_txt'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/QuickPartyOnboarding_Personal/Enterprise/Registered Number_txt'), nationalIdentifireType + Keys.chord(Keys.TAB))
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
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Enterprise/EnterpriseParty/Short Name_txt'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Enterprise/EnterpriseParty/Short Name_txt'), shortName + Keys.chord(Keys.TAB))
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
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding_Personal/Personal/Address Type_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding_Personal/Personal/Address Type_txt'), addressType + Keys.chord(Keys.TAB))
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
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding_Personal/Personal/Country Region_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding_Personal/Personal/Country Region_txt'), countryRegion + Keys.chord(Keys.TAB))
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
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding_Personal/Personal/Post Code_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding_Personal/Personal/Post Code_txt'), postCode + Keys.chord(Keys.TAB))
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
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding_Personal/Personal/Contact Type_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding_Personal/Personal/Contact Type_txt'), contactType + Keys.chord(Keys.TAB))
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
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding_Personal/Personal/Email_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding_Personal/Personal/Email_txt'), email + Keys.chord(Keys.TAB))
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
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding_Personal/Personal/Confirm Email_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding_Personal/Personal/Confirm Email_txt'), confirmEmail + Keys.chord(Keys.TAB))
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
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding_Personal/Personal/Contact Type For Mobile_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding_Personal/Personal/Contact Type For Mobile_txt'), contactTypeMobile + Keys.chord(Keys.TAB))
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
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding_Personal/Personal/Mobile Number_txt'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding_Personal/Personal/Mobile Number_txt'), countryCode + Keys.chord(Keys.TAB))
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
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding_Personal/Personal/Number'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding_Personal/Personal/Number'), number + Keys.chord(Keys.TAB))
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
			abtractPage.waitForElementVisibled(findTestObject('QuickPartyOnboarding_Personal/Personal/Document Collection Status_ddl'))
			abtractPage.sendkeyToElement(findTestObject('QuickPartyOnboarding_Personal/Personal/Document Collection Status_ddl'), documentStatus + Keys.chord(Keys.TAB))
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
	 * Same PartyOnboardingPersonal class
	 * Address part
	 * */
	private void inputRDataForAddressParty(String addressType, String useOfCommunication, String validFrom){
		String [] listAddresses = abtractPage.splitString(addressType)
		try{
			for (int i = 0; i < listAddresses.length; i++){
				//click New Row
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyAddress/button_New Row_PartyAddress'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyAddress/button_New Row_PartyAddress'))

				//input Address type
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyAddress/Address Type'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyAddress/Address Type'), listAddresses[i].trim() + Keys.chord(Keys.ENTER))
				//input valid from
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyAddress/Valid From'))
				abtractPage.clearText(findTestObject('PartyOnboarding/Personal/PartyAddress/Valid From'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyAddress/Valid From'), abtractPage.replaceArrayIndexOutOfBoundsException(validFrom, i,""))
				//tick Use Of Communication
				if (abtractPage.replaceArrayIndexOutOfBoundsException(useOfCommunication, i, "").equals("Yes")){
					abtractPage.waitForElementPresent(findTestObject('PartyOnboarding/Personal/PartyAddress/chk_Use  for Communication'))
					abtractPage.checkTheCheckbox(findTestObject('PartyOnboarding/Personal/PartyAddress/chk_Use  for Communication'))
				}
				//click Save Row
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyAddress/SaveRow'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyAddress/SaveRow'))

			}
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * Same PartyOnboardingPersonal class
	 * Contact part
	 * */
	private void inputDataForPartyContacts(String contactMethod, String contactTypeLocation,String contactnumber_code, String contactnumber_areacode, String contactnumber_number, String email, String confirmemail, String validFrom){
		String [] listContactMethod = abtractPage.splitString(contactMethod)
		println "inputDataForPartyContacts: " + listContactMethod.length
		try{
			for (int k = 0; k < listContactMethod.length; k++){
				println "inputDataForPartyContacts [k]" + k
				//click New Row
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/New Row'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyContacts/New Row'))

				//input Contact Method
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Method'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Method'), listContactMethod[k].trim() + Keys.chord(Keys.ENTER))
				//input Contact Type Location
				WebUI.delay(1)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Type  Location'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Type  Location'), abtractPage.replaceArrayIndexOutOfBoundsException(contactTypeLocation, k,""))
				//input Number
				if (WebUI.verifyElementHasAttribute(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Email'), 'readonly', 3, FailureHandling.OPTIONAL))
				{
					//Country Code
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'))
					abtractPage.clearText(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'))
					abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'), abtractPage.replaceArrayIndexOutOfBoundsException(contactnumber_code,k,""))
					//Area Code
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_AreaCode'))
					abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_AreaCode'), abtractPage.replaceArrayIndexOutOfBoundsException(contactnumber_areacode,k,""))
					//Number
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_Number'))
					abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_Number'), abtractPage.replaceArrayIndexOutOfBoundsException(contactnumber_number,k,""))
				}
				//Email
				if (WebUI.verifyElementHasAttribute(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'), 'readonly', 3, FailureHandling.OPTIONAL))
				{
					//Contact Email
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Email'))
					abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Email'), abtractPage.replaceArrayIndexOutOfBoundsException(email,k,""))
					//Confirm Email
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Confirm Email'))
					abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Confirm Email'), abtractPage.replaceArrayIndexOutOfBoundsException(confirmemail,k,""))
				}

				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Valid From'))
				abtractPage.clearText(findTestObject('PartyOnboarding/Personal/PartyContacts/Valid From'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Valid From'), abtractPage.replaceArrayIndexOutOfBoundsException(validFrom,k,""))

				//click Save Row
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Save Row'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyContacts/Save Row'))
			}
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * Same PartyOnboardingPersonal class
	 * Required Document part
	 * */
	private void inputDataForPartyRequiredDocuments(String documentcategory, String kyc_expiry,String documenttype, String validfrom, String validto, String referencenumber, String issuingauthority, String issuingcountry, String documentverified, String image){
		String [] listDocumentCategory = abtractPage.splitString(documentcategory)
		try{
			for (int j = 0; j < listDocumentCategory.length; j++){
				//click New Row
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/New Row'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/New Row'))

				//input Document Category
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/DocumentCategory'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/DocumentCategory'), listDocumentCategory[j].trim() + Keys.chord(Keys.ENTER))
				//input KYC ExpiryDate
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/KYCExpiryDate'))
				WebUI.delay(1)
				abtractPage.clearText(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/KYCExpiryDate'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/KYCExpiryDate'), abtractPage.replaceArrayIndexOutOfBoundsException(kyc_expiry, j,""))
				//Document Type
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Document Type'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Document Type'), abtractPage.replaceArrayIndexOutOfBoundsException(documenttype, j,""))
				//Valid From document
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Valid From_document'))
				abtractPage.clearText(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Valid From_document'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Valid From_document'), abtractPage.replaceArrayIndexOutOfBoundsException(validfrom, j,""))
				//Valid to document
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Valid To_document'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Valid To_document'), abtractPage.replaceArrayIndexOutOfBoundsException(validto, j,""))
				//Reference Number
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/input_Reference Number'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/input_Reference Number'), abtractPage.replaceArrayIndexOutOfBoundsException(referencenumber, j,""))
				//Issuing Authority
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Issuing Authority'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Issuing Authority'), abtractPage.replaceArrayIndexOutOfBoundsException(issuingauthority, j,""))
				//Issuing Country
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Issuing Country'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Issuing Country'), abtractPage.replaceArrayIndexOutOfBoundsException(issuingcountry, j,""))
				//Document Verified
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Document Verified'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Document Verified'), abtractPage.replaceArrayIndexOutOfBoundsException(documentverified, j,""))
				//Image
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Image ID_03'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Image ID_03'), abtractPage.replaceArrayIndexOutOfBoundsException(image, j,""))

				//click Save Row
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Save Row'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Save Row'))

			}
		}
		catch(Exception e){
			println (e)
		}
	}
}