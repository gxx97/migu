package com.gus.comms.algo;

import java.util.Stack;

/**
 * 
 * @author gus
 * 
 *         O(1) 次找出数组最大、最小值
 *
 */
public class StackMaxMin {

	static Stack<Integer> s = new Stack<Integer>();

	static Stack<Integer> min = new Stack<Integer>();

	static Stack<Integer> max = new Stack<Integer>();

	static int[] n = { 3, 5, 1, 1, 1, 7, 532, 53, 1, 2, 8, 3, 9 };

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < n.length; i++) {
			push(n[i]);
		}
		for (int i = 0; i < 7; i++) {
			pop();
		}
		watchStack();
	}

	public static void push(int num) {

		s.push(num);

		if (min.size() == 0 || num <= min.peek()) {
			min.push(num);
		}

		if (max.size() == 0 || num >= max.peek()) {
			max.push(num);
		}
	}

	public static int pop() {

		if (s.size() == 0) {
			return 0;
		}

		if (s.peek().equals(max.peek())) {
			max.pop();
		}

		if (s.peek().equals(min.peek())) {
			min.pop();
		}

		return s.pop();
	}

	public static int peekMax() {
		return max.peek();
	}

	public static int peekMin() {
		return min.peek();
	}

	public static void watchStack() {

		System.out.println(s + "\n" + min + "\n" + max + "\n==================\n");
	}

}
