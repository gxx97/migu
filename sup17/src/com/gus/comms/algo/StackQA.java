package com.gus.comms.algo;

import java.util.Stack;

/**
 * 
 * @author Administrator 汉娜塔
 */
public class StackQA {

	public static void main(String[] args) {
		int n = HLT.hanoP(4, "A", "B", "C");
		System.out.println(n);
	}
}

class HLT {

	public enum Action {
		NO, L_M, M_L, M_R, R_M, Move, From, To
	}

	static String SPLIT = "\t";

	public static int hanoP(int num, String left, String mid, String right) {

		Stack<Integer> ls = new Stack<>();
		Stack<Integer> ms = new Stack<>();
		Stack<Integer> rs = new Stack<>();

		ls.push(Integer.MAX_VALUE);
		ms.push(Integer.MAX_VALUE);
		rs.push(Integer.MAX_VALUE);

		for (int i = num; i > 0; i--) {
			ls.push(i);
		}

		Action[] record = { Action.NO };

		int step = 0;

		while (rs.size() != num + 1) {
			step += fStackTotStack(record, Action.M_L, Action.L_M, ls, ms, left, mid);
			step += fStackTotStack(record, Action.L_M, Action.M_L, ms, ls, mid, left);
			step += fStackTotStack(record, Action.R_M, Action.M_R, ms, rs, mid, right);
			step += fStackTotStack(record, Action.M_R, Action.R_M, rs, ms, right, mid);
		}
		return step;
	}

	public static int fStackTotStack(Action[] record, Action perNoAct, Action nowAct, Stack<Integer> fStack,
			Stack<Integer> tStack, String from, String to) {
		if (record[0] != perNoAct && fStack.peek() < tStack.peek()) {
			tStack.push(fStack.pop());
			System.out.println(Action.Move + SPLIT + tStack.peek() + SPLIT + Action.From + SPLIT + from + SPLIT
					+ Action.To + SPLIT + to);
			record[0] = nowAct;
		}
		return 1;
	}
}