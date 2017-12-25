package comparableandcomparator;

import java.util.Arrays;

public class Person implements Comparable<Person>{
	String name;
	int age;
	public Person(String name,int age)	{
		super();
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	@Override
	public int compareTo(Person p) {
		return this.age-p.getAge();
	}
	
	public static void main(String[] args) {
		Person[] people=new Person[] {new Person("111", 20),new Person("22", 10)};
		System.out.println("排序前");
		for(Person person:people) {
			System.out.println(person.getName()+":"+person.getAge());
		}
		//Arrays.sort(people);
		
		Arrays.sort(people,new PersonComparator());
		 System.out.println("\n排序后");
	        for (Person person : people)
	        {
	            System.out.println(person.getName()+":"+person.getAge());
	        }
	}
}
