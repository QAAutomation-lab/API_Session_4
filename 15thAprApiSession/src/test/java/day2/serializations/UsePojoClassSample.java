package day2.serializations;

public class UsePojoClassSample {

	public static void main(String[] args) {
		Sample obj=new Sample(101,"Advik",45000,"Google");
		
		System.out.println(obj.getEmpId());
		System.out.println(obj.getName());
		System.out.println(obj.getSalary());
		System.out.println(obj.getCompany());
	}

}
