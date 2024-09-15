package revision;

import java.io.Serializable;

public class Example1 implements Serializable{
	public String name;
	public int empID;
	
	public Example1(String name, int empID) {
		this.name=name;
		this.empID=empID;
	}
}
