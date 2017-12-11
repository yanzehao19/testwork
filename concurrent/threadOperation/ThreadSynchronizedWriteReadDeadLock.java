package threadOperation;

public class ThreadSynchronizedWriteReadDeadLock {
	 public static void main(String[] args) {
	        StringBuffer bufer = new StringBuffer("");
	        ThreadWriteDeadLock write1 = new ThreadWriteDeadLock(bufer,"w1");
	        ThreadWriteDeadLock write2 = new ThreadWriteDeadLock(bufer,"w2");
	        ThreadWriteDeadLock write3 = new ThreadWriteDeadLock(bufer,"w3");
	        ThreadReadDeadLock read1 = new ThreadReadDeadLock(bufer,"r1");
	        ThreadReadDeadLock read2 = new ThreadReadDeadLock(bufer,"r2");
	        ThreadReadDeadLock read3 = new ThreadReadDeadLock(bufer,"r3");
	        read1.start();
	        read2.start();
	        read3.start();
	        write1.start();
	        write2.start();
	        write3.start();
	    }
}
