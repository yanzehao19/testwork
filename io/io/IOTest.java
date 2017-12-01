package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;

import sun.security.x509.IPAddressName;

public class IOTest {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			/*
			 * File file=new File("C:\\Users\\lenovo\\Desktop\\test.txt"); byte[] bs =new
			 * byte[4]; InputStream inputStream =new FileInputStream(file); int i=0;
			 * while((i=inputStream.read(bs))!=-1) { String string=new String(bs,"UTF-8");
			 * System.out.println(string); }
			 * 
			 */
			File file = new File("C:\\Users\\lenovo\\Desktop\\test.txt");
			File file1 = new File("C:\\Users\\lenovo\\Desktop\\testto.txt");
			FileInputStream fInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fInputStream, "utf-8");
			bufferedReader = new BufferedReader(inputStreamReader);

			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1), "GBK"));

			String string = "";
			while ((string = bufferedReader.readLine()) != null) {
				System.out.println(string);
				bufferedWriter.write(string + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
		}

	}

}
