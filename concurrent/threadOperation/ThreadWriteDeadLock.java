package threadOperation;

public class ThreadWriteDeadLock extends Thread {
	 public StringBuffer buffer;
	    public ThreadWriteDeadLock(StringBuffer buffer, String name) {
	        super(name);
	        this.buffer = buffer;
	    }
	    public void run() {
	        synchronized (this.buffer) {
	            for (int i = 0; i < 5; i++) {
	                while (!"".equals(this.buffer.toString())) {
	                    try {
	                        buffer.wait();
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                } 
	                System.out.println("Write " + Thread.currentThread().getName() + " start");
	                this.buffer.append("123");
	                System.out.println("123");
	                this.buffer.notify();
	                System.out.println("Write " + Thread.currentThread().getName() + " end");
	            }
	        }
	    }
}
