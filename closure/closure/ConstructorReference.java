package closure;

public class ConstructorReference {

	public static void main(String[] args) {
		MyInterface in = MyClass::new;
		System.out.println("->" + in.getMeMyObject());

		EmlpoyeeProvider provider = Employee::new;
		Employee emp = provider.getMeEmployee("John", 30);
		System.out.println("->Employee Name: " + emp.name);
		System.out.println("->Employee Age: " + emp.age);
	}

}

interface MyInterface {
	MyClass getMeMyObject();
}

interface EmlpoyeeProvider {
	Employee getMeEmployee(String s, Integer i);
}

class MyClass {
	MyClass() {
	}
}

class Employee {

	String name;

	Employee(String name) {
		this.name = name;
	}

	public static int myCompare(Employee emp1, Employee emp2) {
		return emp1.name.compareTo(emp2.name);
	}

	Integer age;

	Employee(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
}