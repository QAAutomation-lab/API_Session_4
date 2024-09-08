package apisession.day1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class ReadJSONFile {

	@Test
	public void readJSONFile() throws IOException, ParseException {
		//use FileReader to provide file location
		FileReader fr=new FileReader(".\\src\\test\\resources\\testData\\UserDetails.json");
		//create an instance of JSONParser
		JSONParser jp=new JSONParser();
		//using JSONParser instance call parse() to read content from the file
		Object obj=jp.parse(fr);
		//Convert Object into JSONObject
		JSONObject jObj=(JSONObject)obj;
		
		System.out.println("JSONObject value: "+jObj.get("name"));
		System.out.println("JSONObject value: "+jObj.get("College"));
		System.out.println("JSONObject value: "+jObj.get("Dept"));
	}
}
