package algorithm.search;

import java.util.Arrays;

public class BinarySearch {
	public int search(int[] number, int des) {
		int low = 0;
		int upper = number.length - 1;
		while (low <= upper) {
			int mid = (low + upper) / 2;
			if (number[mid] < des)
				low = mid + 1;
			else if (number[mid] > des)
				upper = mid - 1;
			else
				return mid;
		}
		return -1;
	}

	public void print(int[] array, String warn) {
		System.out.println(warn);
		int length = array.length;
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 6, 7, 3, 5, 9, 8 };
		BinarySearch find = new BinarySearch();

		find.print(array, "数组排序前的结果:");

		Arrays.sort(array);// Arrays中的静态方法sort()对数组排序
		find.print(array, "数组排序后的结果:");

		int m = find.search(array, 6);
		if (m != -1)
			System.out.println("\n找到6的数值的索引:" + m);
		else
			System.out.println("\n找不到这个数");
	}
}
