package com.gus.comms.collection;

import java.util.Deque;
import java.util.LinkedList;

public class DequeWindow {

	public static void main(String[] args) {

		Deque<Integer> dq = new LinkedList<Integer>();

		for (int i = 0; i < 10; i++) {

			dq.add(i);
		}
		
		System.out.println(dq.pollLast());

	}
}
