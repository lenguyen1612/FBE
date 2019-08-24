package commons
import java.text.SimpleDateFormat

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import interfaces.HomePageUI as HomePageUI

public class AbtractPage {
	private int longTimeout =20;
	private int timeout = 5
	private FailureHandling failureHandling = FailureHandling.OPTIONAL
	//private WebDriver driver = DriverFactory.getWebDriver()
	HomePageUI homePageUI = new HomePageUI()

	private String userDir = System.getProperty("user.dir");
	private String filePath = userDir +  "\\PreData\\";


	private void inputOpenScreenMenuSearch(String screenName, TestObject to){
		TestObject menuSearch_txt
		try{

			waitForElementVisibled(to)
			sendkeyToElement(to,screenName + Keys.chord(Keys.ENTER))

			menuSearch_txt = homePageUI.menuSearch_txt(screenName)
			//waitForElementPresent(menuSearch_txt)
			//println "aria-invalid: " + WebUI.waitForElementPresent(menuSearch_txt, timeout, failureHandling)
			while(WebUI.waitForElementPresent(menuSearch_txt, timeout, failureHandling)==false){
				clearText(to)
				sendkeyToElement(to,screenName + Keys.chord(Keys.ENTER))
			}
		}
		catch(Exception e){
			//e.printStackTrace()
			println(e)
		}
	}

	public void waitForElementVisibled(TestObject to){
		try {
			WebUI.waitForElementVisible(to, longTimeout, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot(failureHandling)
			println(e)
		}
	}

	public void waitForElementPresent(TestObject to){
		try {
			WebUI.waitForElementPresent(to, longTimeout, failureHandling)
		}
		catch(Exception e) {
			println(e)
		}
	}

	public void waitForElementClickable(TestObject to){
		try {
			WebUI.waitForElementPresent(to, longTimeout, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot(failureHandling)
			println(e)
		}
	}

	public void waitForElementInvisible(TestObject to){
		try {
			WebUI.waitForElementPresent(to, longTimeout, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot(failureHandling)
			println(e)
		}
	}

	public void waitForAlertPresence(TestObject to){
		try {
			WebUI.waitForAlert(longTimeout, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot(failureHandling)
			println(e)
		}
	}

	/*Web Element*/   
	public void sendkeyToElement(TestObject to, String values){
		try {
			WebUI.sendKeys(to, values, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot(failureHandling)
			println(e)
		}
	}

	public void clickToElement(TestObject to){
		int count = 0
		try {
			WebUI.click(to, failureHandling)
		}
		catch(Exception e) {
			println(e)
		}
	}

	private String getAttributeValue(TestObject to, String attributename){
		String values
		try {
			return values = WebUI.getAttribute(to, attributename, failureHandling)
			println "tracking values: " + values
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
		return values
	}

	private String getTextElement(TestObject to){
		String values=""
		try {
			return values = WebUI.getText(to, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
		return values
	}

	private int countElementNumberOfTheList(TestObject to, String locator){
		String values = ""
		WebDriver driver = DriverFactory.getWebDriver()
		try {
			List <WebElement> listElements = driver.findElements(By.xpath(locator))
			return values = listElements.size()
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
		return values
	}

	/**
	 * For specific case
	 * */
	private void checkTheCheckbox(TestObject to){
		try {
			String valuesattribute = WebUI.getAttribute(to, "aria-checked")
			if(valuesattribute.equals("false")){
				WebUI.check(to, failureHandling)
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	/**
	 * Using click the radio/checkbox by Selenium
	 * */
	private void clickElementBySelenium(WebElement element){
		try{
			if(!element.isSelected()){
				element.click()
			}
		}
		catch (Exception e){
			println (e)
		}
	}

	/**
	 * Using un-click the radio/checkbox by Selenium
	 * */
	private void unclickElementBySelenium(WebElement element){
		try{
			if(element.isSelected()){
				element.click()
			}
		}
		catch (Exception e){
			println (e)
		}
	}

	/**
	 * For specific case
	 * */
	private void uncheckTheCheckbox(TestObject to){
		try {
			String valuesattribute = WebUI.getAttribute(to, "aria-checked")
			if(valuesattribute.equals("true")){
				WebUI.check(to, failureHandling)
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private boolean isControlPresence(TestObject to){
		boolean values
		try {
			return values = WebUI.verifyElementPresent(to,longTimeout, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private boolean isControlVisibled(TestObject to){
		boolean values = false
		try {
			values =  WebUI.verifyElementVisible(to, failureHandling)
			println "isControlVisibled"
		}
		catch(Exception e) {
			println(e)
		}
		return values
	}

	private void switchToIframe(TestObject to){
		try {
			WebUI.switchToFrame(to, longTimeout, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void doubleClickToElement(TestObject to){
		try {
			WebUI.doubleClick(to, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void moveMouseToElement(TestObject to){
		try {
			WebUI.mouseOver(to, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void rightClick(TestObject to){
		try {
			WebUI.rightClick(to, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void dragAndDropSourceTarget(TestObject from, TestObject to){
		try {
			WebUI.dragAndDropToObject(from, to,failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void sendKeyboardToElment(TestObject to, String values, Keys tab){
		try {
			WebUI.sendKeys(to, values + tab,failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	// JavascriptExecutor
	private void excuteJavascriptToBrowser(String scripts){
		try {
			WebUI.executeJavaScript(scripts, null, FailureHandling.STOP_ON_FAILURE)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void scrollDownDropDownList(TestObject to){
		try {
			WebElement element = WebUiCommonHelper.findWebElement(to, longTimeout)
			WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(element))
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void clickToElementByJavascript(TestObject to){
		try {
			WebElement element = WebUiCommonHelper.findWebElement(to, longTimeout)
			WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(element))
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void sendKeyToElementByJavascript(TestObject to, String values){
		try {
			WebElement element = WebUiCommonHelper.findWebElement(to, longTimeout)
			WebUI.executeJavaScript("arguments[0].setAttribute('value', '" + values + "')", Arrays.asList(element))
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void removeAttributeInDOM(TestObject to, String attributeName){
		try {
			WebElement element = WebUiCommonHelper.findWebElement(to, longTimeout)
			WebUI.executeJavaScript("arguments[0].removeAttribute('" + attributeName + "'", Arrays.asList(element))
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void setAttributeInDOM(TestObject to, String attributeName, String values){
		try {
			WebElement element = WebUiCommonHelper.findWebElement(to, longTimeout)
			WebUI.executeJavaScript("arguments[0].setAttribute('" + attributeName + "','" + values + "'", Arrays.asList(element))
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void navigateToUrlByJS(TestObject to, String url){
		try {
			WebElement element = WebUiCommonHelper.findWebElement(to, longTimeout)
			WebUI.executeJavaScript("windown.location = '" + url + "'")
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private void uploadSingleFileBySendKeyToElement(TestObject openButtonlocator, TestObject uploadButtonlocator, String filePath){
		try {
			WebElement element = WebUiCommonHelper.findWebElement(to, longTimeout)
			WebUI.sendKeys(openButtonlocator, filePath, failureHandling)
			WebUI.click(uploadButtonlocator, failureHandling)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	//	def uploadMultiFilesBySendKeyToElement(TestObject openButtonlocator, TestObject uploadButtonlocator, String filePath){
	//		try {
	//			WebElement element = WebUiCommonHelper.findWebElement(to, longTimeout)
	//			WebUI.sendKeys(openButtonlocator, filePath, failureHandling)
	//			WebUI.click(uploadButtonlocator, failureHandling)
	//			KeywordUtil.markPassed("uploadSingleFileBySendKeyToElement Passed")
	//		}
	//		catch(Exception e) {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailed("Fail to upload single file - uploadSingleFileBySendKeyToElement Failed")
	//		}
	//	}

	private String isverifyDropDownList(TestObject to, String[] listitems){
		String values = ""
		int k = 0
		try {
			List<WebElement> elements = WebUI.findWebElements(to,longTimeout )
			//check the number items
			int elementSize = elements.size()
			int listItemssize = listitems.size()
			if (elementSize==listItemssize)
			{
				for(WebElement element: elements)
				{
					for (String list: listitems)
					{
						if(element.getText().trim().equals(list.trim())){
							k += 1
							//KeywordUtil.logInfo("k: " + k + " element " + element.getText() + " list " + list)
						}
					}
				}
				if(elements.size().equals(k)){
					values ="PASSED"
				}
			}
			else
			{
				values ="FALSE"
			}
		}
		catch(Exception e) {
			values ="ERROR"
			WebUI.takeScreenshot()
			println(e)
		}
		return values
	}

	private String verifyEquals(TestObject to, String expected){
		String values = ""
		try {
			if (WebUI.verifyElementText(to, expected, failureHandling))
			{
				values = "PASSED"
			}
			else			{
				values = "FALSE"
			}

		}
		catch(Exception e) {
			values = "ERROR"
			WebUI.takeScreenshot()
			println(e)
		}
		return values
	}

	private String verifyEqualsString(String actual, String expected){
		String values
		try {
			if (actual.equals(expected))
			{
				values = "PASSED"
			}
			else			{
				values = "FALSE"
			}

		}
		catch(Exception e) {
			values = "ERROR"
			WebUI.takeScreenshot()
			println(e)
		}
		return values
	}

	private void highlightElement (TestObject objectto) {
		WebDriver driver = DriverFactory.getWebDriver()
		try {
			WebElement element = WebUiCommonHelper.findWebElement(objectto, 20);

			for (int i = 0; i < 5; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver
				js.executeScript("arguments[0].style.border='2px groove red'",element)
			}

		} catch (Exception e) {
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private String[] splitString (String valueString) {
		String[] ar_String =  valueString.split("\\|");
		return ar_String;
	}

	private void clearText(TestObject to){
		try{
			WebUI.clearText(to, failureHandling)
			WebUI.waitForElementVisible(to, longTimeout)
		}
		catch(Exception e){
			WebUI.takeScreenshot()
			println(e)
		}
	}

	private String[][] getStepAndResultsFromString(String str){

		String[] original_list = str.split('\\|')
		String [] temp
		int number = original_list.length
		String[][] row_results = new String[number][2]
		try{
			for (int i = 0; i < row_results.length; i++) {
				for (int j = 0; j < row_results[i].length; j++) {
					temp = original_list[i].split(",")
					row_results[i][j] = temp[j]
				}
			}
		}
		catch(Exception e){
			println(e)
		}
		return row_results

	}

	private boolean isVerifyCharacterInTheString(String originalString, String findString){
		boolean values =true
		try{
			if(originalString.contains(findString)){
				values = true
			}
			else {values =false}
		}
		catch(Exception e){
			values =false
			println (e)
		}
		return values
	}

	private String getAllTextInThePage (){
		String values = WebUI.executeJavaScript("return document.documentElement.innerText;",null).toString()
		return values
	}

	/**
	 * Solve the ArrayIndexOutOfBoundsException error
	 * */
	private String replaceArrayIndexOutOfBoundsException(String s_variable, int i, String _replace){
		String[] ar_variable = s_variable.split("\\|");
		String temp = ''
		try{
			temp =  ar_variable[i].trim()
		}catch(ArrayIndexOutOfBoundsException e){
			temp = _replace
		}
		return temp
	}

	private String changeFormatDate(String strDate, String patternFrom, String patternTo){
		Date date1
		String date2
		try{
			date1 = new SimpleDateFormat(patternFrom).parse(strDate)
			println "date1: " + date1
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternTo)
			date2 = simpleDateFormat.format(date1)
		}
		catch(Exception e){
			println(e)
		}
		return date2
	}

	private String getAlphaNumericString(int n)
	{
		StringBuilder sb = new StringBuilder(n);
		try {
			// chose a Character random from this String
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+
					"0123456789"+
					"abcdefghijklmnopqrstuvxyz";

			// create StringBuffer size of AlphaNumericString
			for (int i = 0; i < n; i++) {

				// generate a random number between
				// 0 to AlphaNumericString variable length
				//random() returns a random number from 0.0 to 0.9, so we multiply it by the length of string, (int) get the integer
				int index = (int)(AlphaNumericString.length()* Math.random());

				// add Character one by one in end of sb
				sb.append(AlphaNumericString.charAt(index));

				println "sb: " + sb.toString()
			}
		}
		catch(Exception e){
			println(e)
		}
		return sb.toString()
	}
}