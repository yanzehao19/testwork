package io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketIOTest {

	public static void main(String[] args) throws IOException {
		int port = 8888;
		ServerSocket server=new ServerSocket(port);
		Socket socket = server.accept();   
	      Reader reader = new InputStreamReader(socket.getInputStream());    
	      char chars[] = new char[64];    
	      int len;    
	      StringBuilder sb = new StringBuilder();    
	      while ((len=reader.read(chars)) != -1) {    
	         sb.append(new String(chars, 0, len));    
	      }    
	      System.out.println("from client: " + sb);    
	      reader.close();    
	      socket.close();    
	      server.close();    
	}
	
	public static void client() throws Exception {   
	      String host = "127.0.0.1";  
	      int port = 8888;  
	      Socket client = new Socket(host, port);  
	      Writer writer = new OutputStreamWriter(client.getOutputStream());    
	      writer.write("Hello Server.");    
	      writer.flush();  
	      writer.close();    
	      client.close();    
	   }    

}
