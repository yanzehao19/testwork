package url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Urltest {
	public static void testOpenStream() {
		try {
			URL url=new URL("http://www.baidu.com");
			InputStream inputStream=url.openStream();
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			String string;
			while((string=bufferedReader.readLine())!=null) {
				System.out.println(string);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testOpenConnection() {
		try {
			URL url=new URL("http://www.baidu.com");
			URLConnection urlConnection=url.openConnection();
			HttpURLConnection httpURLConnection=(HttpURLConnection)urlConnection;
			int responseCode=httpURLConnection.getResponseCode();
			if(responseCode==HttpURLConnection.HTTP_OK) {
				System.err.println("成功");
				InputStream inputStream=httpURLConnection.getInputStream();
				InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
				BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
				String string;
				while ((string=bufferedReader.readLine())!=null) {
					System.out.println(string);
				}
				bufferedReader.close();
			}else {
				System.err.println("失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//testOpenStream();
		testOpenConnection();
	}
	
}
