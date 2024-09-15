package revision;

public class Example4 {

	String name;
	private int id;
	protected double salary;
	public String city;
	
	public Example4(String name,int id,double salary,String city) {
		this.name=name;
		this.id=id;
		this.salary=salary;
		this.city=city;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public String getCity() {
		return city;
	}

}
