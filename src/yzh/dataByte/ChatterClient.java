package yzh.dataByte;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.omg.CORBA.PRIVATE_MEMBER;

public class ChatterClient extends Thread {

	private  DatagramSocket s;
	private  InetAddress hostAddress;
	private byte[] buf = new byte[1000];
	private DatagramPacket dPacket = new DatagramPacket(buf, buf.length);
	private int id ;
	
	public ChatterClient(int identifier){
		id = identifier;
		try{
			s = new DatagramSocket();
			hostAddress = InetAddress.getByName("localhost");
		}catch(UnknownHostException e){
			System.err.println("Cannot find host");
			System.exit(1);
		}catch (SocketException e) {
			// TODO: handle exception
			System.err.println("Can't open socket");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("ChatterClient starting");
	}

	public void run(){
		try{
			for(int i=0; i<25;i++){
				String outMessage = "Client #"
						+id + ",message#" +i;
				s.send(Dgram.toDatagram(outMessage, hostAddress, CharterServer.INPORT));
				s.receive(dPacket);
				String rcvd = "Client#"+id+",rcvd from"+
				dPacket.getAddress()+","+
						dPacket.getPort()+":"+
				Dgram.toString(dPacket);
				System.out.println(rcvd);
			}
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
			new ChatterClient(i).start();
	}

}
