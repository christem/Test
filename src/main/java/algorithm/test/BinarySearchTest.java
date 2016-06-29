package algorithm.test;

import java.util.Arrays;

public class BinarySearchTest {

    public static int binarySearch(int[] a, int b) {
	int start = 0;
	int end = a.length - 1;

	while (start <= end) {
	    int mid = (end + start) / 2;
	    if (a[mid] > b)
		end = mid - 1;
	    else if (a[mid] < b)
		start = mid + 1;
	    else
		return mid;
	}
	return -1;
    }

    public static void main(String[] args) {
	int[] a = { 1, 4, 2, 6, 7, 8, 11, 45, 23, 46, 3, 12, 14, 16, 18, 21 };
	Arrays.sort(a);
	for (int b : a) {
	    System.out.print(b);
	    System.out.print(",");
	}
	System.out.println();
	System.out.println(binarySearch(a, 45));
    }

}
