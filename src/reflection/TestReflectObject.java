package reflection;

public class TestReflectObject {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> class1 = null;
		Class<?> class2 = null;
		Class<?> class3 = null;
		// 一般采用这种形式
		class1 = Class.forName("reflection.TestReflectObject");
		class2 = new TestReflect().getClass();
		class3 = TestReflect.class;
		System.out.println("类名称   " + class1.getName());
		System.out.println("类名称   " + class2.getName());
		System.out.println("类名称   " + class3.getName());

	}

}
