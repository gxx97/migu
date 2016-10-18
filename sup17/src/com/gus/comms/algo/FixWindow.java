package com.gus.comms.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Administrator 栈内最大值
 */
public class FixWindow {

	public static void main(String[] args) throws InterruptedException {
		int[] num = { 0, 342, 9, 1111, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 100, 14, 15, 231, 123, 4324, 5, 3, 123,
				21321, 312, 321, 3 };
		Stack<Integer> s = new Stack<Integer>();
		for (int i = num.length - 1; i >= 0; i--) {
			s.push(i);
		}
		int step = 0;

		int _step = 0;
		List<Integer> res = new ArrayList<>();
		// 不满足窗口长度
		while (s.size() >= num.length) {
			int cnt = 0;
			// 每次移动当前下标
			for (int i = s.peek(); i < s.peek() + num.length; i++) {
				step++;
				if (cnt < num[i]) {
					_step++;
					cnt = num[i];
				}
			}
			res.add(cnt);
			// 下标弹出
			s.pop();
		}
		System.out.println(num.length + "--" + step + "----" + _step);
		System.out.println(res);
	}
}
