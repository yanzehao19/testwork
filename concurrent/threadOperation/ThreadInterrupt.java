package threadOperation;

public class ThreadInterrupt  extends Thread{
	public boolean stop=false;
	
	public static void main(String[] args) throws InterruptedException {
		ThreadInterrupt t1=new ThreadInterrupt();
		System.out.println("app is starting");
		t1.start();
		
		Thread.sleep(3000);
		System.out.println("Interrupting t1 ....");
		t1.stop=true;
		t1.interrupt();
		Thread.sleep(3000);
		System.out.println("app is end");
		System.exit(0);
	}
	
	public void run() {
		while(!this.stop) {
			System.out.println("t1 running...........");
			try {
				Thread.sleep(3000);
			}catch (InterruptedException e) {
				System.out.println("t1 is Interrupting......");
			}
		}
		System.out.println("t1 is end");
	}

}
