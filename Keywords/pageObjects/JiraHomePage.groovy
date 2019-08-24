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
import org.openqa.selenium.Keys
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import commons.AbtractPage as AbtractPage
import interfaces.JiraHomePageUI as JiraHomePageUI


public class JiraHomePage {

	AbtractPage abtractPage = new AbtractPage()
	JiraHomePageUI jiraHomePageUI = new JiraHomePageUI()
	private void findTestCase(String TestCaseID){
		abtractPage.waitForElementVisibled(findTestObject('Object Repository/JIRA/HomePage/QUICKSEARCH_TXT'))
		abtractPage.sendkeyToElement(findTestObject('Object Repository/JIRA/HomePage/QUICKSEARCH_TXT'), TestCaseID + Keys.chord(Keys.ENTER))
	}

	private void clickStatusInSteps(String testCaseID, String results){
	}

	private void uploadTestResults(String results){
		String[][] row_results = abtractPage.getStepAndResultsFromString(results)
		int numberSteps = row_results.size()
		String stepnumber, stepresult
		TestObject to
		for(int i = 0; i< numberSteps; i++){
			for(int j = 0; j< row_results[i].size(); j++){
				println row_results[i][j].trim()
				if(j/2==0){
					stepnumber  = row_results[i][j]
				} else {
					stepresult =  row_results[i][j]
				}
			}
			println "stepnumber: " + stepnumber + " stepresult: " +stepresult
			to = jiraHomePageUI.getElementForStepStatus(stepnumber.trim(), stepresult.trim())
			abtractPage.clickToElementByJavascript(to)
			stepnumber=""
			stepresult = ""
		}
	}
}