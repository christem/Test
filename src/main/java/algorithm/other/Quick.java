package algorithm.other;

/**
 * 快速排序
 * 
 * @author ken
 *
 */
public class Quick extends SortBase {

    public static void main(String[] args) {
	Integer[] a = new Integer[] { 1, 0, 2, -5, 6, -5, 6, 0, 0, 2, 3, 6, 9, -6, -9, -78, -11, 10, 2, 5 };
	sort(a);
	System.out.println(isSorted(a));
	show(a);
    }

    public static <T> void sort(Comparable<T>[] a) {
	sort(a, 0, a.length - 1);
    }

    private static <T> void sort(Comparable<T>[] a, int low, int right) {
	int i = low;
	int j = right;
	Comparable<T> p = a[low];
	while (i < j) {
	    while (i < j && less(p, a[j])) {
		j--;
	    }
	    if (i < j) {
		exch(a, i++, j);
	    }
	    while (i < j && less(a[i], p)) {
		i++;
	    }
	    if (i < j) {
		exch(a, i, j--);
	    }
	}
	if (i > low)
	    sort(a, low, i - 1);
	if (j < right)
	    sort(a, i + 1, right);
    }
}