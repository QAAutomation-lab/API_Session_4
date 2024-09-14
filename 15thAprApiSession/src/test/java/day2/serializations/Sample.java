package day2.serializations;

public class Sample {
	
	private int empId;
	public String name;
	double salary;
	protected String company;
	public Sample(int empId, String name, double salary, String company) {
		this.empId=empId;
		this.name=name;
		this.salary=salary;
		this.company=company;
	}
	public int getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public String getCompany() {
		return company;
	}
}
/*
POJO Class: Plain old Java Object
	* its used to increase the readability and re-usability in java program
	* it contains variables and method(getter & setter)
	* it doesn;t have any naming convention for properties(data members) and methods
	* similar to java beans class but
			- Beans class will have restrictions like data members should be declared as private
			- in POJO there is not such restrictions'
	* POJO class should not override existing classes
	* POJO should not extends/implements any Class/interface
	* POJO class should be declare as public
	* Its constructor should be public

*/