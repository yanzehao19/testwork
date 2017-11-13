package reflection;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestReflectProperties implements Serializable {
	private static final long serialVersionUID = -2862585049955236662L;

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazz = Class.forName("reflection.TestReflectProperties");
		System.out.println("===============本类属性===============");
		// 取得本类的全部属性
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			// 权限修饰符
			int mo = fields[i].getModifiers();
			String priv = Modifier.toString(mo);
			// 属性类型
			Class<?> type = fields[i].getType();
			System.out.println(priv + " " + type.getName() + " " + fields[i].getName() + ";");

		}
		System.out.println("==========实现的接口或者父类的属性==========");
		// 取得实现的接口或者父类的属性
		Field[] field1 = clazz.getFields();
		for (int i = 0; i < field1.length; i++) {
			// 权限修饰符
			int mo = field1[i].getModifiers();
			String priv = Modifier.toString(mo);
			// 属性类型
			Class<?> type = field1[i].getType();
			System.out.println(priv + " " + type.getName() + " " + field1[i].getName() + ";");
		}

	}

}
