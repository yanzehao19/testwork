package closure;

public class AnonymousExample {
	public void anonymoutsExample() {
		String nonFinalVariable = "Non Final Example";
		String variable = "Outer Method Variable";
		new Thread(new Runnable() {
			String variable = "Runnable Class Member";

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String variable = "Run Method Variable";
				System.out.println("->" + variable);
				System.out.println("->" + this.variable);
			}
		}).start();
	}
	 public static void main(String[] arg) {
		new AnonymousExample().anonymoutsExample();
	 }
	
}

