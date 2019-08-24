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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.Keys as Keys


WebElement e_newrow = WebUiCommonHelper.findWebElement(findTestObject('PartyOnboarding/Personal/PartyContacts/New Row'), 5)
WebElement e_saverow = WebUiCommonHelper.findWebElement(findTestObject('PartyOnboarding/Personal/PartyContacts/Save Row'), 5)

String[] ar_contactmethod = CustomKeywords.'commons.actions.splitString'(contactmethod)

println "count: "+ ar_contactmethod.length
for(int i = 0 ; i< ar_contactmethod.length ; i++ )
{
	WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(e_newrow))
	WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Method'), CustomKeywords.'commons.actions.checkvariable_sendkey'(contactmethod, i,'') + Keys.chord( Keys.ENTER ), FailureHandling.STOP_ON_FAILURE)
	//delay to load the element and data
	WebUI.delay(3)
	WebUI. sendKeys(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Type  Location'),  CustomKeywords.'commons.actions.checkvariable_sendkey'(contacttypelocation, i,''), FailureHandling.STOP_ON_FAILURE)
	
	//Number
	if (!WebUI.verifyElementHasAttribute(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'), 'readonly', 3, FailureHandling.OPTIONAL))
	{
		WebUI.clearText(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_03_Code'), CustomKeywords.'commons.actions.checkvariable_sendkey'(contactnumber_code, i,''), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_AreaCode'),  CustomKeywords.'commons.actions.checkvariable_sendkey'(contactnumber_areacode, i,''), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Number_Number'),  CustomKeywords.'commons.actions.checkvariable_sendkey'(contactnumber_number, i,''), FailureHandling.STOP_ON_FAILURE)
	}
	//Email	
	if (!WebUI.verifyElementHasAttribute(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Email'), 'readonly', 3, FailureHandling.OPTIONAL))
	{
		WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyContacts/Contact Email'),  CustomKeywords.'commons.actions.checkvariable_sendkey'(email, i,''), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyContacts/Confirm Email'),  CustomKeywords.'commons.actions.checkvariable_sendkey'(confirmemail, i,''), FailureHandling.STOP_ON_FAILURE)
	} 
	
	WebUI.clearText(findTestObject('PartyOnboarding/Personal/PartyContacts/Valid From'), FailureHandling.STOP_ON_FAILURE)
	WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyContacts/Valid From'),  CustomKeywords.'commons.actions.checkvariable_sendkey'(validfrom, i,''), FailureHandling.STOP_ON_FAILURE)
	WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyContacts/Valid To'),CustomKeywords.'commons.actions.checkvariable_sendkey'(validto, i,''), FailureHandling.STOP_ON_FAILURE)
	
	//Save Row
	WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(e_saverow))
}

WebUI.click(findTestObject('PartyOnboarding/btn_Next'), FailureHandling.STOP_ON_FAILURE)