package day2.serializations;
public class Company{
	String name;
	public int id;
	private double salary;
	public Company(String name,int id,double salary) {
		this.name=name;
		this.id=id;
		this.salary=salary;
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
}
class Tester {

	public static void main(String[] args) {
		Company c1=new Company("IBM",123,45000.56);
		System.out.println(c1.getName());
		System.out.println(c1.getSalary());
		System.out.println(c1.getId());
	}

}
/*
POJO class: Plain old java object
	* it increases the readability and re-usability of a java program
	* it contain variables and methods(getter & settter)
	* POJO class doesn't have any naming convention for properties(data members) and method
	* this looks like similar to Java Beans class but
			* Beans class will have restrictions like data member should be declared as private
			* POJO class doesn't have any restrictions
	
POJO  class shouldn't be
	* Pojo classes shouldn't override existing classes
	* Predefined interfaces shouldn't be implemented by a POJO class
	* Predefined annotations shouldn't be present in a POJO class



*/