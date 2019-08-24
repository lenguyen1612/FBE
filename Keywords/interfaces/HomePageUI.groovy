package interfaces

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

public class HomePageUI {

	private TestObject menuSearch_txt(String screenName){

		String xpath = "//span[text()='" + screenName + "']"
		println xpath
		TestObject to = new TestObject("menuSearch_txt")
		to.addProperty("xpath", ConditionType.EQUALS, xpath)
		return to
	}
}
