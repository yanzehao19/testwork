package io;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MemoryIOStreamTest {
	public static void main(String[] args) throws IOException {
		String string = "Hello";
		ByteArrayInputStream inputStream= new ByteArrayInputStream(string.getBytes());
		System.out.println("Convertingcharacters to Upper case " );
		int c ;
		for(int y=0;y<1;y++) {
			while((c=inputStream.read())!=-1) {
				System.out.println(Character.toUpperCase((char)c));  
			}
			inputStream.reset();
		}
	}
}
