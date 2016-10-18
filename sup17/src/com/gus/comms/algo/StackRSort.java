package com.gus.comms.algo;

import java.util.Stack;

/**
 * 
 * @author gus 栈排序
 *
 */
public class StackRSort {

	static Stack<Integer> s = new Stack<Integer>();

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {

			s.push(i);
		}

		System.out.println(s);

		reverse(s);

		System.out.println(s);

	}

	public static int getRemoveLastEle(Stack<Integer> s) {

		int res = s.pop();

		if (s.isEmpty()) {
			return res;
		} else {
			int last = getRemoveLastEle(s);
			s.push(res);
			return last;
		}
	}

	public static void reverse(Stack<Integer> s) {

		if (s.isEmpty()) {
			return;
		}
		int i = getRemoveLastEle(s);
		reverse(s);
		s.push(i);
	}
}
