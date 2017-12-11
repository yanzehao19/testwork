package threadOperation;

public class ThreadSynchronizedWriteRead {
	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer("");
		ThreadWrite write = new ThreadWrite(buffer);
		ThreadRead read = new ThreadRead(buffer);
		read.start();
		write.start();
	}
}
