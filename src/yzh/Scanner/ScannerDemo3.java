package yzh.Scanner;

import java.util.Scanner;

public class ScannerDemo3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double sum = 0;
		int m = 0;
		while (scan.hasNextDouble()) {
			double x = scan.nextDouble();
			m = m + 1;
			sum = sum + x;
		}
		System.out.println(m + "个数的合为" + sum);
		System.out.println(m + "个数的平均值：" + (sum / m));
	}

}
