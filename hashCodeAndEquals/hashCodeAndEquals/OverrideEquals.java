package hashCodeAndEquals;

import java.util.HashSet;

public class OverrideEquals {

	public static void main(String[] args) {
		//新建person对象
		Person p1=new Person("eee", 100);
		Person p2=new Person("eee", 100);
		Person p3=new Person("aaa", 200);
		Person p4=new Person("EEE", 100);
		
		
		//新建hashset对象
		HashSet set=new HashSet<>();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		
		//比较p1和p2，并打印他们的hashcode（）
		System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n",p1.equals(p2),p1.hashCode(),p2.hashCode());
		//比较p1和p4，并打印他们的hashcode（）
		System.out.printf("p1.equals(p4) : %s; p1(%d) p4(%d)\n", p1.equals(p4),p1.hashCode(),p4.hashCode());
		
		//打印set
		System.out.printf("set:%s\n", set);
		
		
	}
	
	private static class Person{
		int age;
		String name;
		
		public Person(String name,int age) {
			this.name=name;
			this.age=age;
		}
		
		public String toString() {
			return"("+name+","+age+")";
		}
		
		/**
		 * 重写hashcode
		 */
		public int hashCode() {
			int nameHash=name.toUpperCase().hashCode();
			return nameHash^age;
		}
		/**
		 * 覆盖equals方法
		 */
		public boolean equals(Object obj) {
			if(obj==null) {
				return false;
			}
			//如果是同一个对象返回true，反之返回false
			if(this==obj) {
				return true;
			}
			//判断是否类型相同
			if(this.getClass()!=obj.getClass()) {
				return false;
			}
			Person person=(Person) obj;
			return name.equals(person.name)&&age==person.age;
		}
	}

}
