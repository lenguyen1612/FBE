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
import commons.AbtractPage as AbtractPage



public class JiraLoginPage extends AbtractPage  {

	KeywordUtil logfile = new KeywordUtil()

	private String verifyLoginPage(){
		String values = ""
		try{
			waitForElementVisibled(findTestObject('Object Repository/JIRA/LoginPage/Login Page/LOGOJIRA_IMG'))
			if(isControlVisibled(findTestObject('Object Repository/JIRA/LoginPage/Login Page/LOGOJIRA_IMG'))){
				values = "PASSED"
			}
			else values = "FAILED"
		}
		catch(Exception e){
			values = "ERROR"
			WebUI.takeScreenshot()
			WebUI.takeScreenshot('Reports/Demo.png')
			println(e)
		}
		return values
	}

	private void inputUsername(String username){
		try{
			waitForElementVisibled(findTestObject('Object Repository/JIRA/LoginPage/Login Page/USERNAME_TXT'))
			sendkeyToElement(findTestObject('Object Repository/JIRA/LoginPage/Login Page/USERNAME_TXT'),username)
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}

	private void inputPassword(String password){
		try{
			waitForElementVisibled(findTestObject('Object Repository/JIRA/LoginPage/Login Page/PASSWORD_TXT'))
			sendkeyToElement(findTestObject('Object Repository/JIRA/LoginPage/Login Page/PASSWORD_TXT'),password)
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}

	private void clickLoginBtn(){
		try{
			waitForElementVisibled(findTestObject('Object Repository/JIRA/LoginPage/Login Page/LOGIN_BTN'))
			clickToElement(findTestObject('Object Repository/JIRA/LoginPage/Login Page/LOGIN_BTN'))
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}
}