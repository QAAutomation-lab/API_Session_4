package apisession.day1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class JSONArrayExample1 {

	@Test
	public void testJSONArray() {
		JSONArray jsonArray=new JSONArray();
		jsonArray.add("Pune");//auto up casting
		jsonArray.add(123);//Auto Boxing -->auto up casting
		jsonArray.add(true);//Auto Boxing -->auto up casting
		System.out.println("JSON Array Elements: "+jsonArray);
	}
	
	@Test
	public void testJSONArray2() {
		JSONObject ref=new JSONObject();
		//to insert data in JSONObject use put()
		ref.put("EmpName", "Advik");
		ref.put("EmpID", 123);
		ref.put("City", "Pune");
		System.out.println("JSONObject ref: "+ref);
		
		JSONObject ref2=new JSONObject();
		//to insert data in JSONObject use put()
		ref2.put("Company", "Google");
		ref2.put("Dept", "R&D");
		ref2.put("Role", "Developer");
		System.out.println("JSONObject ref2: "+ref2);
		
		JSONArray jsonArray=new JSONArray();
		jsonArray.add(ref);
		jsonArray.add(ref2);
		System.out.println("JSON Array Elements: "+jsonArray);
	}
}
