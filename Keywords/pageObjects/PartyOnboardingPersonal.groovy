package pageObjects

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import interfaces.PartyOnboardingUI as PartyOnboardingUI
import commons.AbtractPage as AbtractPage
import commons.AbtractTest as AbtractTest
import report.ExcelFiles as ExcelFiles
import java.text.SimpleDateFormat
import java.util.Date

public class PartyOnboardingPersonal{
	private static int longTimeout =30;
	private static FailureHandling failureHandling = FailureHandling.OPTIONAL
	private static WebDriver driver = DriverFactory.getWebDriver()
	PartyOnboardingUI partyOnboardingUI = new PartyOnboardingUI()
	AbtractTest abtractTest = new AbtractTest()
	AbtractPage abtractPage = new AbtractPage()
	ExcelFiles excelFiles = new ExcelFiles()


	/**
	 * UT-48 Step01 - Verify Default Values is displayed
	 */

	private void inputPartyOnboardingMenuSearch(){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Menu_Search'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Menu_Search'), 'Party Onboarding' + Keys.chord(Keys.ENTER))
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}

	private String isDefaultValuesDisplayed(String verifyLocalGlobal, String verifyLocation, String verifyAssgnedBranch){
		String values = ""
		String local = ""
		abtractPage.waitForElementPresent(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Local Global'))
		local = WebUI.getAttribute(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Local Global'),"value").toString()
		values =  abtractPage.verifyEqualsString(local, verifyLocalGlobal)
		abtractPage.waitForElementPresent(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/lbl_Entity'))
		values +=  abtractPage.verifyEqualsString(abtractPage.getAttributeValue(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/lbl_Entity'),"value"), verifyLocation)
		abtractPage.waitForElementPresent(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Assigned Branch txt'))
		values +=  abtractPage.verifyEqualsString(abtractPage.getAttributeValue(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Assigned Branch txt'),"value"), verifyAssgnedBranch)

		values = abtractTest.getFinalResults(values)
		return values
	}
	/**
	 * UT-48 - Step02 - Click Location dropdownlist to show all items
	 * */
	private void clickLocationDropdownlist(){
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/input_Local Global'))
		abtractPage.clickToElement(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/input_Local Global'))
	}
	/**
	 * UT-48 - Step02 - Showing the lists of locations Local Public, Global, Local Private
	 * */
	private String isShowingCorrectlyTheListOfLocations(String items){
		String values = ""
		int k = 0
		String[] listitems = abtractPage.splitString(items)
		try {
			List<WebElement> elements = WebUI.findWebElements(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/div_Global'),longTimeout )
			//check the number items
			int elementSize = elements.size()
			int listItemssize = listitems.size()
			if (elementSize==listItemssize)
			{
				for(WebElement element: elements)
				{
					for (String list: listitems)
					{
						if(element.getText().trim().equals(list.trim())){
							k += 1
							//KeywordUtil.logInfo("k: " + k + " element " + element.getText() + " list " + list)
						}
					}
				}
				if(elements.size().equals(k)){
					values ="PASSED"
				}
			}
			else
			{
				values ="FAILED"
			}
		}
		catch(Exception e) {
			values ="ERROR"
			WebUI.takeScreenshot()
			println(e)
		}
		return values
	}

	/**
	 * UT-48 - Step03 - Check correctly the list of Branches - Click the search button (Branches)
	 * */
	private void clickSearchBranchButton (){
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Assigned Branch search'))
		abtractPage.clickToElement(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Assigned Branch search'))
	}
	/**
	 * UT-48 - Step03 - Check correctly the list of Branches - Verify the list branch is correct
	 * */
	private String isDisplayedTheListBranchesCorrectly(String branchList){
		String values = ""
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Assigned Branch search'))
		abtractPage.clickToElement(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Assigned Branch search'))
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/Form_BranchList'))
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/btn_SearchBranchList'))
		abtractPage.clickToElement(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/btn_SearchBranchList'))
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/Data_listBranchs'))
		values = abtractPage.isverifyDropDownList(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/Data_listBranchs'), abtractPage.splitString(branchList))
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/btn_CloseBranchListForm'))
		abtractPage.clickToElement(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/btn_CloseBranchListForm'))
		return values
	}
	/**
	 * UT-48 - Step04 - Verify the require fields are blank - Click Next button
	 * */
	private String isCheckRequiredFieldsByNextButton(){
		String valuebf, valueaf, values
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/Step04/errorMessage_mandatoryFields'))
		valuebf = abtractPage.getAttributeValue(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/Step04/errorMessage_mandatoryFields'), "class")
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/btn_Next'))
		//abtractPage.clickToElement(findTestObject('Creating Party Onboarding_temp/btn_Next'))
		WebUI.click(findTestObject('Creating Party Onboarding_temp/btn_Next'))
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/Step04/errorMessage_mandatoryFields'))
		valueaf = abtractPage.getAttributeValue(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/Step04/errorMessage_mandatoryFields'), "class")
		values = verifyMandatoryFields(valuebf, valueaf)
		return values
	}
	private String verifyMandatoryFields(String beforevalue, String aftervalue){
		/*If the value of a attribute same, it means that DOM isn't changed*/
		String values = ""
		try{
			if(beforevalue.trim().equals(aftervalue.trim())){
				values = "FAILED"
			}
			else {
				values = "PASSED"}
		}
		catch(Exception e){
			values ="ERROR"
			WebUI.takeScreenshot()
			println(e)
		}
		return values
	}

	/**
	 * UT-48 - Step05 - Input data and verify Line of Business will be ticked all - Input Local/Global
	 * */
	private void inputLocalGlobal(String localGlobal){
		abtractPage.clearText(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Local Global'))
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Local Global'))
		abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Local Global'), localGlobal)
	}

	/**
	 * UT-48 - Step05 - Input data and verify Line of Business will be ticked all - Input Party Type
	 * */
	private void inputPartyType(String partyType){
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Party Type'))
		abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Party Type'), partyType + Keys.chord(Keys.TAB))
	}

	/**
	 * UT-48 - Step05 - Input data and verify Line of Business will be ticked all - Input Party Sub-Type
	 * */
	private void inputPartySubType(String partySubType){
		WebUI.delay(1)
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Party Type'))
		abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Party Sub-Type'), partySubType )
	}

	/**
	 * UT-48 - Step05 - Input data and verify Line of Business will be ticked all - Input Party Category
	 * */
	private void inputPartyCategory(String partyCategory){
		abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Party Category'))
		abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Party Category'), partyCategory )
	}

	/**
	 * UT-48 - Step05 - Input data and verify Line of Business will be ticked all - click Line of Business
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
					abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/chk_SelectAllLineOfBusiness'))
					abtractPage.checkTheCheckbox(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/chk_SelectAllLineOfBusiness'))
				case "Digital Channels":
					for(String personal : listsPersonal){
						//elementChannels = partyOnboardingUI.chk_CorporatePersonal(personal)
						elementChannels = findTestObject('Object Repository/Creating Party Onboarding_temp/PartyOnboarding/LineofBusiness_List',['description':personal])
						abtractPage.waitForElementVisibled(elementChannels)
						abtractPage.checkTheCheckbox(elementChannels)
					}
				case "Core Banking":
					abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/chk_SelectAllLineOfBusiness'))
					abtractPage.uncheckTheCheckbox(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/chk_SelectAllLineOfBusiness'))
					abtractPage.waitForElementVisibled(corebanking)
					abtractPage.checkTheCheckbox(corebanking)
				case "Corporate Channels":
					for(String enterprise : listsEnterprise){
						//elementChannels = partyOnboardingUI.chk_CorporatePersonal(enterprise)
						elementChannels = findTestObject('Object Repository/Creating Party Onboarding_temp/PartyOnboarding/LineofBusiness_List',['description':enterprise])
						abtractPage.waitForElementVisibled(elementChannels)
						abtractPage.checkTheCheckbox(elementChannels)
					}
			}
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step05 - Input data and verify Line of Business will be ticked all - verify Line of Business ticked
	 * */
	private String isLineOfBusinessItemsTicked(){
		List<WebElement> listelements = WebUI.findWebElements(findTestObject('Creating Party Onboarding_temp/PartyOnboarding/Verify/chk_LINEOFBUSINESS'),longTimeout )
		int count = 0
		String values, valueattribute
		try{
			for(WebElement element : listelements){
				valueattribute = element.getAttribute("aria-checked")
				if(valueattribute.equals("true")){
					count +=1}
			}
			if (count == listelements.size()){
				values = "PASSED"
			}
			else{ values = "FAILED"
				WebUI.takeScreenshot()
			}
		}
		catch(Exception e){
			values = "ERROR"
			println (e)
		}
	}



	/**
	 * UT-48 - Step06 - Click Next button and verify the Party Check List
	 * */
	private String isPartyCheckListDisplayed(){
		String str =""
		String  values =""
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/btn_Next'))
			abtractPage.clickToElement(findTestObject('Creating Party Onboarding_temp/btn_Next'))
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/PartyCheckList/lbl_PartyCheckList'))
			abtractPage.highlightElement(findTestObject('Creating Party Onboarding_temp/PartyCheckList/lbl_PartyCheckList'))
			str = abtractPage.getTextElement(findTestObject('Creating Party Onboarding_temp/PartyCheckList/lbl_PartyCheckList'))
			//str = abtractPage.getAllTextInThePage()
			println "str: " + str
			if(abtractPage.isVerifyCharacterInTheString(str, "Party Check List")){
				values = "PASSED"
			}
			else{ values = "FAILED"
			}}
		catch (Exception e){
			values = "ERROR"
			println(e)
		}
		return values
	}

	/**
	 * UT-48 - Step07 - Click Next button and verify the Pre-Existence Check
	 * */
	private String isPreExistenceCheckDisplayed(){
		String str =""
		String  values =""
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/btn_Next'))
			abtractPage.clickToElement(findTestObject('Creating Party Onboarding_temp/btn_Next'))
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/Verify/lbl_PreExistenceCheck'))
			str = abtractPage.getTextElement(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/Verify/lbl_PreExistenceCheck'))

			println "str: " + str
			if(abtractPage.isVerifyCharacterInTheString(str, "Pre-Existence Check")){
				values = "PASSED"
			}
			else{ values = "FAILED"
			}
		}
		catch (Exception e){
			values = "ERROR"
			println(e)
		}
		return values
	}

	/**
	 * UT-48 - Step08 - Input First Name
	 * */
	private void setTextFirstName(String fristName){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/First Name'))
			abtractPage.clickToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/First Name'))
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/First Name 01'))
			abtractPage.sendKeyToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/First Name 01'), fristName)
		}
		catch (Exception e){
			println(e)
		}

	}

	/**
	 * UT-48 - Step08 - Input Last Name
	 * */
	private void setTextLastName(String lastName){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/Last Name'))
			abtractPage.clickToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/Last Name'))
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/Last Name 01'))
			abtractPage.sendKeyToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/Last Name 01'), lastName)
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step08 - Input Date of birth
	 * */
	private void setTextDateBirth(String dateBirth){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/Date of Birth'))
			abtractPage.clickToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/Date of Birth'))
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/Date of Birth 01'))
			abtractPage.sendKeyToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/Pre-Existence Check/Date of Birth 01'), dateBirth)
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step08 - Click Next button
	 * */
	private void clickNextbutton(){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/btn_Next'))
			abtractPage.clickToElement(findTestObject('Creating Party Onboarding_temp/btn_Next'))
		}
		catch(Exception e){
			println (e)
		}
	}
	/**
	 * UT-48 - Step08 - Verify First Name, Last Name and DOB after Pre Exist Check finished
	 * */
	private String changeFormatDate(String strDate, String patternFrom, String patternTo){
		Date date1
		String date2
		try{
			date1 = new SimpleDateFormat(patternFrom).parse(strDate)
			println "date1: " + date1
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternTo)
			date2 = simpleDateFormat.format(date1)
		}
		catch(Exception e){
			println(e)
		}
		return date2
	}
	private String isFirstNameLastNameDOBDisplayed (String verify_firstname, String verify_lastname, String verify_dob){
		String values = ""
		String firstname, lastname, dob, dob1
		try{
			abtractPage.waitForElementPresent(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Verify/FirstName_txt'))
			firstname = abtractPage.getAttributeValue(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Verify/FirstName_txt'), "value")
			abtractPage.waitForElementPresent(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Verify/LastName_txt'))
			lastname = abtractPage.getAttributeValue(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Verify/LastName_txt'), "value")
			abtractPage.waitForElementPresent(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Verify/DOB_txt'))
			dob = abtractPage.getAttributeValue(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Verify/DOB_txt'), "value")
			dob1 = changeFormatDate(verify_dob,"MM-dd-yyyy","yyyy-MM-dd")
			println "dob1: " + dob1
			println "firstname.trim(): "+ firstname.trim() + " verify_firstname.trim(): "+ verify_firstname.trim() + " lastname.trim(): "+ lastname.trim() + " verify_lastname.trim(): "+ verify_lastname.trim() + " dob.trim(): " + dob.trim() + " verify_dob.trim(): " + verify_dob.trim()
			if(firstname.trim().equals(verify_firstname.trim()) && lastname.trim().equals(verify_lastname.trim()) && dob.trim().equals(dob1.trim()) ){
				values = "PASSED"
			}
			else{ values ="FAILED"}
		}
		catch(Exception e){
			values = "ERROR"
			println (e)
		}
	}

	/**
	 * UT-48 - Step09 - Input National Identifier Type
	 * */
	private void inputNationalIdentifierType(String nationalIdentifireType){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/National Identifier Type'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/National Identifier Type'), nationalIdentifireType + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input National Identifier
	 * */
	private void inputNationalIdentifier(String nationalIdentifire){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/National Identifier'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/National Identifier'), nationalIdentifire + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input Title
	 * */
	private void inputTitle(String title){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Title'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Title'), title + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input Employment Status
	 * */
	private void inputEmploymentStatus(String employmentStatus){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Employment Status'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Employment Status'), employmentStatus + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input Gender
	 * */
	private void inputGender(String gender){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Gender'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Gender'), gender + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input Civil Status
	 * */
	private void inputCivilStatus(String civilStatus){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Civil Status'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Civil Status'), civilStatus + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input Mother's Maiden Name
	 * */
	private void inputMotherMaidenName(String motherMaidenName){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Mothers Maiden Name'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Mothers Maiden Name'), motherMaidenName + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input Short Name
	 * */
	private void inputShortName(String shortName){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Short Name'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Short Name'), shortName + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input Grandfather's Name
	 * */
	private void inputGrandfatherName(String grandfatherName){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Grandfathers Name'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Grandfathers Name'), grandfatherName + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input Nationality
	 * */
	private void inputNationality(String nationality){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Nationality'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Nationality'), nationality + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input Resident Status
	 * */
	private void inputResidentStatus(String residentStatus){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Resident Status'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Resident Status'), residentStatus)
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input Resident Status
	 * */
	private void inputTaxIDNumber(String taxIDNumber){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Tax ID Number'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Tax ID Number'), taxIDNumber + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}
	/**
	 * UT-48 - Step09 - Input Religion
	 * */
	private void inputReligion(String religion){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Religion'))
			abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/Religion'), religion + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}
	/**
	 * UT-48 - Step09 - Click Process button on Warning Box
	 */
	private void clickProcessInWarningBox(){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/input_Warnings_Proceed_NotCapture'))
			abtractPage.clickToElement(findTestObject('Creating Party Onboarding_temp/Personal/PersonalParty/input_Warnings_Proceed_NotCapture'))
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * UT-48 - Step10 - Input required fields for Party Address (Address Type, Use of communication and Valid from
	 * */
	private void inputRDataForAddressParty(String addressType, String useOfCommunication, String validFrom){
		String [] listAddresses = abtractPage.splitString(addressType)
		try{
			for (int i = 0; i < listAddresses.length; i++){
				//click New Row
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyAddress/button_New Row_PartyAddress'))
				abtractPage.clickToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/PartyAddress/button_New Row_PartyAddress'))

				//input Address type
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyAddress/Address Type'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyAddress/Address Type'), listAddresses[i].trim() + Keys.chord(Keys.ENTER))
				//input valid from
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyAddress/Valid From'))
				abtractPage.clearText(findTestObject('Creating Party Onboarding_temp/Personal/PartyAddress/Valid From'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyAddress/Valid From'), abtractPage.replaceArrayIndexOutOfBoundsException(validFrom, i,""))
				//tick Use Of Communication
				if (abtractPage.replaceArrayIndexOutOfBoundsException(useOfCommunication, i, "").equals("Yes")){
					abtractPage.waitForElementPresent(findTestObject('Creating Party Onboarding_temp/Personal/PartyAddress/chk_Use  for Communication'))
					abtractPage.checkTheCheckbox(findTestObject('Creating Party Onboarding_temp/Personal/PartyAddress/chk_Use  for Communication'))
				}
				//click Save Row
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyAddress/SaveRow'))
				abtractPage.clickToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/PartyAddress/SaveRow'))

			}
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * UT-48 - Step10 - Input required fields for Party Address - Verify Party Contacts screen
	 * */
	private String isPartyContactsDisplayed(){
		String str =""
		String  values =""
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Verify/lbl_PartyContactsCheck'))
			str = abtractPage.getTextElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Verify/lbl_PartyContactsCheck'))
			println "str: " + str
			if(abtractPage.isVerifyCharacterInTheString(str, "Party Contacts")){
				values = "PASSED"
			}
			else{ values = "FAILED"
			}
		}
		catch (Exception e){
			values = "ERROR"
			println(e)
		}
		return values
	}

	/**
	 * UT-48 - Step11 - Input required fields for Party Contact 
	 * */
	private void inputDataForPartyContacts(String contactMethod, String contactTypeLocation,String contactnumber_code, String contactnumber_areacode, String contactnumber_number, String email, String confirmemail, String validFrom){
		String [] listContactMethod = abtractPage.splitString(contactMethod)
		println "inputDataForPartyContacts: " + listContactMethod.length
		try{
			for (int k = 0; k < listContactMethod.length; k++){
				println "inputDataForPartyContacts [k]" + k
				//click New Row
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/New Row'))
				abtractPage.clickToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/New Row'))

				//input Contact Method
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Method'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Method'), listContactMethod[k].trim() + Keys.chord(Keys.ENTER))
				//input Contact Type Location
				WebUI.delay(1)
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Type  Location'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Type  Location'), abtractPage.replaceArrayIndexOutOfBoundsException(contactTypeLocation, k,""))
				//input Number
				if (WebUI.verifyElementHasAttribute(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Email'), 'readonly', 3, FailureHandling.OPTIONAL))
				{
					//Country Code
					abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Number_03_Code'))
					abtractPage.clearText(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Number_03_Code'))
					abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Number_03_Code'), abtractPage.replaceArrayIndexOutOfBoundsException(contactnumber_code,k,""))
					//Area Code
					abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Number_AreaCode'))
					abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Number_AreaCode'), abtractPage.replaceArrayIndexOutOfBoundsException(contactnumber_areacode,k,""))
					//Number
					abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Number_Number'))
					abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Number_Number'), abtractPage.replaceArrayIndexOutOfBoundsException(contactnumber_number,k,""))
				}
				//Email
				if (WebUI.verifyElementHasAttribute(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Number_03_Code'), 'readonly', 3, FailureHandling.OPTIONAL))
				{
					//Contact Email
					abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Email'))
					abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Contact Email'), abtractPage.replaceArrayIndexOutOfBoundsException(email,k,""))
					//Confirm Email
					abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Confirm Email'))
					abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Confirm Email'), abtractPage.replaceArrayIndexOutOfBoundsException(confirmemail,k,""))
				}

				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Valid From'))
				abtractPage.clearText(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Valid From'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Valid From'), abtractPage.replaceArrayIndexOutOfBoundsException(validFrom,k,""))

				//click Save Row
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Save Row'))
				abtractPage.clickToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/PartyContacts/Save Row'))
			}
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * UT-48 - Step11 ၁ - Input required fields for Party Contacts - Verify Party Required Documents screen
	 * */
	private String isPartyRequiredDocumentsDisplayed(){
		String str =""
		String  values =""
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Verify/lbl_PartyRequiredDocumentsCheck'))
			str = abtractPage.getTextElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Verify/lbl_PartyRequiredDocumentsCheck'))
			println "str: " + str
			if(abtractPage.isVerifyCharacterInTheString(str, "Party - Required Documents")){
				values = "PASSED"
			}
			else{ values = "FAILED"
			}
		}
		catch (Exception e){
			values = "ERROR"
			println(e)
		}
		return values
	}

	/**
	 * UT-48 - Step12 ၁ - Input required fields for Party Required Documents - Input data
	 * */
	private void inputDataForPartyRequiredDocuments(String documentcategory, String kyc_expiry,String documenttype, String validfrom, String validto, String referencenumber, String issuingauthority, String issuingcountry, String documentverified, String image){
		String [] listDocumentCategory = abtractPage.splitString(documentcategory)
		try{
			for (int j = 0; j < listDocumentCategory.length; j++){
				//click New Row
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/New Row'))
				abtractPage.clickToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/New Row'))

				//input Document Category
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/DocumentCategory'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/DocumentCategory'), listDocumentCategory[j].trim() + Keys.chord(Keys.ENTER))
				//input KYC ExpiryDate
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/KYCExpiryDate'))
				WebUI.delay(1)
				abtractPage.clearText(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/KYCExpiryDate'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/KYCExpiryDate'), abtractPage.replaceArrayIndexOutOfBoundsException(kyc_expiry, j,""))
				//Document Type
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Document Type'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Document Type'), abtractPage.replaceArrayIndexOutOfBoundsException(documenttype, j,""))
				//Valid From document
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Valid From_document'))
				abtractPage.clearText(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Valid From_document'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Valid From_document'), abtractPage.replaceArrayIndexOutOfBoundsException(validfrom, j,""))
				//Valid to document
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Valid To_document'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Valid To_document'), abtractPage.replaceArrayIndexOutOfBoundsException(validto, j,""))
				//Reference Number
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/input_Reference Number'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/input_Reference Number'), abtractPage.replaceArrayIndexOutOfBoundsException(referencenumber, j,""))
				//Issuing Authority
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Issuing Authority'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Issuing Authority'), abtractPage.replaceArrayIndexOutOfBoundsException(issuingauthority, j,""))
				//Issuing Country
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Issuing Country'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Issuing Country'), abtractPage.replaceArrayIndexOutOfBoundsException(issuingcountry, j,""))
				//Document Verified
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Document Verified'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Document Verified'), abtractPage.replaceArrayIndexOutOfBoundsException(documentverified, j,""))
				//Image
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Image ID_03'))
				abtractPage.sendkeyToElement(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Image ID_03'), abtractPage.replaceArrayIndexOutOfBoundsException(image, j,""))

				//click Save Row
				abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Save Row'))
				abtractPage.clickToElementByJavascript(findTestObject('Creating Party Onboarding_temp/Personal/PartyRequiredDocument/Save Row'))

			}
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * UT-48 - Step12 - Input required fields for Party Address - Verify Presonal Party confirmation screen
	 * */
	private String isPersonalPartyConfirmationDisplayed(){
		String str =""
		String  values =""
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/Confirmation/lbl_PersonalPartyCheck'))
			str = abtractPage.getTextElement(findTestObject('Creating Party Onboarding_temp/Confirmation/lbl_PersonalPartyCheck'))
			println "str: " + str
			if(abtractPage.isVerifyCharacterInTheString(str, "Personal Party")){
				values = "PASSED"
			}
			else{ values = "FAILED"
			}
		}
		catch (Exception e){
			values = "ERROR"
			println(e)
		}
		return values
	}
	/**
	 * UT-48 - Step12 - Input Party Required Documents - Record PartyID
	 * */
	private void recordPartyId(){
		try{
			String temp = ""
			temp= abtractPage.getAttributeValue(findTestObject('Creating Party Onboarding_temp/Confirmation/PartyID'),"value")
			excelFiles.writeRecordPartyID("PTY001_001_TestData.xlsx", "RecordData","0", temp)
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * UT-48 - Step13 - Click Ask For Approval button
	 * */
	private void clickAskForApprovalbutton(){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Creating Party Onboarding_temp/RequestToApproval/AskForApproval_btn'))
			abtractPage.clickToElement(findTestObject('Creating Party Onboarding_temp/RequestToApproval/AskForApproval_btn'))
			excelFiles.writeRecordPartyID("PTY001_001_TestData.xlsx", "RecordData","1", temp)
		}
		catch(Exception e){
			println (e)
		}
	}


}


