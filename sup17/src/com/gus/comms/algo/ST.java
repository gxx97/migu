package com.gus.comms.algo;

import java.util.Stack;

/**
 * 
 * @author Administrator 二分排序
 */
public class ST {

	public static int[] nums = { 99, 7, 3, 8, 5, 9, 32, 1, 99 };

	public static void main(String[] args) {
		// mp(false);

		// quick(nums);

		quicksort(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	public static void mp(boolean s) {

		int tmp = 0;
		int size = nums.length;
		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size - i - 1; j++) {

				if (s) {
					if (nums[j] > nums[j + 1]) {
						tmp = nums[j];
						nums[j] = nums[j + 1];
						nums[j + 1] = tmp;
					}
				} else {
					if (nums[j] < nums[j + 1]) {
						tmp = nums[j];
						nums[j] = nums[j + 1];
					}
				}

			}
		}
	}

	public static void quickSort(int[] numbers, int low, int high) {
		if (low < high) {
			int middle = getMiddle(numbers, low, high); // 将numbers数组进行一分为二
			quickSort(numbers, low, middle - 1); // 对低字段表进行递归排序
			quickSort(numbers, middle + 1, high); // 对高字段表进行递归排序
		}
	}

	public static void quicksort(int[] array) {
		if (array == null || array.length == 1)
			return;
		// 存放开始与结束索引
		Stack<Integer> s = new Stack<Integer>();
		// 压栈
		s.push(0);
		s.push(array.length - 1);
		// 利用循环里实现
		while (!s.empty()) {
			int right = s.pop();
			int left = s.pop();
			// 如果最大索引小于等于左边索引，说明结束了
			if (right <= left)
				continue;

			int i = getMiddle(array, left, right);
			if (left < i - 1) {
				s.push(left);
				s.push(i - 1);
			}
			if (i + 1 < right) {
				s.push(i + 1);
				s.push(right);
			}
		}
	}

	public static int getMiddle(int[] numbers, int low, int high) {
		int temp = numbers[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && numbers[high] >= temp) {
				high--;
			}
			numbers[low] = numbers[high];// 比中轴小的记录移到低端
			while (low < high && numbers[low] <= temp) {
				low++;
			}
			numbers[high] = numbers[low]; // 比中轴大的记录移到高端
		}
		numbers[low] = temp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}
}
