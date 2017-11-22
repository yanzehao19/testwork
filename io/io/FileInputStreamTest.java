package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		byteStream();
		charStream();
	}
	public static void byteStream() throws IOException {
		String fileName = "D:"+File.separator+"hello.txt";
		 //new File()就相当于是C语言中定义一个指向“a.txt”的文件指针  
		File file =new File(fileName);
		InputStream inputStream = new FileInputStream(file);
		byte[] bs= new byte[1024];
		int count = 0;
		int temp = 0;
		while((temp=inputStream.read())!=-1) {
			bs[count++]=(byte)temp;
		}
		inputStream.close();
		System.out.print(new String(bs));
	}
	
	public static void charStream() throws IOException {
		String fileName = "D:"+File.separator+"hello.txt";
		 //new File()就相当于是C语言中定义一个指向“a.txt”的文件指针  
		File file =new File(fileName);
		char[] ch= new char[100];
		Reader reader = new FileReader(file);
		int temp= 0;
		int count= 0;
		while ((temp=reader.read())!=-1) {
			ch[count++]=(char) temp;
		}
		reader.close();
		 System.out.println("内容为"+new String(ch,0,count));  
		
	}
}
