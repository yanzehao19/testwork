package reflection;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestReflectMethod implements Serializable {
	private static final long serialVersionUID = -2862585049955236662L;

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazz = Class.forName("reflection.TestReflectMethod");
		Method method[] = clazz.getMethods();
		for (int i = 0; i < method.length; i++) {
			Class<?> returnType = method[i].getReturnType();
			Class<?> para[] = method[i].getParameterTypes();
			int temp = method[i].getModifiers();
			System.out.print(Modifier.toString(temp) + " ");
			System.out.print(returnType.getName() + "  ");
			System.out.print(method[i].getName() + " ");
			System.out.print("(");
			for (int j = 0; j < para.length; ++j) {
				System.out.print(para[j].getName() + " " + "arg" + j);
				if (j < para.length - 1) {
					System.out.print(",");
				}
			}
			Class<?> exce[] = method[i].getExceptionTypes();
			if (exce.length > 0) {
				System.out.print(") throws ");
				for (int k = 0; k < exce.length; ++k) {
					System.out.print(exce[k].getName() + " ");
					if (k < exce.length - 1) {
						System.out.print(",");
					}
				}
			} else {
				System.out.print(")");
			}
			System.out.println();
		}
	}
}