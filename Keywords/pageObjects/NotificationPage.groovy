package pageObjects
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.lang.RuntimeException
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.NotFoundException
import org.openqa.selenium.StaleElementReferenceException

import commons.AbtractPage as AbtractPage
import report.ExcelFiles as ExcelFiles


public class NotificationPage {
	AbtractPage abtractPage = new AbtractPage()
	ExcelFiles excelFiles = new ExcelFiles ()
	private int longTimeout =30
	private int shortTimeout = 5
	private FailureHandling failureHandling = FailureHandling.OPTIONAL

	/**
	 * Select Referral, Information*/
	private void clickElement(String descOfElement){
		try{
			//TestObject element = notificationPageUI.rdo_NotificationTypes(descOfElement)
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/NotificationPage/NotificationTypes_rdo',['descElement':descOfElement]))
			abtractPage.checkTheCheckbox(findTestObject('Object Repository/NotificationPage/NotificationTypes_rdo',['descElement':descOfElement]))
		}
		catch (Exception e){
			println(e)
		}
	}

	private void clickNextButton(){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
			abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
		}
		catch (Exception e){
			println(e)
		}
	}

	/**
	 * Identify which referral will be clicked to following the taskDescription
	 * Brief:
	 * 1. Get the list Task ID text into array
	 * 2. Following the Task ID text to get the description of this referral
	 * */

	/** private void clickConfirmedApprovalPartyCreation(String taskDescription){
	 //String [] listTaskID
	 List<WebElement> listitems = WebUI.findWebElements(findTestObject('ConfirmationObject_temp/ListTaskID_txt'),longTimeout )
	 List<WebElement> listitems_rdo = WebUI.findWebElements(findTestObject('ConfirmationObject_temp/ListTaskID_rdo'),longTimeout )
	 String numberOfPage_descr = abtractPage.getTextElement(findTestObject('ConfirmationObject_temp/PageOfReferral_txt'))
	 int numberOfPage = Integer.parseInt(numberOfPage_descr.substring(numberOfPage_descr.length()-1))
	 String temp
	 try{
	 for(int num=1; num < 3 ; num++){
	 //println "num: " + num + " numberOfPage: " + numberOfPage
	 WebUI.delay(1)
	 abtractPage.waitForElementVisibled(findTestObject('ConfirmationObject_temp/ListTaskID_txt'))
	 listitems = WebUI.findWebElements(findTestObject('ConfirmationObject_temp/ListTaskID_txt'),longTimeout )
	 abtractPage.waitForElementVisibled(findTestObject('ConfirmationObject_temp/ListTaskID_rdo'))
	 listitems_rdo = WebUI.findWebElements(findTestObject('ConfirmationObject_temp/ListTaskID_rdo'),longTimeout )
	 println "listitems: " + listitems.size()
	 for(int i = 0; i < listitems.size() ; i++){
	 println "i " +i
	 listitems_rdo[i].click()
	 WebUI.delay(1)
	 //temp = abtractPage.getTextElement(notificationPageUI.txt_TaskDescription(listitems[i].getText().toString()))
	 temp = abtractPage.getTextElement(findTestObject('Object Repository/NotificationPage/TaskDescription_txt',['desc':listitems[i].getText().toString()]))
	 if(temp.equals(taskDescription)){
	 abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
	 abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
	 abtractPage.waitForElementPresent(findTestObject('ConfirmationObject_temp/TickToDenoteCompliance_chk'))
	 abtractPage.clickToElementByJavascript(findTestObject('ConfirmationObject_temp/TickToDenoteCompliance_chk'))
	 WebUI.delay(1)
	 abtractPage.waitForElementVisibled(findTestObject('ConfirmationObject_temp/ConfirmationNext_btn'))
	 abtractPage.clickToElementByJavascript(findTestObject('ConfirmationObject_temp/ConfirmationNext_btn'))
	 WebUI.delay(1)
	 //						abtractPage.waitForElementPresent(findTestObject('ConfirmationObject_temp/ConfirmationPartyPersonalCreation/PartyID_txt'))
	 //						excelFiles.writeRecordPartyID("PartyID_Confirmed.xlsx","Sheet1",0,abtractPage.getTextElement(findTestObject('ConfirmationObject_temp/ConfirmationPartyPersonalCreation/PartyID_txt')).toString())
	 break
	 }
	 }
	 abtractPage.clickToElementByJavascript(findTestObject('ProcessApprovalConfirmation/PageOfReferral_btn'))
	 }
	 }
	 catch (Exception e){
	 println(e)
	 } */

	private void clickApproved(String taskDescription){
		WebElement listitems
		WebElement listitems_rdo
		String temp
		int count = 0
		try{
			WebUI.delay(1)
			abtractPage.waitForElementVisibled(findTestObject('ProcessApprovalConfirmation/ListTaskID_txt',['description':'Referral']))
			listitems = WebUI.findWebElement(findTestObject('ProcessApprovalConfirmation/ListTaskID_txt',['description':'Referral']),longTimeout )
			abtractPage.waitForElementVisibled(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Referral']))
			listitems_rdo = WebUI.findWebElement(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Referral']),longTimeout )
			while(WebUI.verifyElementPresent(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Referral']),longTimeout , FailureHandling.OPTIONAL)){
				abtractPage.waitForElementVisibled(findTestObject('ProcessApprovalConfirmation/ListTaskID_txt',['description':'Referral']))
				listitems = WebUI.findWebElement(findTestObject('ProcessApprovalConfirmation/ListTaskID_txt',['description':'Referral']),longTimeout )
				abtractPage.waitForElementVisibled(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Referral']))
				WebUI.waitForElementClickable(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Referral']), longTimeout, FailureHandling.STOP_ON_FAILURE)
				listitems_rdo = WebUI.findWebElement(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Referral']),longTimeout )
				WebUI.delay(1)
				listitems_rdo.click()
				count +=1
				temp = abtractPage.getTextElement(findTestObject('Object Repository/NotificationPage/TaskDescription_txt',['desc':listitems.getText().toString()]))
				println "temp: " + temp
				if(temp.equals(taskDescription)){
					WebUI.delay(1)
					abtractPage.waitForElementVisibled(findTestObject('ProcessApprovalConfirmation/Approve_btn'))
					abtractPage.clickToElement(findTestObject('ProcessApprovalConfirmation/Approve_btn'))
					count =0
				}
			}
		}
		catch (StaleElementReferenceException e){
			println "count: " + count
			if(count<3){
				clickApproved(taskDescription)
			}
		}
		catch (Exception e){
			println(e)
		}
	}

	private void clickConfirmed(String taskDescription, String description, String features){
		WebElement listitems
		WebElement listitems_rdo
		String temp
		try{
			WebUI.delay(1)
			abtractPage.waitForElementVisibled(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Approval']))
			listitems_rdo = WebUI.findWebElement(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Approval']),longTimeout )

			//will be loop if the gird has row greater 0
			while(WebUI.verifyElementPresent(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Approval']),longTimeout , FailureHandling.OPTIONAL)){
				abtractPage.waitForElementVisibled(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Approval']))
				WebUI.waitForElementClickable(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Approval']), longTimeout, FailureHandling.STOP_ON_FAILURE)
				listitems_rdo = WebUI.findWebElement(findTestObject('ProcessApprovalConfirmation/ListTaskID_rdo',['description':'Approval']),longTimeout )
				//WebUI.delay(n)
				listitems_rdo.click()

				temp = abtractPage.getTextElement(findTestObject('Object Repository/NotificationPage/TaskDescription_txt',['desc':listitems.getText().toString()]))
				println "temp: " + temp
				switch(features){
					case "Personal":
					case "Enterprise":
						clickNextButton()
						clickDenoteCompliance()
						if(WebUI.waitForElementVisible(findTestObject('ProcessApprovalConfirmation/lbl_TitleEnterprise',['description':'Enterprise Related Party Status']), shortTimeout, FailureHandling.OPTIONAL)){
							/**enterprise*/
							WebUI.delay(1)
							//click Accept radio
							abtractPage.waitForElementPresent(findTestObject('Object Repository/ProcessApprovalConfirmation/Enterprise/rdo_Accept'))
							abtractPage.clickToElementByJavascript(findTestObject('Object Repository/ProcessApprovalConfirmation/Enterprise/rdo_Accept'))
							//click Next
							clickNextButton()
							break
						}
						getPartyID("Results_Data\\PartyID.xlsx","PartyID")
						clickDescription(description)
				}
			}
		}
		catch (Exception e){
			println(e)
		}
	}

	private void clickNotificationIcon(){
		try{
			//WebUI.delay(n)
			abtractPage.waitForElementVisibled(findTestObject('ProcessApprovalConfirmation/NotificationIcon_btn'))
			abtractPage.clickToElement(findTestObject('ProcessApprovalConfirmation/NotificationIcon_btn'))
		}
		catch(Exception e) {
			println (e)
		}
	}

	private void clickDescription(String strDescription){
		//TestObject to = notificationPageUI.rdo_NotificationTypes("Referral")
		TestObject to = findTestObject('Object Repository/NotificationPage/NotificationTypes_rdo',['descElement':strDescription])
		try{
			if(WebUI.waitForElementVisible(to, shortTimeout, FailureHandling.OPTIONAL)){
				//WebUI.delay(n)
				abtractPage.waitForElementVisibled(to)
				abtractPage.clickToElementByJavascript(to)
				//WebUI.delay(n)
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
				abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/btn_Next'))
			}
		}
		catch(Exception e) {
			println (e)
		}
	}

	private void clickDenoteCompliance(){
		//TestObject to = notificationPageUI.rdo_NotificationTypes("Referral")
		TestObject to = findTestObject('Object Repository/ProcessApprovalConfirmation/chk_TickToDenoteCompliance')
		try{
			//WebUI.delay(n)
			abtractPage.waitForElementPresent(to)
			abtractPage.clickToElementByJavascript(to)
			WebUI.delay(1)
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
			abtractPage.clickToElementByJavascript(findTestObject('PartyOnboarding/btn_Next'))
		}
		catch(Exception e) {
			println (e)
		}
	}

	private void getPartyID(String filename, String sheetname){
		//enterprise and personal are using same xpath, should be open one by one
		TestObject to_personalPartyType = findTestObject('Object Repository/ProcessApprovalConfirmation/PartyID/lbl_PartyType')
		TestObject to_personalPartyID = findTestObject('Object Repository/ProcessApprovalConfirmation/PartyID/lbl_PartyID')
		String strHeader, strValues
		try{
			strHeader = "Party Type"
			strValues = abtractPage.getAttributeValue(to_personalPartyType, "value")
			abtractPage.waitForElementVisibled(to_personalPartyID)
			strHeader += " | " + "Party ID"
			strValues += " | " + abtractPage.getAttributeValue(to_personalPartyID, "value")
			excelFiles.writeExcelfilesMulitpleCol(filename, sheetname, strHeader, strValues)
			WebUI.waitForPageLoad(3)
			//waiting page load, close the page just opened
			if(WebUI.waitForElementPresent(findTestObject('Object Repository/btn_ClosePage',['pageName':'Resume Party Onboarding']), shortTimeout, FailureHandling.OPTIONAL)){
				//personal
				abtractPage.clickToElement(findTestObject('Object Repository/btn_ClosePage',['pageName':'Resume Party Onboarding']))
			}else{
				//enterprise
				abtractPage.waitForElementVisibled(findTestObject('Object Repository/btn_ClosePage',['pageName':'Party Onboarding']))
				abtractPage.clickToElement(findTestObject('Object Repository/btn_ClosePage',['pageName':'Party Onboarding']))
			}

		}
		catch(Exception e) {
			println (e)
		}
	}

}