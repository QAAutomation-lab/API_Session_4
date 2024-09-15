package revision;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example3 {

	public static void main(String[] args) {
		Example1 ref;
		String filePath="file.ser";
		try {
			FileInputStream fis=new FileInputStream(filePath);
			ObjectInputStream in=new ObjectInputStream(fis);
			//Converting serialized object back into normal Object
			ref=(Example1)in.readObject();
			in.close();
			fis.close();
			System.out.println("name from Example1 class: "+ref.name);
			System.out.println("empId from Example1 class: "+ref.empID);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
