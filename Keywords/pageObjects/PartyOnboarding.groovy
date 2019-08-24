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
import commons.AbtractPage as AbtractPage
import commons.AbtractTest as AbtractTest
import report.ExcelFiles as ExcelFiles
import java.text.SimpleDateFormat
import java.util.Date

public class PartyOnboarding{
	private static int longTimeout =30;
	private static int shortTimeout =5;
	private static FailureHandling failureHandling = FailureHandling.OPTIONAL
	private static WebDriver driver = DriverFactory.getWebDriver()
	AbtractTest abtractTest = new AbtractTest()
	AbtractPage abtractPage = new AbtractPage()
	ExcelFiles excelFiles = new ExcelFiles()


	/**
	 * UT-48 Step01 - Verify Default Values is displayed
	 */

	private void inputPartyOnboardingMenuSearch(){
		try{
			abtractPage.inputOpenScreenMenuSearch("Party Onboarding", findTestObject('Object Repository/Menu_Search'))
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}

	private String isDefaultValuesDisplayed(String verifyLocalGlobal, String verifyLocation, String verifyAssgnedBranch){
		String values = ""
		String local = ""
		abtractPage.waitForElementPresent(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'))
		local = WebUI.getAttribute(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'),"value").toString()
		values =  abtractPage.verifyEqualsString(local, verifyLocalGlobal)
		abtractPage.waitForElementPresent(findTestObject('PartyOnboarding/PartyOnboarding/lbl_Entity'))
		values +=  abtractPage.verifyEqualsString(abtractPage.getAttributeValue(findTestObject('PartyOnboarding/PartyOnboarding/lbl_Entity'),"value"), verifyLocation)
		abtractPage.waitForElementPresent(findTestObject('PartyOnboarding/PartyOnboarding/Assigned Branch txt'))
		values +=  abtractPage.verifyEqualsString(abtractPage.getAttributeValue(findTestObject('PartyOnboarding/PartyOnboarding/Assigned Branch txt'),"value"), verifyAssgnedBranch)

		values = abtractTest.getFinalResults(values)
		return values
	}
	/**
	 * UT-48 - Step02 - Click Location dropdownlist to show all items
	 * */
	private void clickLocationDropdownlist(){
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/input_Local Global'))
		abtractPage.clickToElement(findTestObject('PartyOnboarding/PartyOnboarding/input_Local Global'))
	}
	/**
	 * UT-48 - Step02 - Showing the lists of locations Local Public, Global, Local Private
	 * */
	private String isShowingCorrectlyTheListOfLocations(String items){
		String values = ""
		int k = 0
		String[] listitems = abtractPage.splitString(items)
		try {
			List<WebElement> elements = WebUI.findWebElements(findTestObject('PartyOnboarding/PartyOnboarding/div_Global'),longTimeout )
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
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Assigned Branch search'))
		abtractPage.clickToElement(findTestObject('PartyOnboarding/PartyOnboarding/Assigned Branch search'))
	}
	/**
	 * UT-48 - Step03 - Check correctly the list of Branches - Verify the list branch is correct
	 * */
	private String isDisplayedTheListBranchesCorrectly(String branchList){
		String values = ""
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Assigned Branch search'))
		abtractPage.clickToElement(findTestObject('PartyOnboarding/PartyOnboarding/Assigned Branch search'))
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Form_BranchList'))
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Verify/btn_SearchBranchList'))
		abtractPage.clickToElement(findTestObject('PartyOnboarding/PartyOnboarding/Verify/btn_SearchBranchList'))
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Data_listBranchs'))
		values = abtractPage.isverifyDropDownList(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Data_listBranchs'), abtractPage.splitString(branchList))
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Verify/btn_CloseBranchListForm'))
		abtractPage.clickToElement(findTestObject('PartyOnboarding/PartyOnboarding/Verify/btn_CloseBranchListForm'))
		return values
	}
	/**
	 * UT-48 - Step04 - Verify the require fields are blank - Click Next button
	 * */
	private String isCheckRequiredFieldsByNextButton(){
		String valuebf, valueaf, values
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Step04/errorMessage_mandatoryFields'))
		valuebf = abtractPage.getAttributeValue(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Step04/errorMessage_mandatoryFields'), "class")
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
		//abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
		WebUI.click(findTestObject('PartyOnboarding/btn_Next'))
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Step04/errorMessage_mandatoryFields'))
		valueaf = abtractPage.getAttributeValue(findTestObject('PartyOnboarding/PartyOnboarding/Verify/Step04/errorMessage_mandatoryFields'), "class")
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
		abtractPage.clearText(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'))
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'))
		abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Local Global'), localGlobal)
	}

	/**
	 * UT-48 - Step05 - Input data and verify Line of Business will be ticked all - Input Party Type
	 * */
	private void inputPartyType(String partyType){
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'))
		abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'), partyType + Keys.chord(Keys.TAB))
	}

	/**
	 * UT-48 - Step05 - Input data and verify Line of Business will be ticked all - Input Party Sub-Type
	 * */
	private void inputPartySubType(String partySubType){
		WebUI.delay(1)
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Party Type'))
		abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Sub-Type'), partySubType )
	}

	/**
	 * UT-48 - Step05 - Input data and verify Line of Business will be ticked all - Input Party Category
	 * */
	private void inputPartyCategory(String partyCategory){
		abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyOnboarding/Party Category'))
		abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/PartyOnboarding/Party Category'), partyCategory )
	}

	/**
	 * UT-48 - Step05 - Input data and verify Line of Business will be ticked all - click Line of Business
	 * */
	private void clickLineofBusiness(String lineofbusiness, TestObject corebanking){
		try{
			String val = lineofbusiness.trim()
			String [] listsPersonal = ["Corporate Channels", "Digital Channels"]
			String [] listsEnterprise = ["Corporate Channels"]
			String
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

	/**
	 * UT-48 - Step05 - Input data and verify Line of Business will be ticked all - verify Line of Business ticked
	 * */
	private String isLineOfBusinessItemsTicked(){
		List<WebElement> listelements = WebUI.findWebElements(findTestObject('PartyOnboarding/PartyOnboarding/Verify/chk_LINEOFBUSINESS'),longTimeout )
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
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
			abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/PartyCheckList/lbl_PartyCheckList'))
			abtractPage.highlightElement(findTestObject('PartyOnboarding/PartyCheckList/lbl_PartyCheckList'))
			str = abtractPage.getTextElement(findTestObject('PartyOnboarding/PartyCheckList/lbl_PartyCheckList'))
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
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
			abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/Verify/lbl_PreExistenceCheck'))
			str = abtractPage.getTextElement(findTestObject('PartyOnboarding/Personal/Pre-Existence Check/Verify/lbl_PreExistenceCheck'))

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
	 * UT-48 - Step08 - Input Pre-ExistenceCheck
	 * */
	private void inputPreExistenceCheck(String firstName, String dateOfBrith, String nationalldType, String nationalldNo, String lastName, String strState, String district01, String district02, String district03, String strType, String strregstrationNo){
		try{
			WebUI.delay(2)
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/txt_FirstName'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/txt_FirstName'), firstName )
			WebUI.delay(2)
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/txt_LastName'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/txt_LastName'), lastName )
			WebUI.delay(2)
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/txt_DateOfBirth'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/txt_DateOfBirth'), dateOfBrith )
			WebUI.delay(2)
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/ddl_NationlldType'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/ddl_NationlldType'), nationalldType  + Keys.chord(Keys.TAB))
			WebUI.delay(2)
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/txt_NationalldNo'))
			WebUI.delay(2)
			if(nationalldType.trim().equals('NRC')){
				abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/ddl_State'))
				abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/ddl_State'), strState )
				abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/ddl_District01'))
				abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/ddl_District01'), district01 )
				abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/ddl_District02'))
				abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/ddl_District02'), district02 )
				abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/ddl_District03'))
				abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/ddl_District03'), district03 )
				abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/ddl_Type'))
				abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/ddl_Type'), strType )
				abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/txt_RegstrationNo'))
				abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/NRC_fields/txt_RegstrationNo'), strregstrationNo )
			}
			else{
				WebUI.delay(2)
				abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/Pre-Existence Check/txt_NationalldNo'), nationalldNo )
			}

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
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
			abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
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
			abtractPage.waitForElementPresent(findTestObject('PartyOnboarding/Personal/PersonalParty/Verify/txt_FirstName'))
			firstname = abtractPage.getAttributeValue(findTestObject('PartyOnboarding/Personal/PersonalParty/Verify/txt_FirstName'), "value")
			abtractPage.waitForElementPresent(findTestObject('PartyOnboarding/Personal/PersonalParty/Verify/txt_LastName'))
			lastname = abtractPage.getAttributeValue(findTestObject('PartyOnboarding/Personal/PersonalParty/Verify/txt_LastName'), "value")
			abtractPage.waitForElementPresent(findTestObject('PartyOnboarding/Personal/PersonalParty/Verify/txt_DOB'))
			dob = abtractPage.getAttributeValue(findTestObject('PartyOnboarding/Personal/PersonalParty/Verify/txt_DOB'), "value")
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

	private void inputPartyId(){
		try{
			int k = 8
			String partyId = abtractPage.getAlphaNumericString(k)
			//println "partyId: "+ partyId
			if(WebUI.waitForElementVisible(findTestObject('Object Repository/PartyOnboarding/Personal/PersonalParty/txt_PartyID'), shortTimeout, FailureHandling.OPTIONAL)){
				//abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Personal/PersonalParty/txt_PartyID'))
				abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Personal/PersonalParty/txt_PartyID'), partyId + Keys.chord(Keys.TAB))
				if(WebUI.waitForElementVisible(findTestObject('Object Repository/PartyOnboarding/Personal/PersonalParty/Message/pop_ErrorDuplicatePartyID'), shortTimeout, FailureHandling.OPTIONAL)){
					String lbl_message = abtractPage.getAttributeValue(findTestObject('Object Repository/PartyOnboarding/Personal/PersonalParty/Message/pop_ErrorDuplicatePartyID'),"value")
					if(lbl_message.contains("Party ID Already Exist")){
						inputPartyId()
					}
				}
			}

		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * UT-48 - Step09 - Input National Identifier Type
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
	 * UT-48 - Step09 - Input National Identifier
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
	 * UT-48 - Step09 - Input Title
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
	 * UT-48 - Step09 - Input Employment Status
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
	 * UT-48 - Step09 - Input Gender
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
	 * UT-48 - Step09 - Input Civil Status
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
	 * UT-48 - Step09 - Input Mother's Maiden Name
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
	 * UT-48 - Step09 - Input Short Name
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
	 * UT-48 - Step09 - Input Grandfather's Name
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
	 * UT-48 - Step09 - Input Nationality
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
	 * UT-48 - Step09 - Input Resident Status
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
	 * UT-48 - Step09 - Input Resident Status
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
	 * UT-48 - Step09 - Input Religion
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
	/**
	 * UT-48 - Step09 - Click Process button on Warning Box
	 */
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
	 * UT-48 - Step10 - Input required fields for Party Address (Address Type, Use of communication and Valid from
	 * */
	private void inputRDataForAddressParty(String addressType, String useOfCommunication, String validFrom){
		String [] listAddresses = abtractPage.splitString(addressType)
		try{
			for (int i = 0; i < listAddresses.length; i++){
				//click New Row
				WebUI.delay(2)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyAddress/button_New Row_PartyAddress'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyAddress/button_New Row_PartyAddress'))
				WebUI.delay(2)
				//input Address type
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyAddress/Address Type'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyAddress/Address Type'), listAddresses[i].trim() + Keys.chord(Keys.TAB))
				//input valid from
				WebUI.delay(2)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyAddress/Valid From'))
				abtractPage.clearText(findTestObject('PartyOnboarding/Personal/PartyAddress/Valid From'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyAddress/Valid From'), abtractPage.replaceArrayIndexOutOfBoundsException(validFrom, i,""))
				WebUI.delay(2)
				//tick Use Of Communication
				if (abtractPage.replaceArrayIndexOutOfBoundsException(useOfCommunication, i, "").equals("Yes")){
					WebUI.delay(2)
					abtractPage.waitForElementPresent(findTestObject('PartyOnboarding/Personal/PartyAddress/chk_Use  for Communication'))
					abtractPage.checkTheCheckbox(findTestObject('PartyOnboarding/Personal/PartyAddress/chk_Use  for Communication'))
				}
				//click Save Row
				WebUI.delay(2)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyAddress/SaveRow'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyAddress/SaveRow'))

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
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Verify/lbl_PartyContactsCheck'))
			str = abtractPage.getTextElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Verify/lbl_PartyContactsCheck'))
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
				//WebUI.delay(n)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/New Row'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyContacts/New Row'))
				WebUI.delay(1)
				//input Contact Method
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Method'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Method'), listContactMethod[k].trim() + Keys.chord(Keys.TAB))
				//input Contact Type Location
				WebUI.delay(1)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Type  Location'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Type  Location'), abtractPage.replaceArrayIndexOutOfBoundsException(contactTypeLocation, k,"") + Keys.chord(Keys.TAB))
				//input Number
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Email'))
				if (WebUI.verifyElementHasAttribute(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Email'), 'readonly', 3, FailureHandling.OPTIONAL))
				{
					//Country Code
					//WebUI.delay(n)
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'))
					abtractPage.clearText(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'))
					abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'), abtractPage.replaceArrayIndexOutOfBoundsException(contactnumber_code,k,""))
					//Area Code
					//WebUI.delay(n)
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_AreaCode'))
					abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_AreaCode'), abtractPage.replaceArrayIndexOutOfBoundsException(contactnumber_areacode,k,""))
					//Number
					//WebUI.delay(n)
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_Number'))
					abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_Number'), abtractPage.replaceArrayIndexOutOfBoundsException(contactnumber_number,k,""))
				}
				//Email
				//WebUI.delay(n)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'))
				if (WebUI.verifyElementHasAttribute(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'), 'readonly', 3, FailureHandling.OPTIONAL))
				{
					//Contact Email
					//WebUI.delay(n)
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Email'))
					abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Email'), abtractPage.replaceArrayIndexOutOfBoundsException(email,k,""))
					//Confirm Email
					//WebUI.delay(n)
					abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Confirm Email'))
					abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Confirm Email'), abtractPage.replaceArrayIndexOutOfBoundsException(confirmemail,k,""))
				}
				//WebUI.delay(n)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Valid From'))
				abtractPage.clearText(findTestObject('PartyOnboarding/Personal/PartyContacts/Valid From'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Valid From'), abtractPage.replaceArrayIndexOutOfBoundsException(validFrom,k,""))

				//click Save Row
				//WebUI.delay(n)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyContacts/Save Row'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyContacts/Save Row'))
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
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Verify/lbl_PartyRequiredDocumentsCheck'))
			str = abtractPage.getTextElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Verify/lbl_PartyRequiredDocumentsCheck'))
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
	 * UT-48 - Step13 ၁ - Input required fields for Party Required Documents - Input data
	 * */
	private void inputDataForPartyRequiredDocuments(String documentcategory, String kyc_expiry,String documenttype, String validfrom, String validto, String referencenumber, String issuingauthority, String issuingcountry, String documentverified, String image, String documentStatus){
		WebUI.delay(1)
		String [] listDocumentCategory = abtractPage.splitString(documentcategory)
		try{
			for (int j = 0; j < listDocumentCategory.length; j++){
				//click New Row
				//WebUI.delay(n)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/New Row'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/New Row'))

				//input Document Category
				//WebUI.delay(n)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/DocumentCategory'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/DocumentCategory'), listDocumentCategory[j].trim() + Keys.chord(Keys.TAB))
				//input KYC ExpiryDate
				/*abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/KYCExpiryDate'))
				 WebUI.delay(1)
				 abtractPage.clearText(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/KYCExpiryDate'))
				 abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/KYCExpiryDate'), abtractPage.replaceArrayIndexOutOfBoundsException(kyc_expiry, j,""))*/
				//Document Type
				WebUI.delay(1)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Document Type'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Document Type'), abtractPage.replaceArrayIndexOutOfBoundsException(documenttype, j,"")+ Keys.chord(Keys.TAB))
				/*
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
				 */
				//Issuing Country
				WebUI.delay(1)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Issuing Country'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Issuing Country'), abtractPage.replaceArrayIndexOutOfBoundsException(issuingcountry, j,"")+ Keys.chord(Keys.TAB))
				//Document Verified
				WebUI.delay(1)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Document Verified'))
				abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Document Verified'), abtractPage.replaceArrayIndexOutOfBoundsException(documentverified.toUpperCase(), j,"") +Keys.chord(Keys.TAB))
				//Image
				/*abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Image ID_03'))
				 abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Image ID_03'), abtractPage.replaceArrayIndexOutOfBoundsException(image, j,""))*/

				//click Save Row
				WebUI.delay(2)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Save Row'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Save Row'))

			}
			WebUI.delay(2)
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/ddl_DocumentsCollectionStatus'))
			abtractPage.sendkeyToElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/ddl_DocumentsCollectionStatus'), documentStatus)
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * UT-48 - Step13 - Input required fields for Party Address - Verify Presonal Party confirmation screen
	 * */
	private String isPersonalPartyConfirmationDisplayed(){
		String str =""
		String  values =""
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/Confirmation/lbl_PersonalPartyCheck'))
			str = abtractPage.getTextElement(findTestObject('PartyOnboarding/Confirmation/lbl_PersonalPartyCheck'))
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
			temp= abtractPage.getAttributeValue(findTestObject('PartyOnboarding/Confirmation/PartyID'),"value")
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
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/RequestToApproval/AskForApproval_btn'))
			abtractPage.clickToElement(findTestObject('PartyOnboarding/RequestToApproval/AskForApproval_btn'))
			excelFiles.writeRecordPartyID("PTY001_001_TestData.xlsx", "RecordData","1", temp)
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * -------------------------Enterprise --------------------------------*/

	private void inputEnterpriseName(String strEnterpriseName){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Enterprise/PreExistenceCheck/txt_EnterpriseName'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Enterprise/PreExistenceCheck/txt_EnterpriseName'),strEnterpriseName)
		}
		catch(Exception e){
			println(e)
		}
	}

	private void inputRegistration(){
		try{
			String registrationNo = abtractPage.getAlphaNumericString(8)
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/PartyOnboarding/Enterprise/PreExistenceCheck/txt_Registration'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/PartyOnboarding/Enterprise/PreExistenceCheck/txt_Registration'), registrationNo)
		}
		catch(Exception e){
			println(e)
		}
	}

	private void inputRegisteredNumber(String registeredNumber){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/QuickPartyOnboarding_Personal/Enterprise/Registered Number_txt'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/QuickPartyOnboarding_Personal/Enterprise/Registered Number_txt'), registeredNumber + Keys.chord(Keys.TAB))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Input Short Name
	 * using same function with Party Onboarding
	 * */
	private void inputShortNameEnterprise(String shortName){
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

}


