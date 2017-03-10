package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class TestReflectConstructor {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> class1 = null;
		class1 = Class.forName("reflection.User");
		// 第一种方法，实例化默认构造方法，调用set赋值
		User user = (User) class1.newInstance();
		user.setAge(20);
		user.setName("Rollen");
		System.out.println(user);
		// 结果 User [age=20, name=Rollen]
		// 第二种方法 取得全部的构造函数 使用构造函数赋值
		Constructor<?> cons[] = class1.getConstructors();
		// 查看每个构造方法需要的参数
		for (int i = 0; i < cons.length; i++) {
			Class<?> clazzs[] = cons[i].getParameterTypes();
			System.out.print("cons[" + i + "] (");
			for (int j = 0; j < clazzs.length; j++) {
				if (j == clazzs.length - 1)
					System.out.print(clazzs[j].getName());
				else
					System.out.print(clazzs[j].getName() + ",");
			}
			System.out.println(")");
		}
		// 结果
		// cons[0] (java.lang.String)
		// cons[1] (int,java.lang.String)
		// cons[2] ()
		user = (User) cons[0].newInstance(20, "Rollen");
		System.out.println(user);
		// 结果 User [age=20, name=Rollen]

	}

}

class User {
	private int age;
	private String name;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public User(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}

}
