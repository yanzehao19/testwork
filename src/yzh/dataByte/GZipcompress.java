package yzh.dataByte;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipcompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new GZIPOutputStream(new FileOutputStream("test.gz")));
			System.out.println("writing file");
			int c;
			while ((c = in.read()) != -1)
				outputStream.write(c);
			in.close();
			outputStream.close();
			System.out.println("reading file");
			BufferedReader in2 = new BufferedReader(
					new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
			String string;
			while ((string = in2.readLine()) != null)
				System.out.println(string);
		} catch (Exception e) {

		}
		
	}

}
