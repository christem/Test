package demo.base.c7Collection.s3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Description: <br/>
 * Copyright (C), 2005-2008, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class M {
	int age;

	public M(int age) {
		this.age = age;
	}
}

class N {
	int age;

	public N(int age) {
		this.age = age;
	}
}

public class TestTreeSet3 {
	public static void main(String[] args) {
		
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("a");
		treeSet.add("g");
		treeSet.add("f");
		treeSet.add("c2");
		treeSet.add("c1");
		for(String num:treeSet){
			System.out.println(num);
		}
		
//		TreeSet ts = new TreeSet(new Comparator() {
//			public int compare(Object o1, Object o2) {
//				int age1 = o1 instanceof M ? ((M) o1).age : ((N) o1).age;
//				int age2 = o2 instanceof M ? ((M) o2).age : ((N) o2).age;
//				return age1 - age2;
//
//				/*
//				 * M m1 = (M)o1; M m2 = (M)o2;
//				 * 
//				 * if (m1.age > m2.age) { return -1; } else if (m1.age ==
//				 * m2.age) { return 0; } else { return 1; }
//				 */
//			}
//		});
//		ts.add(new M(5));
//		ts.add(new M(-3));
//		ts.add(new M(9));
//		System.out.println(ts);
		
		
		
	}
}
