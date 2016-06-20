package algorithm;

public class SortBase {

    protected static <T> boolean less(Comparable<T> a, Comparable<T> b) {
	return a.compareTo((T) b) < 0;
    }

    protected static <T> void exch(Comparable<T>[] a, int i, int j) {
	Comparable<T> temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

    public static <T> void show(Comparable<T>[] a) {
	for (Comparable<T> e : a) {
	    System.out.print(e + " ");
	}
	System.out.println();
    }

    public static <T> boolean isSorted(Comparable<T>[] a) {
	for (int i = 1; i < a.length; i++) {
	    if (less(a[i], a[i - 1]))
		return false;
	}
	return true;
    }
}