package yzh.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GreetingClient {

	public static void main(String[] args) {
		// String serverName = args[0];
		// int port = Integer.parseInt(args[1]);
		int port = 6066;
		String serverName = "localhost";
		try {
			System.out.println("2 Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);
			System.out.println("2 Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF("2 Hello from client" + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("2 Server says " + in.readUTF());
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
