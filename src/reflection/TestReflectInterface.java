package reflection;

import java.io.Serializable;

public class TestReflectInterface implements Serializable {
	private static final long serialVersionUID = -2862585049955236662L;

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazz = Class.forName("reflection.TestReflectInterface");
		// 取得父类
		Class<?> parentClass = clazz.getSuperclass();
		System.out.println("clazz的父类为：" + parentClass.getName());
		// clazz的父类为：java.lang.Object
		// 获取所有的接口
		Class<?> intes[] = clazz.getInterfaces();
		System.out.println("clazz实现的接口有：");
		for (int i = 0; i < intes.length; i++) {
			System.out.println((i + 1) + "：" + intes[i].getName());
		}
		// clazz实现的接口有：
		// 1：java.io.Serializable
	}

}
