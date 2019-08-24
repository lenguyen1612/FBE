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

WebElement e_newrow = WebUiCommonHelper.findWebElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/New Row'), 
    5)

WebElement e_saverow = WebUiCommonHelper.findWebElement(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Save Row'), 
    5)

String[] ar_documentcategory = CustomKeywords.'commons.actions.splitString'(documentcategory)

for (int i = 0; i < ar_documentcategory.length; i++) {
    WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(e_newrow))
	
	WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/DocumentCategory'), CustomKeywords.'commons.actions.checkvariable_sendkey'(documentcategory, i,'') + Keys.chord( Keys.ENTER ), FailureHandling.STOP_ON_FAILURE)
    WebUI.delay(3)

    WebUI.clearText(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/KYCExpiryDate'), FailureHandling.STOP_ON_FAILURE)
    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/KYCExpiryDate'), CustomKeywords.'commons.actions.checkvariable_sendkey'(kyc_expiry, i,''), FailureHandling.STOP_ON_FAILURE)
    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Document Type'), CustomKeywords.'commons.actions.checkvariable_sendkey'(documenttype, i,''), FailureHandling.STOP_ON_FAILURE)

    WebUI.clearText(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Valid From_document'), FailureHandling.STOP_ON_FAILURE)
    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Valid From_document'), CustomKeywords.'commons.actions.checkvariable_sendkey'(validfrom, i,''), FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Valid To_document'), CustomKeywords.'commons.actions.checkvariable_sendkey'(validto, i,''), FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/input_Reference Number'), CustomKeywords.'commons.actions.checkvariable_sendkey'(referencenumber, i,''), FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Issuing Authority'),  CustomKeywords.'commons.actions.checkvariable_sendkey'(issuingauthority, i,''), FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Issuing Country'), CustomKeywords.'commons.actions.checkvariable_sendkey'(issuingcountry, i,''), FailureHandling.STOP_ON_FAILURE)

    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Document Verified'),  CustomKeywords.'commons.actions.checkvariable_sendkey'(documentverified, i,''), FailureHandling.STOP_ON_FAILURE)

	//FBE has not supproted attach the image
    WebUI.sendKeys(findTestObject('PartyOnboarding/Personal/PartyRequiredDocument/Image ID_03'),  CustomKeywords.'commons.actions.checkvariable_sendkey'(imageId, i,'image' + i), FailureHandling.STOP_ON_FAILURE)
    
    WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(e_saverow))
}

WebUI.click(findTestObject('PartyOnboarding/btn_Next'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/CashDepositSameCurrency/Errors/txtarea_AccountIsClose'), 2, FailureHandling.OPTIONAL))
{
	WebUI.click(findTestObject('Object Repository/CashDepositSameCurrency/Errors/btn_GoBack'), FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/CashDepositSameCurrency/btn_CloseScreen'))	
}