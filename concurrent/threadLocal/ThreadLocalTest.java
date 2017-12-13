package threadLocal;

public class ThreadLocalTest {
	ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	ThreadLocal<String> stringLocal = new ThreadLocal<String>();
	ThreadLocal<Long> longLocal1=new ThreadLocal<Long>();

	public void set() {
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
		longLocal1.set( 2L);
	}

	public long getLong() {
		return longLocal.get();
	}

	public String getString() {
		return stringLocal.get();
	}
	
	public long getLong1() {
		return longLocal1.get();
	}

	public static void main(String[] args) throws InterruptedException {
		final ThreadLocalTest test = new ThreadLocalTest();

		test.set();
		System.out.println(test.getLong());
		System.out.println(test.getString());
		System.out.println(test.getLong1());

		Thread thread = new Thread() {

			public void run() {
				test.set();
				System.out.println(test.getLong());
				System.out.println(test.getString());
				System.out.println(test.getLong1());
			}

		};

		thread.start();
		//thread.start();
		thread.join();

		System.out.println(test.getLong());
		System.out.println(test.getString());
		System.out.println(test.getLong1());

	}

}
