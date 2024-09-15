package revision;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example2 {

	public static void main(String[] args) {
		Example1 obj=new Example1("Advik",101);
		String fileName="file.ser";
		//Serialization
		
		try {
			FileOutputStream fos=new FileOutputStream(fileName);
			ObjectOutputStream out=new ObjectOutputStream(fos);
			//now we can serialize the object
			out.writeObject(obj);
			out.close();
			fos.close();
			System.out.println("Exmple1 object is serialized.....");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
