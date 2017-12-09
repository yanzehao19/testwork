package jvm;
/**
 * @Described：重载测试
 * @author lenovo
 *
 */
public class OverLoadTestCase {
	 public static void say(Object obj){ System.out.println("Object"); }
	 public static void say(char obj){ System.out.println("char"); }
	 public static void say(int obj){ System.out.println("int"); }
	 
	 public static void say(long obj){ System.out.println("long"); }
	 
	     public static void say(float obj){ System.out.println("float"); }
	 
    public static void say(double obj){ System.out.println("double"); }
 
     public static void say(Character obj){ System.out.println("Character"); }

   public static void say(Serializable obj){ System.out.println("Serializable"); }
 
	    public static void say(char... obj){ System.out.println("char..."); }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	public static void main(String[] args) {
		// T OverLoadTestCase.say('a');ODO Auto-generated method stub
		 OverLoadTestCase.say('a');
	}

}
