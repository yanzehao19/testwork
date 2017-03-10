package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestReflectGeneric {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<Integer>list=new ArrayList<Integer>();
		Method method =list.getClass().getMethod("add", Object.class);
		method.invoke(list, "Java反射机制实例。");
		System.out.println(list.get(0));
	}

}
