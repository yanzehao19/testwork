package yzh.dataByte;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JabberServer {
	public static final int port = 8080;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("started" + serverSocket);
		try {
			Socket socket = serverSocket.accept();
			try {
				System.out.println("connection accepted" + socket);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
						true);
				while (true) {
					String string = in.readLine();
					if (string.equals("END"))
						break;
					System.out.println("serverechoing" + string);
					out.println(string);
				}
			} finally {
				System.out.println("closeing");
				socket.close();
			}

		} finally {
			serverSocket.close();
		}
	}

}
