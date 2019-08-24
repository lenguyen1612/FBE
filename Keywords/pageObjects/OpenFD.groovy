package pageObjects

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commons.AbtractPage as AbtractPage

public class OpenFD {

	AbtractPage abtractPage = new AbtractPage()

	private void clickNextButton(){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/btn_Next'))
			abtractPage.clickToElement(findTestObject('Object Repository/btn_Next'))
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 *-------------Open FD by Cash-------------
	 * */

	private void inputOpenFDMenuSearch(){
		try{
			//WebUI.delay(1)
			abtractPage.inputOpenScreenMenuSearch("Open Fixed Deposit", findTestObject('Object Repository/Menu_Search'))
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}

	private void inputCustomerNumber(String customerNumber){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Customer Number_txt'))
			abtractPage.sendkeyToElement((findTestObject('Object Repository/OpenFD/Customer Number_txt')),customerNumber)
		}
		catch(Exception e){
			println (e)
		}
	}

	private void clickJointAccount(String jointAccount){
		List<WebElement> customerRelated_list
		try{
			if(jointAccount.equals("Yes")){
				//checking the customer relationship is displayed at least 1 person
				if(customerRelated_list.size >1){
					abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/CusRelationship_chk'))
					customerRelated_list = WebUI.findWebElements(findTestObject('Object Repository/OpenFD/CusRelationship_chk'))
					abtractPage.checkTheCheckbox(findTestObject('Object Repository/OpenFD/Joint Account'))
					clickCustRelationship()
				}
				else {
					//customer relationship less than or equal 1, joint account will un-check
					abtractPage.uncheckTheCheckbox(findTestObject('Object Repository/OpenFD/Joint Account'))
				}
			}else {
				abtractPage.uncheckTheCheckbox(findTestObject('Object Repository/OpenFD/Joint Account'))
			}
		}
		catch(Exception e){
			println (e)
		}
	}

	private void clickCustRelationship(){
		List<WebElement> customerRelated_list = WebUI.findWebElements(findTestObject('Object Repository/OpenFD/CusRelationship_chk'))
		try{
			for(WebElement element : customerRelated_list){
				//click all customers
				element.click()
			}
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputCurrency(String currency){
		try{
			if(!currency.trim().equals("")){
				abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Currency_ddl'))
				abtractPage.clearText(findTestObject('Object Repository/OpenFD/Currency_ddl'))
				abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Currency_ddl'),currency)
			}
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputBranch(String branch){
		try{
			if(!branch.trim().equals("")){
				abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Branch_txt'))
				abtractPage.clearText(findTestObject('Object Repository/OpenFD/Branch_txt'))
				abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Branch_txt'),branch)
			}
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputSubProduct(String subProduct){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Sub-Product_ddl'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Sub-Product_ddl'), " ")
			WebUI.delay(1)
			//abtractPage.scrollDownDropDownList(findTestObject('Object Repository/OpenFD/Sub-product_list'))
			abtractPage.clearText(findTestObject('Object Repository/OpenFD/Sub-Product_ddl'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Sub-Product_ddl'), subProduct)
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputMoOfPayment(String modeOfPayment){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Mode of Payment_ddl'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Mode of Payment_ddl'),modeOfPayment)
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputMultipleFundingAccounts(String modeOfPayment, String multipleFundingAccount){
		try{
			//			if(modeOfPayment.trim().equals("Cheque") || modeOfPayment.trim().equals("Transfer")){
			//				abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Multiple Funding Accounts_ddl'))
			//				abtractPage.clickToElement(findTestObject('Object Repository/OpenFD/Multiple Funding Accounts_ddl'))
			//			}
			switch (modeOfPayment){
				case "Cheque":
				case "Transfer":
					abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Multiple Funding Accounts_ddl'))
					abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Multiple Funding Accounts_ddl'),multipleFundingAccount)
					break
			}
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputTransferType(String modeOfPayment, String transferType){
		try{
			//			if(modeOfPayment.trim().equals("Transfer")){
			//				abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Transfer Type_ddl'))
			//				abtractPage.clickToElement(findTestObject('Object Repository/OpenFD/Transfer Type_ddl'))
			//			}
			switch (modeOfPayment){
				case "Transfer":
					abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Multiple Funding Accounts_ddl'))
					abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Multiple Funding Accounts_ddl'),transferType)
					break
			}
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * 22/07/2019 Mode of Payment:
	 * Cash: Default BCASH - cannot edit
	 * Transfer: blank - must be inputted
	 * Cheque: Default BCHEQUE - can edit
	 * */
	private void inputContraAccountNumber(String modeOfPayment, String contraAccountNumber){
		try{
			//			if(!contraAccountNumber.trim().equals("")){
			//				abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Contra Account Number_txt'))
			//				abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Contra Account Number_txt'), contraAccountNumber)
			//			}
			switch (modeOfPayment){
				case "Cheque":
					if(!contraAccountNumber.trim().equals("")){
						abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Contra Account Number_txt'))
						abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Contra Account Number_txt'), contraAccountNumber)
					}
					break
				case "Transfer":
					abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Multiple Funding Accounts_ddl'))
					abtractPage.clickToElement(findTestObject('Object Repository/OpenFD/Multiple Funding Accounts_ddl'))
					break
			}
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputChequeNumber(String modeOfPayment, String chequeNumber){
		try{
			if(modeOfPayment.trim().equals("Cheque")){
				abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
				abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
			}
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * Setup excel file to fit for each product*/
	private void inputTerm(String term){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Term_txt'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Term_txt'), term)
		}
		catch(Exception e){
			println (e)
		}
	}

	/**
	 * Setup excel file to fit for each product*/
	private void inputTermFrequency(String termFrequency){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Term_FrequencyCode_ddl'))
			abtractPage.clearText(findTestObject('Object Repository/OpenFD/Term_FrequencyCode_ddl'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Term_FrequencyCode_ddl'),termFrequency)
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputFixedDepositAmount(String fixedDepositAmount){
		try{
			abtractPage.waitForElementVisibled(findTestObject('OpenFD/Fixed Deposit Amount_txt'))
			abtractPage.clickToElement(findTestObject('OpenFD/Fixed Deposit Amount_txt'))
			abtractPage.sendkeyToElement(findTestObject('OpenFD/Fixed Deposit Amount_txt'), Keys.chord(Keys.ARROW_LEFT) + fixedDepositAmount)
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputForeignCurrency(String foreignCurrency){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
			abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputExchangeRate(String exchangeRate){
		try{
			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
			abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
		}
		catch(Exception e){
			println (e)
		}
	}

	//	private void inputForeignAmount(String foreignAmount){
	//		try{
	//			abtractPage.waitForElementVisibled(findTestObject('PartyOnboarding/btn_Next'))
	//			abtractPage.clickToElement(findTestObject('PartyOnboarding/btn_Next'))
	//		}
	//		catch(Exception e){
	//			println (e)
	//		}
	//	}

	private void inputCapitalisationMethod(String capitalisationMethod){
		try{
			abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Capitalisation Method_ddl'))
			abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Capitalisation Method_ddl'),capitalisationMethod)
		}
		catch(Exception e){
			println (e)
		}
	}

	private void inputPayCapital_InterestToAccount(String capitalisationMethod, String payCapitalToAccount, String payInterestToAccount){
		try{
			switch (capitalisationMethod){
				case "Capitalise":
					break
				case "Payaway Interest":
					abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Pay Interest To Account_txt'))
					abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Pay Interest To Account_txt'),payInterestToAccount)
					break
				case "Manual Redemption":
					break
				case "Payaway Both":
					abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Pay Interest To Account_txt'))
					abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Pay Interest To Account_txt'),payInterestToAccount)
					abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Pay Capital To Account_txt'))
					abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Pay Capital To Account_txt'),payCapitalToAccount)
					break
				case "Payaway Capital":
					abtractPage.waitForElementVisibled(findTestObject('Object Repository/OpenFD/Pay Capital To Account_txt'))
					abtractPage.sendkeyToElement(findTestObject('Object Repository/OpenFD/Pay Capital To Account_txt'),payCapitalToAccount)
					break
			}
		}
		catch(Exception e){
			println (e)
		}
	}

	private void isCustomerIDDisplayed(){
		try{
			abtractPage.waitForElementPresent(findTestObject('Object Repository/OpenFD/CustomerID_txt'))
		}
		catch(Exception e){
			println (e)
		}
	}

	private void isCustomerCodeDisplayed(){
		try{
			abtractPage.waitForElementPresent(findTestObject('Object Repository/OpenFD/CustomerCode_lbl'))
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
}
