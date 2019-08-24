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

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable
import commons.AbtractPage as AbtractPage
import commons.AbtractTest as AbtractTest
import report.ExcelFiles as ExcelFiles
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import interfaces.OpenAccountCASAUI as OpenAccountCASAUI

public class OpenAccountCASA {
	private static int longTimeout =30;
	private static FailureHandling failureHandling = FailureHandling.OPTIONAL
	private static WebDriver driver = DriverFactory.getWebDriver()
	AbtractTest abtractTest = new AbtractTest()
	AbtractPage abtractPage = new AbtractPage()
	ExcelFiles excelFiles = new ExcelFiles()
	OpenAccountCASAUI openAccountCASAUI = new OpenAccountCASAUI()

	private void inputOpenAccountMenuSearch(){
		try{
			WebUI.delay(1)
			abtractPage.inputOpenScreenMenuSearch("Open Account", findTestObject('Object Repository/Menu_Search'))
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}

	private void inputCustomer(String customer){
		try{
			abtractPage.waitForElementPresent(findTestObject('Object Repository/OpenAccountCASA/Customer_txt'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenAccountCASA/Customer_txt'), customer + Keys.chord(Keys.TAB))
		}
		catch(Exception e){
			println(e)
		}
	}

	private void clickJointAccount(String jointAccount){
		List<WebElement> listelements
		try{
			if(jointAccount.trim().equals("Yes")){
				abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenAccountCASA/Joint Account_chk'))
				abtractPage.checkTheCheckbox(findTestObject('Object Repository/OpenAccountCASA/Joint Account_chk'))
				//get the list customer relationship
				listelements =WebUI.findWebElements(findTestObject('Object Repository/OpenAccountCASA/JointAccount_ListCustRelationaship/ListCustRelationship_list'),longTimeout)
				//the list customers must be greater 2
				if(listelements.size()>1){
					for(WebElement element: listelements){
						abtractPage.clickElementBySelenium(element)
					}
				}else{
					abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenAccountCASA/Joint Account_chk'))
					abtractPage.uncheckTheCheckbox(findTestObject('Object Repository/OpenAccountCASA/Joint Account_chk'))
				}
			}
		}
		catch(Exception e){
			println(e)
		}
	}

	private void inputSubProduct(String subProduct){
		try{
			WebUI.delay(1)
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenAccountCASA/Sub Product_ddl'))
			abtractPage.clickToElement(findTestObject('Object Repository/OpenAccountCASA/Sub Product_ddl'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenAccountCASA/Sub Product_ddl'), subProduct +  Keys.chord(Keys.TAB))
		}
		catch(Exception e){
			println(e)
		}
	}

	private void inputCurrency(String currency){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenAccountCASA/Currency_Account_ddl'))
			abtractPage.clickToElement(findTestObject('Object Repository/OpenAccountCASA/Currency_Account_ddl'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenAccountCASA/Currency_Account_ddl'), currency + Keys.chord(Keys.TAB))
		}
		catch(Exception e){
			println(e)
		}
	}

	private void clickProduct(String productID){
		try{
			//scrolldown dropdownlist to show all items
			abtractPage.scrollDownDropDownList(findTestObject('Object Repository/OpenAccountCASA/productList_lst'))
			//wait to element visible
			//TestObject to = openAccountCASAUI.product_rdo(productID)
			TestObject to = findTestObject('Object Repository/OpenAccountCASA/productList_lst',['productID':productID])
			abtractPage.waitForElementVisibled(to)
			abtractPage.clickToElement(to)
		}
		catch(Exception e){
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

	private void inputPassbook(String password){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenAccountCASA/PassbookUDF_txt'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenAccountCASA/PassbookUDF_txt'), password)
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputLimitIndicator(String limitIndicator){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenAccountCASA/LimitIndicator_ddl'))
			abtractPage.clearText(findTestObject('Object Repository/OpenAccountCASA/LimitIndicator_ddl'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenAccountCASA/LimitIndicator_ddl'),limitIndicator)
		}
		catch(Exception e){
			println (e)
		}
	}

	private void clickAskToApprove(){
		try{
			if(WebUI.waitForElementVisible(findTestObject('Object Repository/OpenAccountCASA/Waringscreen_popup'), 5, FailureHandling.OPTIONAL)){
				abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenAccountCASA/ProcessWarning_btn'))
				abtractPage.clickToElement(findTestObject('Object Repository/OpenAccountCASA/ProcessWarning_btn'))
			}
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenAccountCASA/AskForApproval_btn'))
			abtractPage.clickToElement(findTestObject('Object Repository/OpenAccountCASA/AskForApproval_btn'))
		}
		catch(Exception e){
			println (e)
		}
	}

	private void isCustomerIDDisplayed(){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenAccountCASA/AccountMandateDetails/CustomerID_txt'))
		}
		catch(Exception e){
			println (e)
		}
	}
}
