package apisession.day1;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestJSONFileCreation {
	@Test
	public void testJSONFile() {
		JSONObject emp1=new JSONObject();
		emp1.put("firstName", "Advik");
		emp1.put("lastName", "Gupta");
		emp1.put("company", "Google");
		
		JSONObject emp2=new JSONObject();
		emp2.put("firstName", "Tarun");
		emp2.put("lastName", "Mehta");
		emp2.put("company", "TCS");
		
		JSONObject empDetails1=new JSONObject();
		empDetails1.put("Employee1", emp1);
		
		JSONObject empDetails2=new JSONObject();
		empDetails2.put("Employee2", emp2);
		
		
		JSONArray jArray=new JSONArray();
		jArray.add(empDetails1);
		jArray.add(empDetails2);		
		System.out.println("JSONArray :"+jArray);
		
		
		//write JSON Content into JSON file
		
		try {
			FileWriter fw=new FileWriter(".\\src\\test\\resources\\testData\\employee.json");
			fw.write(jArray.toJSONString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("JSON file created......");
	}
}
