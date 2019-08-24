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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import internal.GlobalVariable as GlobalVariable
import pageObjects.NotificationPage as NotificationPage

KeywordLogger log = new KeywordLogger()
NotificationPage notificationPage = new NotificationPage()

String step = ""

step="1"
log.logInfo("Approval - Step0" + step + " Click Notification icon")
notificationPage.clickNotificationIcon()

step="2"
log.logInfo("Approval - Step0" + step + " Click Referral description")
notificationPage.clickReferralDescription()

step="3"
log.logInfo("Approval - Step0" + step + " Click Approval for Party")
notificationPage.clickApproveRequestPartyCreation("Supervisor Authorization required for Party Onboarding")

