package closure;

public class FirstLambdaExpression {
	public String variable = "Class Level Variable";
	public static void main(String[] args) {
		
	}
	public void lambdaExpression(){
		String variable = "Method Local Variable";
	    String nonFinalVariable = "This is non final variable";
	    new Thread(()->{
	    	 System.out.println("->" + variable);
	         System.out.println("->" + this.variable);
	    }) .start();
	}
}
