package demo.base.c7Collection.s6;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapTest {
	public static void main(String[] args) {
		 //两个map具有不同的key
		   HashMap map1=new HashMap(); 
		   map1.put("1", "A"); 
		   HashMap map2 = new HashMap(); 
		   map2.put("2", "B"); 
		   map2.put("3", "C"); 
		   map1.putAll(map2); 
		   System.out.println("map1:"+map1);
		   //两个map具有重复的key
		   HashMap map3=new HashMap(); 
		   map3.put("1", "A"); 
		   HashMap map4 = new HashMap(); 
		   map4.put("1", "B"); 
		   map4.put("3", "C"); 
		   map3.putAll(map4); 
		   System.out.println("map3:"+map3);
	}
}
