package interfaces

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

public class OpenFDUI {

	private TestObject custRelationship(){
		String xpath = "//div[contains(@name,'_HiddenVector_jointAccountDtls:listCustRelationshipDtls:custRelationshipDt')]"
		TestObject to = new TestObject("cusRelationship")
		try {
			to.addProperty("xpath", ConditionType.EQUALS, xpath)
		}
		catch(Exception e){
			println(e)
		}
		return to
	}
}
