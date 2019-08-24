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
import commons.AbtractPage as AbtractPage

public class LoginPage {

	AbtractPage abtractPage = new AbtractPage()

	private void openBrowser(String url, String active){
		if(active.trim().equals("Yes")){
			WebUI.openBrowser(url)
			WebUI.maximizeWindow()
		}
	}
	private void inputUsername(String username, String active){
		if(active.trim().equals("Yes")){
			abtractPage.waitForElementPresent(findTestObject('LogIn/input_Username_user'))
			abtractPage.sendkeyToElement(findTestObject('LogIn/input_Username_user'), username)
		}
	}

	private void inputPassword(String password, String active){
		if(active.trim().equals("Yes")){
			abtractPage.waitForElementPresent(findTestObject('LogIn/input_Password_pwd'))
			abtractPage.sendkeyToElement(findTestObject('LogIn/input_Password_pwd'), password)
		}
	}

	private void clickSingin(String active){
		if(active.trim().equals("Yes")){
			abtractPage.waitForElementPresent(findTestObject('LogIn/input_Password_login'))
			abtractPage.clickToElement(findTestObject('LogIn/input_Password_login'))
		}
	}
	
	private void waitLoadPage(String active){
		if(active.trim().equals("Yes")){
			WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)
		}
	}
}
