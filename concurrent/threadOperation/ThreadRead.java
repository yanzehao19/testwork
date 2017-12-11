package threadOperation;

public class ThreadRead extends Thread {
	public StringBuffer buffer;

	public ThreadRead(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		synchronized (buffer) {

			for (int i = 0; i < 5; i++) {
				if ("".equals(this.buffer.toString().trim())) {
					try {
						buffer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("read start");
				System.out.println(this.buffer.toString());
				buffer.delete(0, buffer.toString().length());
				buffer.notify();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("read end");

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
