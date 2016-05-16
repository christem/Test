package common;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
	// String name = "就是不知道";
	// System.out.println(name.charAt(0));
	List<Double> list = new ArrayList<Double>();
	list.add(20D);
	list.add(50D);
	list.add(100D);
	list.add(500D);
	Double double1 = 20D;
	System.out.println(list.indexOf(double1));
    }
}
