package yzh.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class RegexMatchesAppend {
	private static String REGEX = "a*b";
	private static String INPUT = "aabfooaabfooabfoob";
	private static String REPLACE = "-";

	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		// 获取matcher对象
		Matcher m = p.matcher(INPUT);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, REPLACE);
		}
		System.out.println(sb.toString());
		m.appendTail(sb);
		System.out.println(sb.toString());
	}

}
