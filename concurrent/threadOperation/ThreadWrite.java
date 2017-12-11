package threadOperation;

public class ThreadWrite extends Thread {
	public StringBuffer buffer;

	public ThreadWrite(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		synchronized (this.buffer) {
			for (int i = 0; i < 5; i++) {
				if (!"".equals(this.buffer.toString())) {
					try {
						buffer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Write start");
				this.buffer.append("1234");
				this.buffer.notify();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("write end");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
