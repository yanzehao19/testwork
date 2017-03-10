package reflection;

import java.lang.reflect.Field;

public class TestReflectOperateProperty {
	private String property=null;
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class<?>clazz=Class.forName("reflection.TestReflectOperateProperty");
		Object obj=clazz.newInstance();
		// 可以直接对 private 的属性赋值
		Field field=clazz.getDeclaredField("property");
		field.setAccessible(true);
		field.set(obj, "Java反射机制");
		System.out.println(field.get(obj));
	}

}
