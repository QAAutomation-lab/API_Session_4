package apisession.day1;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

public class JSONObjectExample1 {

	@Test
	public void testJSONObject() {
		JSONObject ref=new JSONObject();
		//to insert data in JSONObject use put()
		ref.put("EmpName", "Advik");
		ref.put("EmpID", 123);
		ref.put("City", "Pune");
		System.out.println("JSONObject elements: "+ref);
		System.out.println("value for key EmpName: "+ref.get("EmpName"));
		System.out.println("All keys in JSONObject: "+ref.keySet());
		System.out.println("All values in JSONObject: "+ref.values());
	}
	
	@Test
	public void testMapToJSONString() {
		Map ref=new HashMap();
		//to insert data in JSONObject use put()
		ref.put("EmpName", "Advik");
		ref.put("EmpID", 123);
		ref.put("City", "Pune");
		System.out.println("MAP elements: "+ref);
		//converting MAP into JSONString
		String jsonString=JSONValue.toJSONString(ref);
		System.out.println("Converted Map into JSONString and value is:\n\t\t" +jsonString);
	}
	
	@Test
	public void testJSONStringConversionIntoJSONObject() {
		String jsonString="{\"City\":\"Pune\",\"EmpID\":123,\"EmpName\":\"Advik\"}";
		//String to Object conversion
		Object obj=JSONValue.parse(jsonString);
		//type cast Object into JSONObject
		JSONObject ref=(JSONObject)obj;
		System.out.println("JSON Object value: "+ref);
		
		//get value from JSONObject
		Object ob=ref.get("City");
		//in order to get String class property we need to downcast it to String class
		String s1=(String)ob;
		System.out.println("Char count: "+s1.length());		
	}
}
