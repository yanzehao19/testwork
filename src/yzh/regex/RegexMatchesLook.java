package yzh.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatchesLook {
	private static final String REGEX = "foo";
	private static final String INPUT = "foooooooooooo";
	private static Pattern pattern;
	private static Matcher matcher;

	public static void main(String[] args) {
		pattern = Pattern.compile(REGEX);
		matcher = pattern.matcher(INPUT);
		System.out.println("Current REGEX is：" + REGEX);
		System.out.println("Current INPUT is:" + INPUT);
		System.out.println("lookingAt()" + matcher.lookingAt());
		System.out.println("matches():" + matcher.matches());
	}

}
