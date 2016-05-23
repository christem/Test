package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class TestSort {
	public static void main(String args[]) {

		List list = new ArrayList();
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(9);
		list.add(8);
		list.add(6);
		list.add(7);
		list.add(4);
		list.add(0);
		list.add(10);
		list.add(11);
		list.add(21);
		list.add(100);
		list.add(1000);
		System.out.println(list);
		Object[] a = list.toArray();
		Arrays.sort(a);
		ListIterator i = list.listIterator();
		for (int j = 0; j < a.length; j++) {
			i.next();
			i.set(a[j]);
		}
		System.out.println(list);
	}
}
