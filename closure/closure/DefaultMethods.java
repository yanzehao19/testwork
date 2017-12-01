package closure;

public class DefaultMethods {

	public static void main(String[] args) {
		NormalInterface instance = new NormalInterfaceImpl();
		instance.myNormalMethod();
		instance.myDefaultMethod();
	}

}

interface NormalInterface {
	void myNormalMethod();

	void myDefaultMethod () default{
	 System.out.println("-> myDefaultMethod");
}
}
class NormalInterfaceImpl implements NormalInterface {
	@Override
	public void myNormalMethod() {
		System.out.println("-> myNormalMethod");
	}
}