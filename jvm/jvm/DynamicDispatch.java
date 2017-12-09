package jvm;
/**
 * @Described：动态分派测试
 * @author lenovo
 *
 */
public class DynamicDispatch {

	 static abstract class Human{
		
	       public abstract void say();
		 
	    };
		 
		 static class Man extends Human{
		 
			      @Override
			
			       public void say(){
		
		            System.out.println("hi,you are a good man!");
		 
		        }
		
		     } ;
	
			 
			 
			 static class Woman extends Human{
				 
				       @Override
				 
				       public void say(){
				
			            System.out.println("hi,young lady!");
				 
			       }
				
				     } ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Human man = new Man();
		 
	       Human woman = new Woman();
		 
		         man.say();
		
		        woman.say();
	 
		       woman = new Man();
		 
		       woman.say();
	}

}
