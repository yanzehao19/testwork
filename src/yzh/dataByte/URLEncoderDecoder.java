package yzh.dataByte;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDecoder {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String string = "CSS测试";
		try{
			string = URLEncoder.encode(string, "UTF-8");
			System.out.println("encode"+string);
			string=URLDecoder.decode("%E6%AD%A6%E6%B1%89%E5%85%89%E8%B0%B7%E4%BA%A4%E9%80%9A%E5%BB%BA%E8%AE%BE%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8%E5%8D%B0%E7%AD%BE%E4%BD%BF%E7%94%A8%E7%99%BB%E8%AE%B0", "UTF-8");
			System.out.println("decode"+string);
			string = new String(string.getBytes(),"GBK");
			System.out.println("GBK"+string);
		}catch (Exception e) {
			System.out.println("others cause,change failure");
		}
	}

}
