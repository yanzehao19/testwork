package yzh.dataByte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class JabberClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InetAddress address = InetAddress.getByName(null);
		System.out.println("addr = " + address);
		Socket socket = new Socket(address, JabberServer.port);
		try {
			System.out.println("socket = " + socket);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			for (int i = 0; i < 10; i++) {
				out.println("clienthowdy" + i);
				String string = in.readLine();
				System.out.println(string);
			}
			out.println("END");
		} finally {
			System.out.println("closing");
			socket.close();
		}
	}

}
