package threadOperation;

public class ThreadReadDeadLock extends Thread {
	 public StringBuffer buffer;
	    public ThreadReadDeadLock(StringBuffer buffer, String name) {
	        super(name);
	        this.buffer = buffer;
	    }
	    public void run() {
	        synchronized (buffer) {
	            for (int i = 0; i < 5; i++) {
	                while ("".equals(this.buffer.toString().trim())) {
	                    try {
	                        buffer.wait();
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	                System.out.println("read " + Thread.currentThread().getName() + " start");
	                System.out.println(this.buffer.toString());
	                buffer.delete(0, buffer.toString().length());
	                buffer.notify();
	                System.out.println("read " + Thread.currentThread().getName() + " end");
	            }
	        }
	    }
}
