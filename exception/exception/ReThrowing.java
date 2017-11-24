package exception;

public class ReThrowing {

	public static void main(String[] args) {

		try {
			boolean bo=g();
			System.out.print(bo);
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}

		try {
			h();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
	}

	public static int f() throws Exception {
		/*try {
			int b = 12;
			int c;
			for (int i = 2; i >= -2; i--) {
				c = b / i;
				System.out.println("i=" + i);
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			throw e;
		}finally {
			System.out.println("testEx2, finally; return value=");
		}*/
		return 5/0;
		//throw new Exception();
	}

	public static boolean g() throws Exception {
		try {
			f();
			return false;
		} catch (Exception e) {
			System.out.println("Inside g(), e.printStackTrace()");
			e.printStackTrace(System.out);
			
			throw e;
		}finally {
			//finally 中有返回值时，上一级调用g()的方法不在捕获catch中重新抛出的throw e;
			System.out.println("testEx2, finally; return value=");
			return false;
		}
		
	}

	public static void h() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside g(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception) e.fillInStackTrace();
		}
	}
}
