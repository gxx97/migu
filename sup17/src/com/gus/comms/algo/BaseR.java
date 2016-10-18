package com.gus.comms.algo;

/**
 * 
 * @author gus
 * 一般递归
 *
 */
public class BaseR {

	static String r = "";

	public static void main(String[] args) {
		foo1(12345);
	}

	public static void foo1(int n) {
		if (n == 0)
			return;
		System.out.print(n % 10);
		foo1(n / 10);
	}

	public static int foo2(int n) {
		if (n == 0)
			return Integer.valueOf(r);
		r += n % 10;
		return foo2(n / 10);
	}

	public static long jc(long n) {

		if (n <= 1) {

			return 1;
		}

		return n * jc(n - 1);
	}
}
