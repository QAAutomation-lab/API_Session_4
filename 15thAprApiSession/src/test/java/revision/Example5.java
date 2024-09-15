package revision;

public class Example5 {

	public static void main(String[] args) {
		Example4 ref=new Example4("Kiran",123,45000.55,"Pune");
		System.out.println(ref.getName());
		System.out.println(ref.getId());
		System.out.println(ref.getSalary());
		System.out.println(ref.getCity());

	}

}
