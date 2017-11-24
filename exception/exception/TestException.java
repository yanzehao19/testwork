package exception;

public class TestException {

	public static void main(String[] args) {
		TestException testException1 = new TestException();
		try {
			testEx();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TestException() {

	}

	public static void testEx() throws Exception {
		boolean ret = false;
		try {
			//ret = testEx1();
			testEx1();
		} catch (Exception e) {
			System.out.println("testEx, catch exception");
			/*ret = false;*/
			throw e;
		} finally {
			System.out.println("testEx, finally; return value=" );
			//return ret;
		}
	}

	public static boolean testEx1() throws Exception {
		boolean ret = true;
		try {
			//ret = testEx2();
			testEx2();
			/*if (!ret) {
				return false;
			}
			System.out.println("testEx1, at the end of try");*/
			//return ret;
		} catch (Exception e) {
			System.out.println("testEx1, catch exception");
			/*ret = false;
			e.printStackTrace(System.out);*/
			throw e;
		} finally {
			System.out.println("testEx1, finally; return value=" );
			return ret;
		}
	}

	public static void testEx2() throws Exception {
		boolean ret = true;
		try {
			int b = 12;
			int c;
			for (int i = 2; i >= -2; i--) {
				c = b / i;
				System.out.println("i=" + i);
			}
			//return true;
		} catch (Exception e) {
			System.out.println("testEx2, catch exception");
			/*ret = false;
			e.printStackTrace(System.out);*/
			throw e;
		} finally {
			System.out.println("testEx2, finally; return value=" );
		//return ret;
		}
	}

}
