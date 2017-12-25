package string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class StringReverse {
	public void swap(char[] arr,int begin,int end) {
		while(begin<end) {
			char temp=arr[begin];
			arr[begin]=arr[end];
			arr[end]=temp;
			begin++;
			end--;
		}
	}
	
	public String swapWords(String string) {
		char[ ]arr=string.toCharArray();
		swap(arr, 0, arr.length-1);
		int begin=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==' ') {
				swap(arr, begin, i-1);
				begin=i+1;
			}
		}
		return new String(arr);
	}
	
	public static void main(String[] args) throws ParseException {
		String string=" i love java";
		System.out.println(new StringReverse().swapWords(string));
		
		
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		String string2=scanner.nextLine();
		String[] sArr=string2.split(" ");
		List<String> list=new ArrayList<String>();
		list=Arrays.asList(sArr);
		
		Collections.reverse(list);
		for(String word:list) {
			System.out.println(word+" ");
		}
		
		String string3="helllo";
		for(int i =string3.length()-1;i>=0;i--) {
			char c=string3.charAt(i);
			System.out.println(c);
		}
		
		
		int m=123;
		String mString;
		mString=String.valueOf(m);
		mString=m+"";
		mString=Integer.toString(m);
		
		String nString="1234";
		int n=Integer.parseInt(nString);
		float nfloat=Float.parseFloat(nString);
		
		String str="java";
		StringBuffer buffer=new StringBuffer(str);
		
		String str1=buffer.toString();
		String str2=String.valueOf(buffer);
		
		char[ ] ch=str.toCharArray();
		
		str=String.valueOf(ch);
		
		String dateString="2017-03-07 19:00:00";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf.parse(dateString);
		
		date=new Date();
		String str12=sdf.format(date);
		
		
		
	}

}
