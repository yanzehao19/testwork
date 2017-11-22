package io;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedIOTest {

	public static void main(String[] args) {
		PipedInputStream inputStream = new PipedInputStream();
		PipedOutputStream outputStream = new PipedOutputStream();
		try {
			outputStream.connect(inputStream);
			new Thread(new OutputstreamRunnable(outputStream)).start();
			new Thread(new InputstreamRunnable(inputStream)).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

// 输出管道流线程
class OutputstreamRunnable implements Runnable {
	private OutputStream outputStream;

	public OutputstreamRunnable(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	@Override
	public void run() {
		String string = "hello pipe";
		try {
			outputStream.write(string.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
// 输入管道流线程

class InputstreamRunnable implements Runnable {
	private InputStream inputStream;

	public InputstreamRunnable(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public void run() {
		byte[] bs = new byte[1024];
		int len = -1;
		try {
			if ((len = inputStream.read(bs)) != -1) {
				System.out.println(new String(bs, 0, len));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
