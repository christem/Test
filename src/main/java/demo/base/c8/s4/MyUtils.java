package demo.base.c8.s4;

import java.util.*;

public class MyUtils {
    // 下面dest集合元素类型必须与src集合元素类型相同，或是其父类
    public static <T> T copy(Collection<? super T> dest, Collection<T> src) {
        T last = null;
        for (T ele : src) {
            last = ele;
            dest.add(ele);
        }
        return last;
    }

    public static void main(String[] args) {
        List<Number> ln = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        List<Number> ln2 = new ArrayList<>();
        ln2.add(null);
        li.add(5);
        // 此处可准确的知道最后一个被复制的元素是Integer类型
        // 与src集合元素的类型相同
        Integer last = copy(ln, li);    // ①
        System.out.println(ln);
        Collections.copy(ln2,li);
        System.out.println(ln2);
    }
}