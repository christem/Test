package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static void main(String[] args) {
	List<String> list = new LinkedList<String>();
	list.add("test1");
	list.add("test4");
	list.add("test2");
	list.add("test5");
	list.add("test8");
	list.add("test3");
	list.add("test7");
	list.add("test6");
	list.add(3, "test9");

	Iterator<String> iterator = list.listIterator();
	while (iterator.hasNext()) {
	    String test = iterator.next();
	    System.out.println(test);

	}
	System.out.println(list.indexOf("test8"));
    }
}
