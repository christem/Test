package demo.base.c8.s1;

import java.util.ArrayList;
import java.util.List;

public class ListErr {
    public static void main(String[] args) {
        // 创建集合、添加元素的代码与前一个程序相同
        List books = new ArrayList<String>();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        books.add(5);

//        books.forEach(str -> System.out.println(((String)str).length())); //此处将会产生ClassCastException


        List<String> books2 = new ArrayList();
        books2.add("疯狂Android讲义");
//        books2.add(6);//此处代码将会引起编译错误
    }
}
