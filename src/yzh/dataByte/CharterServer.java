package yzh.dataByte;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class CharterServer {
	static final int INPORT = 1711;
	private byte[] buf = new byte[1000];
	private DatagramPacket dPacket = new DatagramPacket(buf, buf.length);
	private DatagramSocket socket;

	public CharterServer() {
		try {
			socket = new DatagramSocket(INPORT);
			System.out.println("Server started");
			while (true) {
				socket.receive(dPacket);
				String rcvd = Dgram.toString(dPacket) + ",from address:" + dPacket.getAddress() + ",port:"
						+ dPacket.getPort();
				System.out.println(rcvd);
				String echoString = "Echoed:" + rcvd;
				DatagramPacket echo = Dgram.toDatagram(echoString, dPacket.getAddress(), dPacket.getPort());
				socket.send(echo);
			}
		} catch (SocketException e) {
			System.err.println("Can't open socket");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Communication error");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CharterServer();
	}

}
