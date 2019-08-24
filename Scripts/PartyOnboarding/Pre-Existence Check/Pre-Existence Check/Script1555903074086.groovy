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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import java.lang.String
import org.openqa.selenium.remote.RemoteWebElement
import org.openqa.selenium.JavascriptExecutor

/*First Name*/
//click 
CustomKeywords.'commons.actions.js_Click'(findTestObject('null'))
//wait
WebUI.waitForElementPresent(findTestObject('null'), 5, FailureHandling.STOP_ON_FAILURE)
//settext
CustomKeywords.'commons.actions.js_sendKey'(findTestObject('null'), firstname)
WebUI.delay(3)

/*Last Name*/
CustomKeywords.'commons.actions.js_Click'(findTestObject('null'))
//wait
WebUI.waitForElementPresent(findTestObject('null'), 5, FailureHandling.STOP_ON_FAILURE)
//settext
CustomKeywords.'commons.actions.js_sendKey'(findTestObject('null'), lastname)
WebUI.delay(3)

/*Date of Birth Name*/
CustomKeywords.'commons.actions.js_Click'(findTestObject('null'))
//wait
WebUI.waitForElementPresent(findTestObject('null'), 5, FailureHandling.STOP_ON_FAILURE)
//settext
CustomKeywords.'commons.actions.js_sendKey'(findTestObject('null'), dateofbirth)
WebUI.delay(3)

/*National Unique Identifier*/
CustomKeywords.'commons.actions.js_Click'(findTestObject('null'))
//wait
WebUI.waitForElementPresent(findTestObject('null'), 5, FailureHandling.STOP_ON_FAILURE)
//settext
CustomKeywords.'commons.actions.js_sendKey'(findTestObject('null'), national_unique)
WebUI.delay(3)

/*Post code Zip code*/
CustomKeywords.'commons.actions.js_Click'(findTestObject('null'))
//wait
WebUI.waitForElementPresent(findTestObject('null'), 5, FailureHandling.STOP_ON_FAILURE)
//settext
CustomKeywords.'commons.actions.js_sendKey'(findTestObject('null'), postcode)
WebUI.delay(3)

/*Tax ID Number*/
CustomKeywords.'commons.actions.js_Click'(findTestObject('null'))
//wait
WebUI.waitForElementPresent(findTestObject('null'), 5, FailureHandling.STOP_ON_FAILURE)
//settext
CustomKeywords.'commons.actions.js_sendKey'(findTestObject('null'), taxid)

WebUI.delay(3)

WebUI.click(findTestObject('PartyOnboarding/btn_Next'), FailureHandling.STOP_ON_FAILURE)
