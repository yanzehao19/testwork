package yzh.dataByte;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServeOneJabber extends Thread {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	public ServeOneJabber(Socket s) throws IOException {
		socket = s;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		start();
	}

	public void run() {
		try {
			while (true) {
				String string = in.readLine();
				if (string.equals("END"))
					break;
				System.out.println("Echoing" + string);
				out.println(string);
			}
			System.out.println("closing");
		} catch (IOException e) {

		} finally {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}

}

public class MultiJabberServer {
	static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("server started");
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				try {
					new ServeOneJabber(socket);

				} catch (IOException e) {
					socket.close();
				}
			}
		} finally {
			serverSocket.close();
		}
	}

}
