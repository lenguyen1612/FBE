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
import pageObjects.JiraLoginPage as JiraLoginPage
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

KeywordUtil logTestCase = new KeywordUtil()
logTestCase.logInfo("---Login Jira Page - Go to JIRA version---")
WebUI.openBrowser(linkJira, FailureHandling.STOP_ON_FAILURE)

JiraLoginPage jiraLoginPage = new JiraLoginPage()

logTestCase.logInfo("---Login Jira Page - Verify Login Page---")
jiraLoginPage.verifyLoginPage()
logTestCase.logInfo("---Login Jira Page - Input Username---")
jiraLoginPage.inputUsername(username)
logTestCase.logInfo("---Login Jira Page - Input Password---")
jiraLoginPage.inputPassword(password)
logTestCase.logInfo("---Login Jira Page - Click Login button---")
jiraLoginPage.clickLoginBtn()
