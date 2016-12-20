package yzh.dataByte;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Io {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*// 读文件
		FileInputStream inputStream = new FileInputStream("D:\\io.txt");
		InputStreamReader reader = new InputStreamReader(inputStream, "gbk");
		StringBuffer buffer = new StringBuffer();
		char[] buf = new char[64];
		int count = 0;
		try {
			while ((count = reader.read(buf)) != -1) {
				buffer.append(buffer, 0, count);
			}
			System.out.println(buffer.toString());
		} finally {
			reader.close();
		}*/
		//读文件
		File file= new File("D:\\io.txt");
		try{
			if(!file.exists()){
				file.createNewFile();
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write("xieru");
				fileWriter.flush();
				fileWriter.close();
			}
			FileReader fReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fReader);
			String string = reader.readLine();
			while(string!=null){
				System.out.println(string);
				string  = reader.readLine();
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		/*
		 * //写文件 String file = "D:\\io.txt"; String charset = "UTF-8";
		 * FileOutputStream outputStream = new FileOutputStream(file);
		 * OutputStreamWriter writer = new OutputStreamWriter(outputStream,
		 * charset); try{ writer.write("保存的数据"); }finally{ writer.close(); }
		 */
	}

}
