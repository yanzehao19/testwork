package yzh.Scanner;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 从键盘接收数据

		// next方法接收字符串
		System.out.println("next方法接收");
		// 判断是否还有输入
		if (scan.hasNext()) {
			String str1 = scan.next();
			System.out.println("输入的数据为：" + str1);
		}
		if (scan.hasNextLine()) {
			String str2 = scan.nextLine();
			System.out.println("数据：" + str2);
		}

	}

}
