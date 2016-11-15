package demo.base.c8.s2;


import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String args[]) {
        List<Integer> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        System.out.print(l1.getClass() == l2.getClass());
    }
}
