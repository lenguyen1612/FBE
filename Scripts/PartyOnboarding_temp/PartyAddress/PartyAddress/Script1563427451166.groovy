import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass as CustomKeywordDelegatingMetaClass
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

//declare the element for New Row and Save Row
WebElement e_newrow = WebUiCommonHelper.findWebElement(findTestObject('PartyOnboarding/Personal/PartyAddress/button_New Row_PartyAddress'), 
    5)

WebElement e_saverow = WebUiCommonHelper.findWebElement(findTestObject('PartyOnboarding/Personal/PartyAddress/SaveRow'), 
    5)

String[] ar_addresstype = CustomKeywords.'commons.actions.splitString'(addresstype)

String[] ar_validfrom = CustomKeywords.'commons.actions.splitString'(validfrom)

String[] ar_validto = CustomKeywords.'commons.actions.splitString'(validto)

String[] ar_location = CustomKeywords.'commons.actions.splitString'(location)

String[] ar_postcode = CustomKeywords.'commons.actions.splitString'(postcode)

String[] ar_addressstatus = CustomKeywords.'commons.actions.splitString'(addressstatus)

String[] ar_stateofprovince = CustomKeywords.'commons.actions.splitString'(stateorprovince)

String[] ar_townorcity = CustomKeywords.'commons.actions.splitString'(townorcity)

String[] ar_address1 = CustomKeywords.'commons.actions.splitString'(addressline1)

String[] ar_address2 = CustomKeywords.'commons.actions.splitString'(addressline2)

String[] ar_address3 = CustomKeywords.'commons.actions.splitString'(addressline3)

String[] ar_address4 = CustomKeywords.'commons.actions.splitString'(addressline4)

String[] ar_address5 = CustomKeywords.'commons.actions.splitString'(addressline5)

String[] ar_userforcommunication = CustomKeywords.'commons.actions.splitString'(userforcommunicatrion)

try {
    for (int i = 0; i < ar_addresstype.length; i++) {
        //New Row
        WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(e_newrow))

        //input data
        WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyAddress/Address Type'), CustomKeywords.'commons.actions.checkvariable_sendkey'(addresstype, i,'') + Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

        WebUI.delay(3)

        WebUI.clearText(findTestObject('PartyOnboarding/Personal/PartyAddress/Valid From'), FailureHandling.STOP_ON_FAILURE)

        WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyAddress/Valid From'), CustomKeywords.'commons.actions.checkvariable_sendkey'(validfrom, i,''), FailureHandling.STOP_ON_FAILURE)

        println('usercommunication: ' + (ar_userforcommunication[i]))

        if (ar_userforcommunication[i].trim() == 'Yes') {
            WebUI.click(findTestObject('PartyOnboarding/Personal/PartyAddress/chk_Use  for Communication'), 
                FailureHandling.STOP_ON_FAILURE)
        }
        
        WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(e_saverow))
    }
    
    WebUI.click(findTestObject('PartyOnboarding/btn_Next'), FailureHandling.STOP_ON_FAILURE)
}
catch (def e) {
}