package interfaces
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
import java.util.StringTokenizer
import commons.AbtractPage as AbtractPage

public class JiraHomePageUI extends AbtractPage{

	private TestObject getElementForStepStatus(String numbers, String results){
		String xpath = "//div[@class='sc-dVhcbM kVmEMS' and text() ='" + numbers + "']/following-sibling::div[contains(@class,'sc-eNQAEJ')]/div/div/div[@class='sc-htoDjs loJjpb']"
		try{
			println results
			switch (results.trim()){
				case "PASSED":
					xpath += "/div/div/div[@class='sc-gZMcBi bwtLwg']"
					break;
				case "FAILED":
					xpath += "/div/div/div[@class='sc-gZMcBi hyMoTB']"
					break;
				case "TODO":
					xpath += "/div/div/div[@class='sc-gZMcBi jCUVub']"
					break;
				case "INPROCESS":
					xpath += "/div/div/div[@class='sc-gZMcBi XzoCE']"
					break;
			}
			println "xpath: " + xpath
			TestObject to = new TestObject("btn_StepStatus")
			to.addProperty("xpath", ConditionType.EQUALS, xpath)
			return to
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}
}