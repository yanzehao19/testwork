package yzh.dataByte;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

class JabberClientThread extends Thread {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private static int counter = 0;
	private int id = counter++;
	private static int threadcount = 0;

	public static int threadCount() {
		return threadcount;
	}

	public JabberClientThread(InetAddress address) {
		System.out.println("Making client " + id);
		threadcount++;
		try {
			socket = new Socket(address, MultiJabberServer.PORT);
		} catch (IOException e) {

		}
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			start();
		} catch (IOException e) {
			try {
				socket.close();
			} catch (IOException e2) {

			}
		}
	}

	public void run() {
		try {
			for (int i = 0; i < 25; i++) {
				out.println("Client" + id + ":" + i);
				String string = in.readLine();
				System.out.println(string);
			}
			out.println("END");
		} catch (IOException e) {
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
			}
			threadcount--;
		}
	}
}

public class MultiJabberClient {
	static final int MAX_THREADS = 40;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		InetAddress address = InetAddress.getByName(null);
		while (true) {
			if (JabberClientThread.threadCount() < MAX_THREADS)
				new JabberClientThread(address);
			Thread.currentThread().sleep(100);
		}
	}

}
